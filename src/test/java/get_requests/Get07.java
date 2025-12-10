package get_requests;

import baseurl.ContactListBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get07 extends ContactListBaseUrl {

    /*
    Given
        https://thinking-tester-contact-list.herokuapp.com/contacts
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
 */



    @Test
    public void test01() {
        //        1) Set the url => API endpointi ayarlayin
        //        2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        //        3) Send request get response => İstegi gönderin ve response u alin
        //        4) Do assertion => Dogrulamalar yapin

        spec.pathParam("first", "contacts");

        Response response = given(spec)
               /// .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OGQ4NDA4MzZhOGQ0MzAwMTU2NDVmZWMiLCJpYXQiOjE3NTk1MTcwODh9.y1cXRg0Y406gF4vkpIehRRi2w8hX9byE4ewEDwNBckM")
                .when().get("{first}");

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);


    }
}