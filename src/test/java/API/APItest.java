package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APItest {

    String baseURI= RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NDA4NDU0MTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTc0MDg4ODYxNCwidXNlcklkIjoiNzIyMiJ9.iaK0aviY7PPvmYUpY23gl76NAPdFyJ057kODi8_PuIE";

    @Test
    public void createUser(){
        RequestSpecification userCreation=given().header("Content-Type", "application/json").header("Authorization", "token").body("{\n" +
                "  \"name\": \"adminbatch21\",\n" +
                "  \"email\": \"syntaxadmin04@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");

        Response response=userCreation.when().post("/createUser.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("User Created"));

    }





}
