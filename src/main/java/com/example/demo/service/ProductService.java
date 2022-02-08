package com.example.demo.service;

import com.example.demo.model.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    List<ProductDto> search(String searchCriteria) throws Exception;

    ProductDto update(ProductDto productDto,Long id);

    ProductDto getProduct(Long id);

    List<ProductDto> getAll();

    void delete(Long id);
}
