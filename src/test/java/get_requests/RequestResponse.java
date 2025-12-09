package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1) Manual API testleri icin postman kullanacağız
       Otomasyon testleri icin Rest Assured Library kullanacağız

    2) Rest Assured Library, Gherkin dilinden faydalanarak hazir methodlar olusturmustur.
       a) given()   :  Preconditions..(Rest assured kütüphanesinde bir request baslatir)
       b) when()    :  Actions  get(), post(),...
       c) then()    :  Assertions
       d) and()     :  Coklu durumlar icin baglarken okunabilirlik acisndan kullanilabilir


    3) API Otomasyon testlerini yazarken asagidaki adimlari izleyebilirsiniz.

        1) Set the url => API endpointi ayarlayin
        2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        3) Send request get response => İstegi gönderin ve response u alin
        4) Do assertion => Dogrulamalar yapin

     */


    @Test
    public void test01() {
        String url = "https://petstore.swagger.io/v2/pet/5";
        Response response = given().when().get(url);
        response.prettyPrint();
        response.print();

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.headers() = " + response.headers());
        System.out.println("response.header(\"Server\") = " + response.header("Server"));
        System.out.println("response.time() = " + response.time());


    }


}