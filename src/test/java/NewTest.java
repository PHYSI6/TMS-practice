import java.util.Map;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import tms.practice.response.user.UsersRs;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class NewTest {

  @Test
  public void newTest() {
    String baseUrl = "https://reqres.in";
    String endPoint = "/api/users";
    RequestSpecification requestSpecification =
        given()
            .baseUri(baseUrl)
            .headers(
                Map.of(
                    "x-api-key", "reqres_8f0a336511e44a70a94a9f01737229d0"
                )
            )
            .when()
            .log()
            .all();
    given()
        .spec(requestSpecification)
        .get(endPoint)
        .then()
        .log()
        .all()
        .body(matchesJsonSchemaInClasspath("schemas/user/get_users_schema.json"))
        .extract()
        .as(UsersRs.class);
  }
}
