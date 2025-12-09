package practices;

import baseurl.practicesBaseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C03_SoftwareTestingGet03 extends PracticeSoftwareTestingBaseUrl {

    /*
        Given
            https://api.practicesoftwaretesting.com/products
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Response body'de "data" listesi boş olmamalı
        And
            Listede en az 5 eleman olmalı
        And
            Listede 100'den az eleman olmalı
        And
            Listenin ilk elemanının id değeri null olmamalı
        And
            Listenin ilk elemanının name değeri null olmamalı
        And
            Listenin ilk elemanının price değeri 0'dan büyük olmalı
    */


    @Test
    public void test01() {
        spec.pathParam("first","products");

        Response response = given(spec).when().get("{first}");

        response.
                then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", Matchers.not(Matchers.empty()))
                .body("data",Matchers.hasSize(Matchers.greaterThan(5)))
                .body("data",Matchers.hasSize(Matchers.lessThan(200)))
                .body("data[0].id", Matchers.notNullValue())
                .body("data[0].name", Matchers.notNullValue())
                .body("data[0].price",Matchers.greaterThan(0.0f));



    }


}