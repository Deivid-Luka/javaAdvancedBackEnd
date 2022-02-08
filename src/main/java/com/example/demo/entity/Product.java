package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "code")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "amount")
    private int amount;

    @Column(nullable = false, name = "price")
    private double price;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "detailed_description")
    private String detailedDescription;
}
