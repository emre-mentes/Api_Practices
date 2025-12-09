package get_requests;

import baseurl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends PetStoreBaseUrl {
       /*
        Given
            https://petstore.swagger.io/v2/pet/313
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
    */

    @Test
    public void test01() {
        //  1)Set the url = > API endpointi ayarlayin
        spec.pathParams("first","pet","second",313);

        //  2)Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        //  3)Send request get response =>İstegi gönderin ve response u alin
        Response response = given(spec).when().get("{first}/{second}");

        //  4)Do assertion =>Dogrulamalar yapin
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);


    }
}