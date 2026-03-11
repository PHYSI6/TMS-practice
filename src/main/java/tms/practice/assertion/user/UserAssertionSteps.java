package tms.practice.assertion.user;

import java.util.List;

import io.qameta.allure.Step;
import tms.practice.assertion.InnerClassAssertionSteps;
import tms.practice.response.user.User;

import static tms.practice.assertion.SoftAssertionsStorage.softAssert;

public class UserAssertionSteps<T> extends InnerClassAssertionSteps<T> {
  private final List<User> user;

  public UserAssertionSteps(T outerStepsInstance,
                            List<User> user) {
    super(outerStepsInstance);
    this.user = user;
  }

  @Step("Проверяем, что у первого пользователя 'id' = '{id}'")
  public UserAssertionSteps<T> assertFirstId(Integer id) {
    softAssert().assertThat(user.getFirst().getId())
        .isEqualTo(id);
    return this;
  }
}
