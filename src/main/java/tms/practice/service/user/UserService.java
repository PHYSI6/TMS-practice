package tms.practice.service.user;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import tms.practice.entity.Request;
import tms.practice.response.user.UsersRs;
import tms.practice.service.ApiService;

public class UserService extends ApiService {
  public static final String USERS = "api/users";

  public static final String GET_USERS_SCHEMA_PATH = "schemas/user/get_users_schema.json";

  public UsersRs getUsersRs(){
    Map<String, String> headers = Map.of(
        "x-api-key", "reqres_8f0a336511e44a70a94a9f01737229d0",
        "content-type", "application/json"
    );
    return get(Request.builder()
        .url("https://reqres.in")
        .path(USERS)
        .headers(headers)
        .clazz(UsersRs.class)
        .schemaName(GET_USERS_SCHEMA_PATH)
        .build()
    );
  }
}
