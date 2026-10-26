package com.ritesh.apiautomation.tests;

import org.junit.jupiter.api.Test;
import com.ritesh.apiautomation.utils.ApiUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePostTest {

    @Test
    public void createPost_returns201AndEchoesData() {
        String requestBody = """
            {
                "title": "Automation Framework Test",
                "body": "Created via REST Assured",
                "userId": 5
            }
            """;

        given()
            .spec(ApiUtils.getRequestSpec())
            .body(requestBody)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("Automation Framework Test"))
            .body("userId", equalTo(5))
            .body("id", notNullValue());
    }
}
