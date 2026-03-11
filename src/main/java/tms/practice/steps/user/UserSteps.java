package tms.practice.steps.user;

import io.qameta.allure.Step;
import tms.practice.response.user.User;
import tms.practice.response.user.UsersRs;
import tms.practice.service.user.UserService;

public class UserSteps {

  private final UserService userService;

  public UserSteps(UserService userService) {
    this.userService = userService;
  }

  @Step("Получаем список всех пользователей")
  public UsersRs getUsers(){
    return userService.getUsers();
  }

  @Step("Создаем пользователя")
  public UsersRs createUser(User user){
    return userService.postUsers(user);
  }

  @Step("Обновляем пользователя c 'id' = '{user.id}'")
  public UsersRs updateUser(User user){
    return userService.putUsers(user);
  }
}
