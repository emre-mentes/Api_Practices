package get_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos
    When
       Kullanıcı URL'e bir GET request gönderir
    Then
        Status code 200 olmalı
        "Id"leri 190 dan büyük olanları konsola yazdırın
        "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
 */


    @Test
    public void test01() {

        //set the url
        spec.pathParam("first", "todos");

        //set the expected data
        //send request get response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        System.out.println("=====================================");

        //do assertion
        Assert.assertEquals(response.statusCode(), 200);

        /*============jsonpath==============*/
        JsonPath jsonPath = response.jsonPath();

        List<Object> id = jsonPath.getList("id");
        System.out.println("id = " + id);
        System.out.println("=====================================");

        List<Object> title = jsonPath.getList("title");
        System.out.println("title = " + title);

        System.out.println("=====================================");
        List<Object> idsi197denbuyukjsonlar = jsonPath.getList("findAll{it.id>197}");
        //groovy

        System.out.println("idsi197denbuyukjsonlar = " + idsi197denbuyukjsonlar);
        /*
        idsi197denbuyukjsonlar = [
        {userId=10, id=198, title=quis eius est sint explicabo, completed=true},
        {userId=10, id=199, title=numquam repellendus a magnam, completed=true},
        {userId=10, id=200, title=ipsam aperiam voluptates qui, completed=false}]
         */


        //================ assertion ============

        // "Id"leri 190 dan büyük olanları konsola yazdırın
        List<Object> idleri190danbuyukolanlar = jsonPath.getList("findAll{it.id>190}");
        System.out.println("idleri190danbuyukolanlar = " + idleri190danbuyukolanlar);
        /*
        idleri190danbuyukolanlar =
        [
        {userId=10, id=191, title=temporibus atque distinctio omnis eius impedit tempore molestias pariatur, completed=true},
        {userId=10, id=192, title=ut quas possimus exercitationem sint voluptates, completed=false},
        {userId=10, id=193, title=rerum debitis voluptatem qui eveniet tempora distinctio a, completed=true},
        {userId=10, id=194, title=sed ut vero sit molestiae, completed=false},
        {userId=10, id=195, title=rerum ex veniam mollitia voluptatibus pariatur, completed=true},
        {userId=10, id=196, title=consequuntur aut ut fugit similique, completed=true},
        {userId=10, id=197, title=dignissimos quo nobis earum saepe, completed=true},
        {userId=10, id=198, title=quis eius est sint explicabo, completed=true},
        {userId=10, id=199, title=numquam repellendus a magnam, completed=true},
        {userId=10, id=200, title=ipsam aperiam voluptates qui, completed=false}]
         */

        // "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        Assert.assertEquals(idleri190danbuyukolanlar.size(), 10);

        // "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Object> idsi5tenkucukolanlarinuseridleri = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("idsi5tenkucukolanlarinuseridleri = " + idsi5tenkucukolanlarinuseridleri);//[1, 1, 1, 1]

        // "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        Assert.assertEquals(idsi5tenkucukolanlarinuseridleri.size(), 4);


        // "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<Object> idsi5tenkucukolanlarintitlelari = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("idsi5tenkucukolanlarintitlelari = " + idsi5tenkucukolanlarintitlelari);
        /*
        idsi5tenkucukolanlarintitlelari =
         [delectus aut autem, quis ut nam facilis et officia qui, fugiat veniam minus, et porro tempora]
         */

        // "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        Assert.assertTrue(idsi5tenkucukolanlarintitlelari.contains("delectus aut autem"));
    }
}