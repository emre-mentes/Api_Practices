package get_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {


/*
 Given
     https://restful-booker.herokuapp.com/booking/id
 When
     I send GET Request to the url
 Then
     Response body should be like that;
{
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                     },
    "additionalneeds": "Breakfast"
}
 */


    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParams("first", "booking", "second", 2817);

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jim");
        expectedData.put("lastname", "Brown");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("additionalneeds", "Breakfast");
        expectedData.put("bookingdates", bookingdates);
        System.out.println("expectedData = " + expectedData);

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // 4) Do assertion => Dogrulamalar yapin

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(actualData.get("firstname"), expectedData.get("firstname"));
        assertEquals(actualData.get("lastname"), expectedData.get("lastname"));
        assertEquals(actualData.get("totalprice"), expectedData.get("totalprice"));
        assertEquals(actualData.get("depositpaid"), expectedData.get("depositpaid"));
        assertEquals(actualData.get("additionalneeds"), expectedData.get("additionalneeds"));
        assertEquals(actualData.get("bookingdates"), expectedData.get("bookingdates"));

        //jsonpath ==>> Nested datalar ile calisirken tavsiye edilir
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.getString("bookingdates.checkin"),bookingdates.get("checkin"));
        assertEquals(jsonPath.getString("bookingdates.checkout"),bookingdates.get("checkout"));


    }

}