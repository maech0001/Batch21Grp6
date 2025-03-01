package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIPayloadConstants;
import utils.APIconstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserCreation {

    static String token;

    public RequestSpecification userCreation;

    public Response response;

    //String baseURI= RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    @Given("a request token is generated")
    public void a_request_token_is_generated() {
        RequestSpecification tokenGeneration=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body(APIPayloadConstants.generateTokenPayLoad());

        Response response=tokenGeneration.when().post(APIconstants.GENERATE_TOKEN);
       token= response.jsonPath().getString("token");
       token="Bearer + token";
    }
    @When("a request payload is prepared for user creation")
    public void a_request_payload_is_prepared_for_user_creation() {
        userCreation=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body("{\n" +
                "  \"name\": \"adminbatch21\",\n" +
                "  \"email\": \"syntaxadmin03@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");
    }
    @When("a Post call is made against the request")
    public void a_post_call_is_made_against_the_request() {
        response=userCreation.when().post(APIconstants.CREATE_USER);
        response.prettyPrint();
    }
    @Then("status code int is expected to be returned")
    public void status_code_int_is_expected_to_be_returned(Integer expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }
    @Then("the response message returned should be string")
    public void the_response_message_returned_should_be_string(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
    }


    @When("a request payload is prepared for user creation using an existing email address")
    public void a_request_payload_is_prepared_for_user_creation_using_an_existing_email_address() {
        userCreation=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body("{\n" +
                "  \"name\": \"adminbatch212\",\n" +
                "  \"email\": \"admin428@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");
    }

    @When("a request payload is prepared for user creation using an invalid email format")
    public void a_request_payload_is_prepared_for_user_creation_using_an_invalid_email_format() {
        userCreation=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body("{\n" +
                "  \"name\": \"adminbatch212\",\n" +
                "  \"email\": \"admin428@test\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");
    }

    @When("a request payload is prepared for user creation using an empty password field")
    public void a_request_payload_is_prepared_for_user_creation_using_an_empty_password_field() {
        userCreation=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body("{\n" +
                "  \"name\": \"adminbatch212\",\n" +
                "  \"email\": \"admin428@test.com\",\n" +
                "  \"password\": \"\"\n" +
                "}");
    }

    @When("a request payload is prepared for user creation using an empty username field")
    public void a_request_payload_is_prepared_for_user_creation_using_an_empty_username_field() {
        userCreation=given().header(APIconstants.CONTENT_TYPE_KEY, APIconstants.CONTENT_TYPE_VALUE).header(APIconstants.AUTHORIZATION_KEY, "token").body("{\n" +
                "  \"name\": \"\",\n" +
                "  \"email\": \"admin428@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}");
    }
}
