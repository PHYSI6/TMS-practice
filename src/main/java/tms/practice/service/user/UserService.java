package tms.practice.service.user;

import java.util.Map;

import tms.practice.constant.Header;
import tms.practice.entity.Request;
import tms.practice.response.user.User;
import tms.practice.response.user.UsersRs;
import tms.practice.service.ApiService;

public class UserService extends ApiService {
  public static final String USERS = "api/users";
  public static final String USERS_PATTERN = "api/users/%s";

  public static final String GET_USERS_SCHEMA_PATH = "schemas/user/get_users_schema.json";
  public static final String POST_USERS_SCHEMA_PATH = "schemas/user/post_users_schema.json";
  public static final String PUT_USERS_SCHEMA_PATH = "schemas/user/put_users_schema.json";

  public UsersRs getUsers() {
    Map<String, String> headers = Map.of(
        Header.X_API_KEY, "reqres_8f0a336511e44a70a94a9f01737229d0",
        Header.CONTENT_TYPE, "application/json"
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

  public UsersRs postUsers(User user) {
    Map<String, String> headers = Map.of(
        Header.X_API_KEY, "reqres_8f0a336511e44a70a94a9f01737229d0",
        Header.CONTENT_TYPE, "application/json"
    );
    return post(Request.builder()
        .url("https://reqres.in")
        .path(USERS)
        .body(user)
        .headers(headers)
        .clazz(UsersRs.class)
        .schemaName(POST_USERS_SCHEMA_PATH)
        .build()
    );
  }

  public UsersRs putUsers(User user) {
    Map<String, String> headers = Map.of(
        Header.X_API_KEY, "reqres_8f0a336511e44a70a94a9f01737229d0",
        Header.CONTENT_TYPE, "application/json"
    );
    return put(Request.builder()
        .url("https://reqres.in")
        .path(USERS_PATTERN.formatted(user.getId()))
        .body(user)
        .headers(headers)
        .clazz(UsersRs.class)
        .schemaName(PUT_USERS_SCHEMA_PATH)
        .build()
    );
  }
}
