package com.ritesh.apiautomation.tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import com.ritesh.apiautomation.utils.ApiUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetPostTest {

    @Test
    public void getSinglePost_returnsCorrectData() {
        given()
            .spec(ApiUtils.getRequestSpec())
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", notNullValue());
    }

    @Test
    public void getSinglePost_matchesJsonSchema() {
        given()
            .spec(ApiUtils.getRequestSpec())
        .when()
            .get("/posts/1")
        .then()
            .statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }

    @Test
    public void getAllPosts_returnsList() {
        given()
            .spec(ApiUtils.getRequestSpec())
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .body("size()", org.hamcrest.Matchers.greaterThan(0));
    }

    @Test
    public void getNonExistentPost_returns404() {
        given()
            .spec(ApiUtils.getRequestSpec())
        .when()
            .get("/posts/99999")
        .then()
            .statusCode(404);
    }
}
