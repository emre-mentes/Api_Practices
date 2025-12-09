package practices;

import baseurl.practicesBaseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class C05_SoftwareTestingGet05 extends PracticeSoftwareTestingBaseUrl {

      /*
        Given
            https://api.practicesoftwaretesting.com/brands
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            Status code 200 olmalı
        And
            Tüm brand id'lerini konsola yazdırın
        And
            Tüm brand name'lerini konsola yazdırın
        And
            En az 1 brand olduğunu doğrulayın
        And
            Slug değeri "mightycraft-hardware" olan bir brand olduğunu doğrulayın
    */

    @Test
    public void test01() {
        spec.pathParam("first", "brands");

        Response response = given(spec).when().get("{first}");

        response.
                then()
                .statusCode(200)
                .contentType(ContentType.JSON);

       // System.out.println( response.jsonPath().getList("findAll{it.id}.id"));
      //  System.out.println( response.jsonPath().getList("id"));
       // System.out.println( response.jsonPath().getList("name"));
        String id = response.jsonPath().getString("id");


      System.out.println(response.jsonPath().getList("id").size());
      Assert.assertTrue(response.jsonPath().getList("id").size() >= 1);

      Assert.assertTrue(response.jsonPath().getList("slug").contains("mightycraft-hardware"));


        Assert.assertTrue(response.jsonPath().getList("findAll{it.slug == 'mightycraft-hardware'}").size() > 0);








    }
}