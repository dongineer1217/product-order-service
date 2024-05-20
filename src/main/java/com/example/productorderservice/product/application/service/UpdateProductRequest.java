package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domain.DiscountPolicy;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {

}
