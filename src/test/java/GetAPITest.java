import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {

    @Test
    public void testStatusCode() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().
                statusCode(200);
        System.out.println("testStatusCode method ran successfully....");
    }
}
