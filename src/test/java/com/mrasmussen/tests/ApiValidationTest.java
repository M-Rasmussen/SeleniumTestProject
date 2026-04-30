package com.mrasmussen.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiValidationTest {

    @Test
    public void shouldValidatePublicApiResponse() {
        RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", notNullValue())
                .body("title", notNullValue());
    }
}