package org.evyatark.scraping.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ScrapingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/scraping")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testAliveEndpoint() {
        given()
                .when().get("/health/live")
                .then()
                .statusCode(200)
                .body(containsString("\"status\": \"UP\""))
                .body(containsString("\"name\": \"I am alive!\""));
    }
    @Test
    public void testReadyEndpoint() {
        given()
                .when().get("/health/ready")
                .then()
                .statusCode(200)
                .body(containsString("\"status\": \"UP\""))
                .body(containsString("\"name\": \"ready\""));
    }

}