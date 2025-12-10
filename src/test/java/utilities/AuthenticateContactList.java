package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateContactList {

    public static String generateToken(){

        String url="https://thinking-tester-contact-list.herokuapp.com/users/login";

        String payload = "{ \"email\": \"emredeutschland@gmail.com\", \"password\": \"Emre5757.\" }";

        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.jsonPath().getString("token");
    }

}