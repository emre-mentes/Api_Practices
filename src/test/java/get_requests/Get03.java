package get_requests;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get03 {
     /*
        Given
            https://petstore.swagger.io/v2/pet/313
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            "name" şu metni içermeli: "ELMAS",
        And
            "status" değeri "available" olmalı
        And
            "category" altındaki "name" değeri "CAT" olmalı
        And
            "tags" altındaki ilk datanın "name" değeri "bird" olmalı
     */


    @Test
    public void test01() {

        String url ="https://petstore.swagger.io/v2/pet/313";

        given().when().get(url)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", Matchers.containsString("ELMAS"))
                .body("status",Matchers.equalTo("available"))
                .body("category.name", Matchers.equalTo("CAT"))
                .body("tags[0].name", Matchers.equalTo("bird"))
                .log().body();


    }
}