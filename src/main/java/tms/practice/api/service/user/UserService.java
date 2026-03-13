package tms.practice.api.service.user;

import java.util.Map;

import io.restassured.response.ValidatableResponse;
import tms.practice.api.constant.Header;
import tms.practice.api.entity.Request;
import tms.practice.api.entity.UserCommon;
import tms.practice.api.response.user.UsersRs;
import tms.practice.api.service.ApiService;
import tms.practice.util.TokenUtils;

public class UserService extends ApiService {
  public static final String USERS = "/users";
  public static final String USERS_PATTERN = "/users/%s";
  public static final String GET_USERS_SCHEMA_PATH = "schemas/user/get_users_schema.json";

  public ValidatableResponse getUsers(UserCommon userCommon) {
    Map<String, String> headers = Map.of(
        Header.AUTHORIZATION, TokenUtils.createBearer(userCommon.getToken()),
        Header.CONTENT_TYPE, "application/json"
    );
    return get(Request.builder()
        .url(BASE_URL)
        .path(USERS)
        .headers(headers)
        .schemaName(GET_USERS_SCHEMA_PATH)
        .build()
    );
  }

  public ValidatableResponse putUsers(UserCommon userCommon,
                                      UsersRs usersRs) {
    Map<String, String> headers = Map.of(
        Header.AUTHORIZATION, TokenUtils.createBearer(userCommon.getToken()),
        Header.CONTENT_TYPE, "application/json"
    );
    return put(Request.builder()
        .url(BASE_URL)
        .path(USERS_PATTERN.formatted(usersRs.getId()))
        .body(usersRs)
        .headers(headers)
        .build()
    );
  }
}
