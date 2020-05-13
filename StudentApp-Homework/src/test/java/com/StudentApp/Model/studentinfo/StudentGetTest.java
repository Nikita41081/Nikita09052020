package com.StudentApp.Model.studentinfo;


import com.StudentApp.Model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
Created
By Nikita
*/
public class StudentGetTest extends TestBase {


    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }

    @Test
    public void searchStudentWithParameter() {
        Response response =given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(200);

    }

    //xxxxxxxxxxxxxxxxxxxxx!!!!!!!!!Home Work!!!!!!!!!!!xxxxxxxxxxxxxxxxxxxxxxxx

    @Test
    public void searchStudnetByID(){
        Response response =given()
                .param("id",4)
                .when()
                .get("/4");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }
    @Test
    public void searchStudentByLastName(){
        given()
                .param("lastName","Jackson")
                .when()
                .get("/list")
                .then()
                .body("lastName.size()",equalTo(100));
    }


}
