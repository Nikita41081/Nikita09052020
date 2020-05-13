package in.reqres.users;/*
Created 
By Nikita
*/

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUsers extends TestBase {
    @Test
    public void updateUsersByJobOnly() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("morpheus");
        userPojo.setJob("zion resident");

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .patch("/users/2");
        response.then().statusCode(200)
                .log().body();

    }
}
