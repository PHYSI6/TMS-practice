package tms.practice.db;

import io.qameta.allure.Step;
import tms.practice.api.assertion.AssertionSteps;
import tms.practice.db.entity.user.UserEntity;

import static tms.practice.api.assertion.SoftAssertionsStorage.softAssert;

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
