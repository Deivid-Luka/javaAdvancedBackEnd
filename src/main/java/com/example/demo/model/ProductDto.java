package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private int amount;

    private String name;

    private double price;

    private String description;

    private String detailedDescription;
}
