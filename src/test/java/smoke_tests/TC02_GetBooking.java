package smoke_tests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TC02_GetBooking extends HerOkuAppBaseUrl {
     /*
   Given
   https://restful-booker.herokuapp.com/booking/:id
   When
   Send get request
           Then
   Status code is 200
   And
   Body:
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
        System.out.println("TC01_CreateBooking.bookingid = " + TC01_CreateBooking.bookingid);
        spec.pathParams("first", "booking", "second", TC01_CreateBooking.bookingid);

        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        HerokuAppBookingDatesPojo bookingDatesPojo = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppResponsePojo expectedData = new HerokuAppResponsePojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // 4) Do assertion => Dogrulamalar yapin
        HerokuAppResponsePojo actualData = response.as(HerokuAppResponsePojo.class);
        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstname(), expectedData.getFirstname());
        assertEquals(actualData.getLastname(), expectedData.getLastname());
        assertEquals(actualData.getTotalprice(), expectedData.getTotalprice());
        assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid());
        assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds());
        assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());


    }
}
