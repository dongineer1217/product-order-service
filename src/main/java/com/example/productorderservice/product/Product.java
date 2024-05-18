package com.example.productorderservice.product;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(final String name,
                   final int price,
                   final DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

}
