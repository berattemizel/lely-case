package com.example.api;

import io.restassured.response.Response;
import com.example.utils.Constants;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class UserAPI extends BaseAPI {

    
    public Response getUsers() {
        return requestSpecification(false)
                .when()
                .get(Constants.USERS_ENDPOINT)
                .then()
                .extract()
                .response();
    }


    public Response createUser(Map<String, String> userData) {
        String jsonBody = convertMapToJson(userData);
        return requestSpecification(true)
                .body(jsonBody)
                .when()
                .post(Constants.USERS_ENDPOINT)
                .then()
                .extract()
                .response();
    }


    private String convertMapToJson(Map<String, String> mapData) {
        return new JSONObject(mapData).toString();
    }


    public Response deleteUser(int userId) {
        return requestSpecification(true)
                .when()
                .delete(Constants.USERS_ENDPOINT + "/" + userId)
                .then()
                .extract()
                .response();
    }


    public void validateUserIds(Response response) {
        List<Integer> ids = response.jsonPath().getList("data.id", Integer.class);

        ids.forEach(id -> {
            Assert.assertNotNull(id, "ID should not be null");

            int length = id.toString().length();
            Assert.assertTrue(length == 4, 
                "ID should be a 4-digit integer, but found: " + id + " with " + length + " digits.");
        });
    }
}
