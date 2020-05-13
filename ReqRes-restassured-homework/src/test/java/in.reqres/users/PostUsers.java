package in.reqres.users;/*
Created 
By Nikita
*/

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostUsers extends TestBase {
    private String name = "niki" + getRandomString(2);
    private String job = "tester" + getRandomString(2);
    private String email = "niki" + getRandomString(2);
    private String password = "nikita" + getRandomString(2);

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @Test
    public void createNewsUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();
    }

    @Test
    public void registerUserSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();
    }
    @Test
    public void userRegisterUnsuccessful(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(400)
                .log().body();

    }
    @Test
    public void loginSuccessfull(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();
    }
    @Test
    public void loginUnsusscessfull(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(400)
                .log().body();
    }

}
