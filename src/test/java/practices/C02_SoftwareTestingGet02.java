package practices;


import baseurl.practicesBaseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_SoftwareTestingGet02 extends PracticeSoftwareTestingBaseUrl {



     /*
        Given
            https://api.practicesoftwaretesting.com/products/01K6T0EX69W1NS9QT18RA1VKGK
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
    */


    @Test
    public void test01() {

        spec.pathParams("first","products","second" , "01K6T0EX69W1NS9QT18RA1VKGK");

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();


        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);




    }
}