package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.adapter.ProductRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {


    @Autowired
    ProductRepository repository;

    @Test
    void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

        //Api 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }


    @Test
    void 상품수정() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        final var response = RestAssured.given().log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .body(ProductSteps.상품수정요청_생성())
                                        .when()
                                                .patch("/products/{productId}", 1L)
                                                        .then()
                                                                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(repository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }


}
