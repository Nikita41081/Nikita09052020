package in.reqres.users;/*
Created 
By Nikita
*/

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUsers extends TestBase {
    Response response = given()
            .when()
            .delete("/users/2");
//        response.then().statusCode(204);
}

