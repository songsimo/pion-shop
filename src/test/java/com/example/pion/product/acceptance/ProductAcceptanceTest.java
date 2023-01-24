package com.example.pion.product.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.pion.AcceptanceTest;
import com.example.pion.product.dto.ProductResponse;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("상품 관련 기능")
public class ProductAcceptanceTest extends AcceptanceTest {
	@DisplayName("상품을 생성한다.")
	@Test
	void createProduct() {		
		// when
		ExtractableResponse<Response> response = 상품_생성_요청("상품 A", 3_000);

		// then
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}
	
	@DisplayName("상품 전체를 조회한다.")
	@Test
	void searsachProductAll() {
		// given
		상품_생성_요청("상품 A", 3_000);
		상품_생성_요청("상품 B", 6_000);
		
		// when
		ExtractableResponse<Response> response = 상품_목록_조회_요청();
		
		// then
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.jsonPath().getList("name")).contains("상품 A", "상품 B");
	}
	
	@DisplayName("상품을 조회한다.")
	@Test
	void searchProductById() {
		// given		
		상품_생성_요청("상품 A", 9_000);
		상품_생성_요청("상품 B", 6_000);
		List<ProductResponse> products = 상품_목록_조회_요청().jsonPath().getList(".", ProductResponse.class);
		ProductResponse productA = products.get(0);
		
		// when
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.when().get("/product/find/{id}", productA.getId())
				.then().log().all()
				.extract();
		
		ProductResponse responseProduct = response.jsonPath().getObject(".", ProductResponse.class);
		
		// then
		assertAll(
			() -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
			() -> assertThat(responseProduct.getId()).isEqualTo(productA.getId()),
			() -> assertThat(responseProduct.getName()).isEqualTo(productA.getName()),
			() -> assertThat(responseProduct.getPrice()).isEqualTo(productA.getPrice())
		);
	}
	
	private ExtractableResponse<Response> 상품_생성_요청(String name, int price) {
		Map<String, String> params = new HashMap<>();
		params.put("name", name);
		params.put("price", String.valueOf(price));
		
		return RestAssured.given().log().all()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(params)
				.when().post("/product")
				.then().log().all()
				.extract();
	}
	
	private ExtractableResponse<Response> 상품_목록_조회_요청() {		
		return RestAssured.given().log().all()
				.when().get("/product/all")
				.then().log().all()
				.extract();
	}
}
