package tms.practice.assertion.user;

import io.qameta.allure.Step;
import tms.practice.assertion.AssertionSteps;
import tms.practice.response.user.UsersRs;

public class UsersRsAssertionSteps extends AssertionSteps {

  private final UsersRs userRs;

  public UsersRsAssertionSteps(UsersRs userRs) {
    this.userRs = userRs;
  }

  @Step("Проверяем 'data'")
  public UserAssertionSteps<UsersRsAssertionSteps> dataAssertionSteps() {
    return new UserAssertionSteps<>(this, userRs.getData());
  }

  @Step("Проверяем 'support'")
  public SupportAssertionSteps<UsersRsAssertionSteps> supportAssertionSteps() {
    return new SupportAssertionSteps<>(this, userRs.getSupport());
  }
}
