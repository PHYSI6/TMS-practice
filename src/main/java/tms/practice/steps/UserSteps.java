package tms.practice.steps;

import io.qameta.allure.Step;
import tms.practice.response.user.UsersRs;
import tms.practice.service.user.UserService;

public class UserSteps {

  private final UserService userService;

  public UserSteps(UserService userService) {
    this.userService = userService;
  }

  @Step("Получаем список всех пользователей")
  public UsersRs getUsers(){
    return userService.getUsersRs();
  }
}
