package com.ritesh.apiautomation.tests;

import org.junit.jupiter.api.Test;
import com.ritesh.apiautomation.utils.ApiUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateAndDeletePostTest {

    @Test
    public void updatePost_returns200AndUpdatedTitle() {
        String requestBody = """
            {
                "id": 1,
                "title": "Updated Title",
                "body": "Updated via PUT",
                "userId": 1
            }
            """;

        given()
            .spec(ApiUtils.getRequestSpec())
            .body(requestBody)
        .when()
            .put("/posts/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated Title"));
    }

    @Test
    public void deletePost_returns200() {
        given()
            .spec(ApiUtils.getRequestSpec())
        .when()
            .delete("/posts/1")
        .then()
            .statusCode(200);
    }
}
