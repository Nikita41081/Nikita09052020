package com.StudentApp.Model.studentinfo;

import com.StudentApp.Model.StudentPojo;
import com.StudentApp.Model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/*
Created
By Nikita
*/

public class StudentPatchTest extends TestBase {
    @Test
    public void studentNameUpdateByID(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Niku");
        studentPojo.setProgramme("QA Testing");
        studentPojo.setEmail("LetsCheck1@gmail.com");
        Response response = given()
                .header("Content-Type", "application/json")
                .log().body()
                .body(studentPojo)
                .patch("/99");
        response.then().statusCode(200);
        response.prettyPrint();
        given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/99")
                .then();
        get("/list").then().body("[98].email",equalTo("LetsCheck@gmail.com"));
    }

}
