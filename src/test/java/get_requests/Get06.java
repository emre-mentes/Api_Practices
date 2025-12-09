package get_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type should contain "application/json"
        And
            Response body should be like;
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



        spec.pathParams("first", "booking", "second", 499);

        given()
                .spec(spec)
                .when()
                .get("{first}/{second}")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("firstname", equalTo("Jim"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));

    }

    @Test
    public void test02() {
        // 1)Set the url = > API endpointi ayarlayin
        spec.pathParams("first", "booking", "second", 3158);


        // 2)Set the expected data =>Gereksinimlere göre Beklenen datayi ayarlayin
        // 3)Send request get response =>İstegi gönderin ve response u alin
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        /*============ jsonpath================== */
        //response body yi jsonpath objectine dönüstürdük
        JsonPath jsonPath = response.jsonPath();

        String firstname = jsonPath.getString("firstname");
        System.out.println("firstname = " + firstname);

        int totalprice = jsonPath.getInt("totalprice");
        System.out.println("totalprice = " + totalprice);

        boolean depositpaid = jsonPath.getBoolean("depositpaid");
        System.out.println("depositpaid = " + depositpaid);

        String checkout = jsonPath.getString("bookingdates.checkout");
        System.out.println("checkout = " + checkout);
        /*============ jsonpath================== */


        // 4)Do assertion =>Dogrulamalar yapin

        Assert.assertEquals(jsonPath.getString("firstname"),"Jim");
        Assert.assertEquals(jsonPath.getString("lastname"),"Brown");
        Assert.assertEquals(jsonPath.getInt("totalprice"),111);
        Assert.assertTrue(jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01");
        Assert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01");
        Assert.assertEquals(jsonPath.getString("additionalneeds"),"Breakfast");




    }
}