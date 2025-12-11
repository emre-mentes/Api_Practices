package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends JsonPlaceHolderBaseUrl {
    private static final Logger log = LoggerFactory.getLogger(Post02.class);


  /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }

        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
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
        spec.pathParam("first", "todos");

        // 2) Set the expected data / payload =>Gereksinimlere göre Beklenen datayi ayarlayin
   /*
   String kullanmak ta bir yöntemdir, ama assertion adımı icin bunu tavsiye etmiyoruz
        String payload ="{\n" +
             "             \"userId\": 55,\n" +
             "             \"title\": \"Tidy your room\",\n" +
             "             \"completed\": false\n" +
             "           }";
    */

        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 55);
        payload.put("title", "Tidy your room");
        payload.put("completed", false);
        System.out.println("payload = " + payload);

        // 3) Send request get response => İstegi gönderin ve response u alin
        Response response = given(spec).body(payload).when().post("{first}");


        /*
        Serialization ==> Java datalarimizin Json datalarina dönüstürülmesi islemidir
        De-Serialization ==> Json datalarimizin Java datalarina dönüstürülmesi islemidir
        pom.xml dosyamiza ekledigimiz Jackson Databind gibi kütüphaneler serialization ve De-searialization
        islemlerini otomatik olarak gerceklestirir, bizim extra bir sey yapmamiza gerek kalmaz
         */

        // 4) Do assertion => Dogrulamalar yapin
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.getInt("userId"),payload.get("userId"));
        Assert.assertEquals(jsonPath.getString("title"),payload.get("title"));
        Assert.assertEquals(jsonPath.getBoolean("completed"),payload.get("completed"));
        Assert.assertEquals(response.statusCode(),201);

        //alternative way
        response
                .then()
                .statusCode(201);

    }}