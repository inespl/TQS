package tqs.Air_Quality;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

class Rest_ControllerTest {

    @Test
    public void getResponseStatus(){

        given().queryParam("lat","40.4")
                .queryParam("lon","-8.5").when().get("http://localhost:8080/api").then().log().body();

        given().when().get("http://localhost:8080/api?lat=40.4&lon=-8.5").then().assertThat().statusCode(200);
    }
}