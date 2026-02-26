package tms.practice.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public abstract class BasePage {

  public abstract BasePage waitForLoad();

  public boolean isLoaded() {
    try {
      waitForLoad();
      return true;
    } catch (NoSuchElementException | TimeoutException e) {
      return false;
    }
  }

  protected void shouldBeVisible(SelenideElement element) {
    element.shouldBe(com.codeborne.selenide.Condition.visible);
  }
}
