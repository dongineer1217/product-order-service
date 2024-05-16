package com.example.productorderservice.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class ProductRepository {
    private Map<Long, Product> persistence = new HashMap<>();
    private Long sequenece = 0L;

    public void save(final Product product) {
        product.assignId(++sequenece);
        persistence.put(product.getId(), product);
    }
}
