
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class WebServicesTest {

    final static String url = "https://petstore.swagger.io/v2/pet/findByStatus";



    public static void main(String[] args) {
        getResponseBody();
        getResponseStatus();
        getResponseHeaders();
    }

    public static void getResponseBody(){
        Response response = given().
                contentType(ContentType.JSON).
                param("status", "available").
                when().
                get(url).
                then().
                extract().response();

        System.out.println(response.body().print());
    }

    public static void getResponseStatus(){
        int statusCode = given().
                contentType(ContentType.JSON).
                param("status","available").
                when().
                get(url).getStatusCode();
        System.out.println("Response status is: " + statusCode );

        given().when().get(url).then().assertThat().statusCode(200);
    }

    public static void getResponseHeaders(){
        System.out.println("The headers in the response: " +
                                        RestAssured.get(url).then().extract().headers() );
    }




}
