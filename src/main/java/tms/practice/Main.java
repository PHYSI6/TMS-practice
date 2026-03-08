package tms.practice;

import java.util.List;
import java.util.Map;

import tms.practice.response.user.User;
import tms.practice.response.user.UsersRs;
import tms.practice.service.user.UserService;
import tms.practice.steps.UserSteps;

import static io.restassured.RestAssured.given;

public class Main {

  public static void main(String[] args) {
 /*   UsersRs usersRs = new UserSteps(new UserService())
        .getUsers();
    List<String> emails = usersRs.getData().stream()
        .map(User::getEmail)
        .toList();
    System.out.println(emails);*/

    given()
        .baseUri("https://reqres.in")
        .headers(Map.of(
                "x-api-key", "reqres_8f0a336511e44a70a94a9f01737229d0",
                "content-type", "application/json"
            ))
        .when()
        .log()
        .all()
        .get("api/users")
        .then()
        .log()
        .all();
  }
}
