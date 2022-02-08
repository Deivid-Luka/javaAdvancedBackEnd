package com.example.demo.service;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.ProductDto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDto save(ProductDto productDto) {
        return ProductMapper.convertFrom(productRepository.save(ProductMapper.convertFromDto(productDto)));
    }

    public List<ProductDto> search(String searchCriteria) throws Exception {
        try {
            Long id = Long.valueOf(Integer.parseInt(searchCriteria));
            List<ProductDto> searchResult = new ArrayList<>();
            ProductDto searchResult2 = ProductMapper.convertFrom(productRepository.getById(id));
            searchResult.add(searchResult2);
            return searchResult;
        }catch (Exception e){
            try {
                List<ProductDto> searchResult ;
                searchResult = ProductMapper.convertFromList(productRepository.findAllByDescription(searchCriteria));
                return searchResult;
            }catch (Exception e2){
                throw new Exception("Not found");
            }
        }
    }

    public List<ProductDto> getAll() {
        return ProductMapper.convertFromList(productRepository.findAll());
    }

    public ProductDto update(ProductDto productDto, Long id) {
        return ProductMapper.convertFrom(productRepository.save(ProductMapper.convertFromUpdate(productDto, id)));
    }

    public ProductDto getProduct(Long id) {
        return ProductMapper.convertFrom(productRepository.getById(id));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
