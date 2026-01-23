package tms.practice.page_object.page.products;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page_object.BasePage;

public class ProductsPage extends BasePage {

  public static final String TITLE_TEXT = "Products";
  public static final By TITLE = By.xpath("//*[@data-test='title']");

  public ProductsPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  @Override
  public BasePage waitForLoad() {
    wait.until(isTrue -> Objects.equals(driver.findElement(TITLE).getText(), TITLE_TEXT));
    return this;
  }
}

