package practices;


import baseurl.practicesBaseUrl.PracticeSoftwareTestingBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_SoftwareTestingGet04 extends PracticeSoftwareTestingBaseUrl {

    /*
        Given
            https://api.practicesoftwaretesting.com/categories
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type should contain "application/json"
        And
            İlk kategorinin id değeri null olmamalı
        And
            İlk kategorinin name değeri null olmamalı
        And
            İlk kategorinin slug değeri null olmamalı
    */


    @Test
    public void test01() {
        spec.pathParam("first", "categories");

        Response response = given(spec).when().get("{first}");

        response.
                then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        Assert.assertNotNull(response.jsonPath().getString("[0].id"));
        Assert.assertNotNull(response.jsonPath().getString("[0].name"));
        Assert.assertNotNull(response.jsonPath().getString("[0].slug"));
        System.out.println(response.jsonPath().getString("[0].id"));

    }
}