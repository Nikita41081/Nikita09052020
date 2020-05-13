package com.StudentApp.Model.assertionexample;


import com.StudentApp.Model.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
/*
Created
By Nikita
*/
public class SoftAssertionsExample extends TestBase {

    @Test
    public void hardAssert() {
         given()
                .when()
                .get("/list")
                 .then()
                 .body("[0].id", equalTo(1))
                 .body("[0].firstName", equalTo("Vernon"))
                 .body("[0].lastName", equalTo("Harper"))
                 .body("[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"));

    }

    @Test
    public void softAssert() {
        given()
                .when()
                .get("/list")
                .then()
                .body("[0].id", equalTo("1"),"[0].firstName", equalTo("Vernon"),
                        "[0].lastName", equalTo("Harper1"),"[0].email",
                        equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"));

    }
}
