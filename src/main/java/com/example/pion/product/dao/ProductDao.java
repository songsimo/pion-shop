package com.example.pion.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pion.product.domain.Product;

@Mapper
public interface ProductDao {
	
	public long save(Product product);
	
	public List<Product> findAll();
	
	public Product findById(int id);
}
