package com.example.pion.product.application;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pion.product.dao.ProductDao;
import com.example.pion.product.domain.Product;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public ProductService(ProductDao productRepository) {
		this.productDao = productRepository;
	}

	public long save(ProductRequest request) {
		return productDao.save(request.toEntity());
	}

	public List<ProductResponse> findAll() {
		productDao.findAll().forEach(t -> System.out.println(t.getName()));
		return productDao.findAll().stream()
				.map(ProductResponse::convert)
				.collect(Collectors.toList());
	}
	
	public ProductResponse findBydId(int id) throws NotFoundException {
		Product product = productDao.findById(id);
		
		if(product != null) {
			return ProductResponse.convert(product);
		}
		
		throw new NotFoundException("Not Found Product");
	}
}
