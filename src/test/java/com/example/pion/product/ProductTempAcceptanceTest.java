package com.example.pion.product;

import com.example.pion.AcceptanceTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상품 관련 기능 테스트 코드")
class ProductTempAcceptanceTest extends AcceptanceTest {

    @Test
    void getString() {
    }

    @Test
    void temp() {
    }

    @Test
    void getModel() {
    }

    @DisplayName("상품을 저장하는 시나리오")
    @Test
    void saveProduct() {

        Map<String, String> body = new HashMap<>();

        body.put("name", "상품A");
        body.put("price", "1000");

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/main/save")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}