package com.example.orm.business.service;

import com.example.orm.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    long create(ProductDto productDto);

    void update(ProductDto productDto);

    ProductDto find(long productId);

    List<ProductDto> findAll();

}
