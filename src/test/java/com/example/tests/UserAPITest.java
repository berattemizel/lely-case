package com.example.tests;

import com.example.api.UserAPI;
import com.example.utils.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class UserAPITest {

    UserAPI userAPI = new UserAPI();
    private int userID;

    @Test
    public void testGetUsers() {
        // Send API request
        Response response = userAPI.getUsers();
        //Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        userAPI.validateUserIds(response);
    }


    @Test
    public void testCreateUser() {
        Map<String, String> userData = Constants.DEFAULT_USER_DATA;
        // Send API request
        Response response = userAPI.createUser(userData);        
        userID = response.jsonPath().getInt("data.id");
        //Assertions
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("email"), userData.get("umut@gmail.com"));
        Assert.assertEquals(response.jsonPath().getString("name"), userData.get("test"));
    }

    
    @Test(dependsOnMethods = "testCreateUser")
    public void testCreateUserWithDuplicateEmail() {
        Map<String, String> userData = Constants.DEFAULT_USER_DATA;
        // Send API request
        Response response = userAPI.createUser(userData);
        //Assertions
        Assert.assertEquals(response.getStatusCode(), 422);
        Assert.assertTrue(response.jsonPath().getString("data.message").contains("has already been taken"));
        //Delete this user to create again same email
        Response deleteResponse = userAPI.deleteUser(userID);
        Assert.assertEquals(deleteResponse.getStatusCode(), 204);
    }
    
}