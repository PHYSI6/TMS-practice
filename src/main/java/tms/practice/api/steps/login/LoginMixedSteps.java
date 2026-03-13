package tms.practice.api.steps.login;

import io.qameta.allure.Step;
import tms.practice.api.entity.UserCommon;
import tms.practice.api.request.UserRq;
import tms.practice.api.response.login.AuthTokenRs;
import tms.practice.api.service.login.LoginService;
import tms.practice.db.entity.user.UserEntity;
import tms.practice.db.enums.Role;
import tms.practice.db.service.user.UserDatabaseService;

public class LoginMixedSteps {

  private final LoginService loginService;

  public LoginMixedSteps(LoginService loginService) {
    this.loginService = loginService;
  }

  @Step("Авторизируемся пользователем с 'username' = '{userRq.username}'")
  public UserCommon login(UserRq userRq) {
    AuthTokenRs authTokenRs = loginService.login(userRq);
    UserEntity userEntity = new UserDatabaseService().getUserByUsername(userRq.getUsername()).get();
    userEntity.setRole(Role.ADMIN);
    new UserDatabaseService().updateUser(userEntity);
    return UserCommon.builder()
        .token(authTokenRs.getToken())
        .username(userRq.getUsername())
        .build();
  }
}
