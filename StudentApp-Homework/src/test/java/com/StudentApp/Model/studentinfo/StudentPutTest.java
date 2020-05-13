package com.StudentApp.Model.studentinfo;

import com.StudentApp.Model.StudentPojo;
import com.StudentApp.Model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
Created
By Nikita
*/
public class StudentPutTest extends TestBase {

    @Test
    public void studentNameUpdateByID(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName("Nikita");
    studentPojo.setLastName("Patel");
    studentPojo.setEmail("niki12@gmail.com");
    studentPojo.setProgramme("Automation Testing");
    List<String> course = new ArrayList<>();
    course.add("Selenium");
    course.add("Java");
    course.add("API Testing");
    studentPojo.setCourses(course);
    Response response= given()
            .header("Content-Type","application/json")
            .log().headers()
            .when()
            .body(studentPojo)
            .put("/104");
    response.then().statusCode(200);
    response.prettyPrint();
}

}
