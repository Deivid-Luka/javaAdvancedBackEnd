package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String code;

    private int amount;

    private double price;

    private String description;

    private String detailedDescription;
}
