import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ItemInInboxCreationTest {

    @Test
    public void userCanCreateATaskToInboxTest() {

        RestAssured.baseURI = "https://api.todoist.com";
        RestAssured.basePath = "/rest/v1/";
        RestAssured.requestSpecification = RestAssured.given().header("Authorization", "Bearer 225a183668ebd8367745c77fe9a6094eef654df5")
                .contentType(ContentType.JSON);

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


        RestAssured.given()
                .body("{\"content\":\"Kup Ibuprom w aptece\"}")
                .when()
                .post("/tasks")
                .then()
                .assertThat()
                .statusCode(200)
                .body("content", equalTo("Kup Ibuprom w aptece"))
                .header("Content-Type", equalTo("application/json"));

    }
}
