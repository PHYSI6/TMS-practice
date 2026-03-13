package tms.practice.api.service.login;

import java.util.Map;

import tms.practice.api.constant.Header;
import tms.practice.api.entity.Request;
import tms.practice.api.request.UserRq;
import tms.practice.api.response.login.AuthTokenRs;
import tms.practice.api.service.user.UserService;

public class LoginService extends UserService {
  public static final String AUTH_TOKEN = "auth/sign-up";

  public static final String POST_AUTH_TOKEN_SCHEMA_PATH = "schemas/login/post_auth_token_schema.json";

  public AuthTokenRs login(UserRq userRq) {
    Map<String, String> headers = Map.of(
        Header.CONTENT_TYPE, "application/json"
    );
    return post(Request.builder()
        .url(BASE_URL)
        .path(AUTH_TOKEN)
        .body(userRq)
        .headers(headers)
        .clazz(AuthTokenRs.class)
        .schemaName(POST_AUTH_TOKEN_SCHEMA_PATH)
        .build()
    );
  }
}
