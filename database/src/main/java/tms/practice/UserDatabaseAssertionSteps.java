package tms.practice;

import io.qameta.allure.Step;
import steps.assertion.AssertionSteps;
import tms.practice.entity.user.UserEntity;

import static steps.assertion.SoftAssertionsStorage.softAssert;


public class UserDatabaseAssertionSteps extends AssertionSteps {

  private final UserEntity userEntity;

  public UserDatabaseAssertionSteps(UserEntity userEntity) {
    this.userEntity = userEntity;
  }

  @Step("Проверяем, что имя пользователя в БД равно '{username}'")
  public UserDatabaseAssertionSteps assertUserName(String username) {
    softAssert().assertThat(userEntity.getUsername())
        .as("Имя пользователя в БД не соответствует ожидаемому")
        .isEqualTo(username);
    return this;
  }
}
