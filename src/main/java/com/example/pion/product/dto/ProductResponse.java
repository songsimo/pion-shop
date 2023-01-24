package com.example.pion.product.dto;

import com.example.pion.product.domain.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ProductResponse {
	private long id;
	private String name;
	private long price;

	public static ProductResponse convert(Product product) {
		return new ProductResponse(
				product.getId(),
				product.getName(),
				product.getPrice()
		);
	}

}
