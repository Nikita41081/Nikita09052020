package com.StudentApp.Model.studentinfo;

import com.StudentApp.Model.StudentPojo;
import com.StudentApp.Model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
Created
By Nikita
*/
public class StudentDeleteTest extends TestBase {
    @Test
    public void deleteStudentById(){
        StudentPojo studentPojo = new StudentPojo();

        Response response = given()
                .header("Content-Type", "application/json")
                .log().headers()
                .body(studentPojo)
                .delete("/99");
        response.then().statusCode(204);
        System.out.println(response.prettyPrint());


    }
}
