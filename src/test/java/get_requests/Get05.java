package get_requests;

import baseurl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends PetStoreBaseUrl {


   /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        Listede id değeri 313 olan bir eleman olmalı
    And
        Listede name değeri "ELMAS" olan bir eleman olmalı
    And
        Listede name değerleri "ELMAS", "doggie", "fish" olan elemanlar olmalı
    And
        Listede en az 200 tane eleman olmalı
    And
        Listede 500'den az eleman olmalı
    And
        Listenin ilk elemanının category - id değeri 0 olmalı
    And
        Listenin ilk elemanının photoUrls değeri "string" olmalı
    And
        Listenin ilk elemanının tags - id değeri 0 olmalı
 */



    @Test
    public void test01() {
        // 1)Set the url = > API endpointi ayarlayin
        spec.pathParams("first","pet","second","findByStatus")
                .queryParam("status","available");

        // 2)Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        // 3)Send request get response =>İstegi gönderin ve response u alin
        // 4)Do assertion =>Dogrulamalar yapin

        given(spec)
                .when()
                .get("{first}/{second}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", Matchers.hasItem(313))
                .body("name", Matchers.hasItem("ELMAS"))
                .body("name", Matchers.hasItems("ELMAS", "doggie", "fish"))
                .body("id", hasSize(greaterThan(200)))
                .body("id", hasSize(lessThan(500)))
                .body("[0].category.id", equalTo(0))
                .body("id", greaterThanOrEqualTo(200))
                .body("id", lessThan(500))
                .body("[0].category.id", equalTo(0))
                .body("[0].photoUrls", equalTo("string"))
                .body("[0].tags.id", equalTo(0))
                .log().body();






    }
}