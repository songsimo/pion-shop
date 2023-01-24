package com.example.pion.product.dto;

import com.example.pion.product.domain.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ProductRequest {
	private String name;
	private int price;
	
	public Product toEntity() {
		return new Product(
			name,
			price
		);
	}
}
