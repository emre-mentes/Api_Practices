package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {

     /*
        Given
            1) https://jsonplaceholder.typicode.com/todos
            2) {"userId": 55,"title": "Tidy your room","completed": false}
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


    //reusable method kullanimi
    @Test
    public void test01() throws JsonProcessingException {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParam("first", "todos");

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        Map<String, Object> expectedData =  ReusableMethods.jsonToMap("{\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}");

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(expectedData).when().post("{first}");

        // 4) Do assertion => Dogrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.get("userId"), expectedData.get("userId"));
        assertEquals(actualData.get("title"), expectedData.get("title"));
        assertEquals(actualData.get("completed"), expectedData.get("completed"));


    }


    @Test
    public void test02() throws JsonProcessingException {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParam("first", "todos");

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        String json = "{\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> expectedData = objectMapper.readValue(json, HashMap.class);
        System.out.println("expectedData = " + expectedData);
        /*
        ObjectMapper objecti ile bu classta bulunan readValue methodu sayesinde birinci parametre olarak
        verdigimiz String tipindeki json datayi, ikinci parametre olarak verdigimiz classa (=>HashMap) cevirir
        Böylece datalari map e manual olarak eklemek zorunda kalmayiz

        not==>
        import com.fasterxml.jackson.databind.ObjectMapper;
         */
        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(expectedData).when().post("{first}");

        // 4) Do assertion => Dogrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.get("userId"), expectedData.get("userId"));
        assertEquals(actualData.get("title"), expectedData.get("title"));
        assertEquals(actualData.get("completed"), expectedData.get("completed"));


    }

}