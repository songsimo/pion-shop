package com.example.pion.product.application;

import com.example.pion.product.dao.ProductTempDao;
import com.example.pion.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTempService {

    @Autowired
    private ProductTempDao productTempDao;

    public void save(ProductRequest productRequest) {
        productTempDao.save(productRequest.toEntity());
    }
}