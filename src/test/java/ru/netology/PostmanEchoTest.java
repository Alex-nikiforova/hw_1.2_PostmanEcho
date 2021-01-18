package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.urlEncodingEnabled;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    public void shouldPostToPostmanEcho() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello World!")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Hello World!"))
                .body("headers.content-length", equalTo("12"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.3 (Java/11)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
}
