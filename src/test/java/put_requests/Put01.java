package put_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {
      /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
            Kullanıcı URL'e bir PUT request gönderir
        Then
           Status code 200 olmalı
           Response şu şekilde olmalı:
           {
                "userId": 21,
                "title": "Wash the dishes",
                "completed": false
                "id": 198
           }
     */


    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParams("first", "todos", "second", 198);

        // 2) Set the expected data / payload =>Gereksinimlere göre Beklenen datayi ayarlayin
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 21);
        payload.put("title", "Wash the dishes");
        payload.put("completed", false);
        System.out.println("payload = " + payload);


        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(payload).when().put("{first}/{second}");
        response.prettyPrint();

        // 4) Do assertion => Dogrulamalar yapin
        Map<String, Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(actualData.get("userId"),payload.get("userId"));
        assertEquals(actualData.get("title"),payload.get("title"));
        assertEquals(actualData.get("completed"),payload.get("completed"));
        assertEquals(response.statusCode(),200);

    }
}