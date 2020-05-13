package com.StudentApp.Model.studentinfo;

import com.StudentApp.Model.StudentPojo;
import com.StudentApp.Model.testbase.TestBase;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.StudentApp.Model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/*
Created
By Nikita
*/
public class StudentPostTest extends TestBase {



    @Test
    public void createNewStudent(){

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("API Testing");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Nilesh");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("nilesh@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void createNewStudentwithBlankName(){

        List<String> course = new ArrayList<>();
        course.add("Selenium");

        course.add("API Testing");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("nilu123@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void createNewStudentwithFirstNameAndLastNameBlank(){

        List<String> course = new ArrayList<>();
        course.add("Selenium");

        course.add("API Testing");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName(" ");
        studentPojo.setEmail("nilu1234@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }


@Test
public void createStudentWithLastNameNull() {


    StudentPojo studentPojo = new StudentPojo();
    studentPojo.setFirstName("Kia");
    studentPojo.setLastName(" ");
    studentPojo.setEmail("Kia" + getRandomString(4) + "@gmail.com");
    studentPojo.setProgramme("Electrical Engineer");

    List<String> course = new ArrayList<>();
    course.add("Selenium");
    course.add("Java");
    studentPojo.setCourses(course);

    Response response = given()
            .header("Content-Type", "application/json")
            .when()
            .body(studentPojo)
            .post();
    response.then().statusCode(201);
    response.prettyPrint();


}
    @Test
    public void studentNameUpdateByEmailId(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Nikita");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("KiaSia@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        List<String> course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("ABC Testing");
        studentPojo.setCourses(course);
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
        get("/list").then().body("[98].email",equalTo("KiaSia@gmail.com"));


    }
}
