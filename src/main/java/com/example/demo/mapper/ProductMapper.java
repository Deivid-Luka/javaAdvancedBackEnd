package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.example.demo.model.ProductDto;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProductMapper {
    ModelMapper modelMapper=new ModelMapper();

    public Product convertFromDto(ProductDto productDto){
        Product product =modelMapper.map(productDto,Product.class);
        return product;
    }
    public ProductDto convertFrom(Product product){
        ProductDto productDto =modelMapper.map(product,ProductDto.class);
        return productDto;
    }

    public Product convertFromUpdate(ProductDto productDto,Long id){
        Product product= modelMapper.map(productDto,Product.class);
        product.setId(id);
        return product;
    }

    public List<ProductDto> convertFromList(List<Product> productList){
        List<ProductDto> productDtoList =new ArrayList<>();
        for (Product product:productList
             ) {
            productDtoList.add(convertFrom(product));
        }
        return productDtoList;
    }
}
