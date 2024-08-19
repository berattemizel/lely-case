package com.example.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import com.example.utils.Constants;

public class BaseAPI {

    protected RequestSpecification requestSpecification(boolean useAuth) {
        RequestSpecification requestSpec = RestAssured.given()
                                                       .baseUri(Constants.BASE_URL)
                                                       .contentType("application/json");

        if (useAuth) {
            requestSpec.header("Authorization", "Bearer " + Constants.ACCESS_TOKEN);
        }

        return requestSpec;
    }
}
