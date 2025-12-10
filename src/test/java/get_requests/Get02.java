package get_requests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Get02 {
     /*
        Given
            https://petstore.swagger.io/v2/pet/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Pet not found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Jetty(9.2.9.v20150224)" olmalı
*/


    @Test
    public void test01() {

        //set the url
        String url = "https://petstore.swagger.io/v2/pet/0";
        //set the expected data / payload
        //send request get response
        //do assertion
        /*
        4** lü kodlarda HttpResponseException hatasi almamak icin
        pom.xml dosyamizdaki propertiest tagi icine su komutu eklemeliyiz
        <argLine>-Duser.language=en</argLine>

         */
        given()
                .when()
                .get(url)
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))//response un body kısmında Pet not found ifadesini icerdigini test ettik
                .body(Matchers.not(containsString("TechProEd")))//response un body kısmının Techproed icermedigini test ettik
                .header("Server", Matchers.equalTo("Jetty(9.2.9.v20150224)"))
                .log().body();

    }


    @Test
    public void test02() {

        //set the url
        String url = "https://petstore.swagger.io/v2/pet/0";

        //set the expected data / payload
        //send request get response
        //do assertion
        /*
        response.asString() methodu response un body kısmını string e dönüstürür
        böylece string manipulation yaparak ta cesitli testler yapilabilir
             */
        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();

        Assert.assertTrue(response.asString().contains("Pet not found"));
        Assert.assertFalse(response.asString().contains("TechProEd"));


    }

}