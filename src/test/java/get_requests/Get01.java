package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
     /*
        Given
            https://petstore.swagger.io/v2/pet/5
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void test01() {


        //1- Set the url
        String url = "https://petstore.swagger.io/v2/pet/5";

        //2- Set the expected data / payload


        //3- Send request get response
        Response response = given().when().get(url);

        //4- Do assertion
        response
                .then()
                .statusCode(200)//status codun 200 oldugunu test ettik
                .contentType("application/json")//responstaki content type in "application/json" oldugunu test ettik
                .statusLine("HTTP/1.1 200 OK")// status line in "HTTP/1.1 200 OK" oldugunu test ettik
                // .log().body();//response un body kısmını console a yazdirir
                .log().all();//response un header da dahil olmak üzere console a yazdirir
    }


    //ikinci yol
    @Test
    public void test02() {

        //1- Set the url
        String url = "https://petstore.swagger.io/v2/pet/5";

        //2- Set the expected data / payload

        //3- Send request get response

        // 4- Do assertion
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200)//status codun 200 oldugunu test ettik
                .contentType("application/json")//responstaki content type in "application/json" oldugunu test ettik
                .statusLine("HTTP/1.1 200 OK")// status line in "HTTP/1.1 200 OK" oldugunu test ettik
                // .log().body();//response un body kısmını console a yazdirir
                .log().all();//response un header da dahil olmak üzere console a yazdirir
    }


}