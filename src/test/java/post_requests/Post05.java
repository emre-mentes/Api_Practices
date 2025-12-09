package post_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppPostResponsePojo;
import pojos.HerokuAppResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Post05 extends HerOkuAppBaseUrl {

      /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 627,
                    "booking": {
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
                }
     */

    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParam("first", "booking");

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        HerokuAppBookingDatesPojo bookingDatesPojo = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppResponsePojo expectedData = new HerokuAppResponsePojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(expectedData).when().post("{first}");

        // 4) Do assertion => Dogrulamalar yapin
        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);
        assertEquals(actualData.getBooking().getFirstname(),expectedData.getFirstname());
        assertEquals(actualData.getBooking().getLastname(),expectedData.getLastname());
        assertEquals(actualData.getBooking().getTotalprice(),expectedData.getTotalprice());
        assertEquals(actualData.getBooking().getDepositpaid(),expectedData.getDepositpaid());
        assertEquals(actualData.getBooking().getAdditionalneeds(),expectedData.getAdditionalneeds());
        assertEquals(actualData.getBooking().getBookingdates().getCheckin(),bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBooking().getBookingdates().getCheckout(),bookingDatesPojo.getCheckout());



    }
}