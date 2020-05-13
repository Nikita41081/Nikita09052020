package in.reqres.users;/*
Created 
By Nikita
*/

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.UserPojo.getRandomString;
import static io.restassured.RestAssured.given;

public class PutUsers extends TestBase {
    String name = "morpheus" + getRandomString(2);
    String job = "zion resident" + getRandomString(2);
    @Test
    public void updateUser(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .put("/users/2");
        response.then().statusCode(200)
                .log().body();
    }
}
