package tms.practice.page;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage {

  private static final Integer WAIT_TIME = 10;
  protected final WebDriver driver;
  protected final WebDriverWait wait;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
    PageFactory.initElements(
        new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),
        this
    );
  }

  /**
   * Ожидает загрузки экрана и возвращает объект экрана
   */
  public abstract BasePage waitForLoad();

  /**
   * Проверяет, загрузился ли экран
   */
  public boolean isLoaded() {
    try {
      waitForLoad();
      return true;
    } catch (NoSuchElementException | TimeoutException e) {
      return false;
    }
  }
}