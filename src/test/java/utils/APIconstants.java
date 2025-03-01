package utils;

import io.restassured.RestAssured;

public class APIconstants {

    public static final String BaseURI= RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_USER= BaseURI + "/createUser.php";
    public static final String GENERATE_TOKEN= BaseURI + "/generateToken.php";

    public static final String CONTENT_TYPE_KEY= "Content-Type";
    public static final String CONTENT_TYPE_VALUE= "application/json";
    public static final String AUTHORIZATION_KEY= "Authorization";
}
