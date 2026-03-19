package tms.practice.steps.user;

import java.util.Arrays;
import java.util.List;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import tms.practice.entity.UserCommon;
import tms.practice.response.user.UsersRs;
import tms.practice.service.user.UserService;


public class UserSteps {
  private final UserService userService;

  public UserSteps(UserService userService) {
    this.userService = userService;
  }

  @Step("Получаем список всех пользователей")
  public List<UsersRs> getAll(UserCommon userCommon) {
    return Arrays.asList(userService.getUsers(userCommon)
        .extract().as(UsersRs[].class));
  }

  @Step("Обновляем пользователя c 'id' = '{usersRs.id}'")
  public ValidatableResponse update(UserCommon userCommon,
                                    UsersRs usersRs) {
    return userService.putUsers(userCommon, usersRs);
  }
}
