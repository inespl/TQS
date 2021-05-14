package tqs.Air_Quality;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Assertions.assertThat;



class Rest_ControllerTest {

    @Test
    void getResponseBody(){

        given().queryParam("lat","40.4")
                .queryParam("lon","-8.5").when().get("http://localhost:8080/api").then().log().body();


        given().when().get("http://localhost:8080/api?lat=40.4&lon=-8.5").then().assertThat().statusCode(200);
    }
}