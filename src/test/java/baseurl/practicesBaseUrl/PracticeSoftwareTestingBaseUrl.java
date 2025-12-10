package baseurl.practicesBaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class PracticeSoftwareTestingBaseUrl {

    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://api.practicesoftwaretesting.com")
                .setContentType(ContentType.JSON)
                .build();

    }
}
