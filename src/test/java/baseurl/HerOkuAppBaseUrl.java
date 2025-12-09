package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import utilities.AuthenticateHerOkuApp;

public class HerOkuAppBaseUrl {

    /*
    Her test ten önce calisarak ihtiyac duyabileceğimiz cesitli configurasyonlari tamamlamaktir
    Mesela baseurl, authorization, content type.. gibi yapilandirmalari tek bir merkezden güncellemeyi saglar
    böylece testlerin bakimi ve yönetimi daha kolay olur
     */
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .addHeader("Coookie","token="+ AuthenticateHerOkuApp.generateToken())
                .build();
    }


}