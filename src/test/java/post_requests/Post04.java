package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPayloadPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Post04 extends JsonPlaceHolderBaseUrl {

      /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParam("first","todos");

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        JsonPlaceHolderPayloadPojo payload = new JsonPlaceHolderPayloadPojo(55,"Tidy your room",false);

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(payload).when().post("{first}");

        // 4) Do assertion => Dogrulamalar yapin
        JsonPlaceHolderPayloadPojo actualData = response.as(JsonPlaceHolderPayloadPojo.class);

        assertEquals(response.statusCode(),201);
        assertEquals(actualData.getUserId(),payload.getUserId());
        assertEquals(actualData.getTitle(),payload.getTitle());
        assertEquals(actualData.getCompleted(),payload.getCompleted());
    }
}