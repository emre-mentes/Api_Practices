package smoke_tests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.HerokuAppBookingDatesPojo;
import pojos.HerokuAppPostResponsePojo;
import pojos.HerokuAppResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TC01_CreateBooking extends HerOkuAppBaseUrl {
      /*
   Given
       https://restful-booker.herokuapp.com/booking
   And
       {
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
       Send post request
    Then
       Status code is 200
    And
       Body:
        {
           "bookingid": 1,
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
    //Bir test methodu icinde aldigimiz bir datayi diger classlardaki testlerimizde kullanabilmek icin class seviyesinde static variable olarak tanimlamaliyiz
    public static Integer bookingid;
    @Test
    public void test01() {
        // 1) Set the url => API endpointi ayarlayin
        spec.pathParam("first", "booking");
        // 2) Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        HerokuAppBookingDatesPojo bookingDatesPojo = new HerokuAppBookingDatesPojo("2018-01-01", "2019-01-01");
        HerokuAppResponsePojo expectedData = new HerokuAppResponsePojo("Jim", "Brown", 111, true, bookingDatesPojo, "Breakfast");
        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();
        // 4) Do assertion => Dogrulamalar yapin
        HerokuAppPostResponsePojo actualData = response.as(HerokuAppPostResponsePojo.class);
        assertEquals(response.statusCode(),200);
        assertEquals(actualData.getBooking().getFirstname(),expectedData.getFirstname());
        assertEquals(actualData.getBooking().getLastname(),expectedData.getLastname());
        assertEquals(actualData.getBooking().getTotalprice(),expectedData.getTotalprice());
        assertEquals(actualData.getBooking().getDepositpaid(),expectedData.getDepositpaid());
        assertEquals(actualData.getBooking().getAdditionalneeds(),expectedData.getAdditionalneeds());
        assertEquals(actualData.getBooking().getBookingdates().getCheckin(),bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBooking().getBookingdates().getCheckout(),bookingDatesPojo.getCheckout());
        bookingid = actualData.getBookingid();
        System.out.println("bookingid = " + bookingid);

    }
}
