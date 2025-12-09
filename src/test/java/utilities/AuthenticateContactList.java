package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateContactList {

    public static String generateToken(){
        //set the url
        String url="https://thinking-tester-contact-list.herokuapp.com/users/login";
        //set the payload
        String payload = "{ \"email\": \"emredeutschland@gmail.com\", \"password\": \"Emre5757.\" }";
        //send request get response
        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.jsonPath().getString("token");
    }

}