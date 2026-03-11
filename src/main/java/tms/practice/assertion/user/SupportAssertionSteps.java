package tms.practice.assertion.user;

import io.qameta.allure.Step;
import tms.practice.assertion.InnerClassAssertionSteps;
import tms.practice.response.user.Support;

import static tms.practice.assertion.SoftAssertionsStorage.softAssert;

public class SupportAssertionSteps<T> extends InnerClassAssertionSteps<T> {

  private final Support support;

  public SupportAssertionSteps(T outerStepsInstance,
                               Support support) {
    super(outerStepsInstance);
    this.support = support;
  }

  @Step("Проверяем, что 'url' != null")
  public SupportAssertionSteps<T> assertUrlIsNotNull() {
    softAssert().assertThat(support.getUrl())
        .isNotNull();
    return this;
  }
}
