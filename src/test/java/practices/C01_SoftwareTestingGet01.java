package practices;

import baseurl.practicesBaseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_SoftwareTestingGet01 extends PracticeSoftwareTestingBaseUrl {

    /*
        Given
            https://api.practicesoftwaretesting.com/products
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
    */


    @Test
    public void test01() {
        spec.pathParam("first","products");

        Response response = given(spec).when().get("{first}");

        response.
                then()
                .statusCode(200)
                .contentType(ContentType.JSON);




    }
}