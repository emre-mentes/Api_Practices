package smoke_tests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TC05_DeleteBooking extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send delete request
    Then
        Status code is 201
    And
        Body should be : "Created"
     */

    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParams("first", "booking", "second", TC01_CreateBooking.bookingid);

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        String expectedData = "Created";

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        // 4) Do assertion => Dogrulamalar yapin

        assertEquals(response.statusCode(),201);
        assertEquals(response.asString(),expectedData);

    }
}
