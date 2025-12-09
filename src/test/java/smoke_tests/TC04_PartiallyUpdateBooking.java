package smoke_tests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TC04_PartiallyUpdateBooking extends HerOkuAppBaseUrl {
        /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "firstname" : "Mehmet",
        "lastname" : "Can"
        }
    When
        Send patch request
    Then
        Status code is 200
    And
        Body:
        {
        "firstname" : "Mehmet",
        "lastname" : "Can",
        "totalprice" : 100,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

    @Test
    public void test01() {

        // 1) Set the url => API endpointi ayarlayin
        spec.pathParams("first", "booking", "second", TC01_CreateBooking.bookingid);

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        Map<String, Object> payload = ReusableMethods.jsonToMap("{\n" +
                "        \"firstname\" : \"Mehmet\",\n" +
                "        \"lastname\" : \"Can\"\n" +
                "        }");

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(payload).when().patch("{first}/{second}");
        response.prettyPrint();

        // 4) Do assertion => Dogrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        response
                .then()
                .statusCode(200);
        assertEquals(actualData.get("firstname"), payload.get("firstname"));
        assertEquals(actualData.get("lastname"), payload.get("lastname"));

    }
}
