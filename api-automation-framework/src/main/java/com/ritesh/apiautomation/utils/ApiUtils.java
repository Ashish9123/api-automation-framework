package com.ritesh.apiautomation.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    // Reusable request specification: every test uses this instead of
    // repeating base URI / headers setup in every single test method.
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType("application/json")
                .build();
    }
}
