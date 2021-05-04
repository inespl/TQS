import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class myFirstRestAssuredTest {

    @Test
    public void getResponseBody(){
        /*
        given(). -> No headers required, no query or path param.
        when(). -> No specific condition setup
        get('URL?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1'). ->only the url needs to be supplied
        then(). -> No specific assertions required
        log(). all() -> Once all the response is fetched, log response, headers, essentially everything that the request returns to you.
         */

        //given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log().all();

        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();

    }

    @Test
    public void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().assertThat().statusCode(200);
    }

    @Test
    public void getTodosResponseBody() {
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().log().body();
    }

    @Test
    public void getTodosResponseTitle(){
        String titles = given().when().get("https://jsonplaceholder.typicode.com/todos").then().extract().response().jsonPath().getString("title[3]");
        System.out.println(titles);
    }

    @Test
    public void getTodosResponseIDs(){
        String id198 = given().when().get("https://jsonplaceholder.typicode.com/todos").then().extract().response().jsonPath().getString("id[198]");
        String id199 = given().when().get("https://jsonplaceholder.typicode.com/todos").then().extract().response().jsonPath().getString("id[199]");
        System.out.println(id198 +"\n" + id199);
    }

    @Test
    public void getTodosStatusCode() {
        int statusCode = given().get("https://jsonplaceholder.typicode.com/todos").getStatusCode();
        System.out.println("The response status is " + statusCode);

        given().when().get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200);
    }


}
