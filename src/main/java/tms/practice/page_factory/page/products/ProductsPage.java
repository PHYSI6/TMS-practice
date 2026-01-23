package tms.practice.page_factory.page.products;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page_factory.BasePage;

public class ProductsPage extends BasePage {

  public static final String TITLE_TEXT = "Products";

  @FindBy(xpath = "//*[@data-test='title']")
  private WebElement title;

  public ProductsPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  @Override
  public ProductsPage waitForLoad() {
    wait.until(d -> Objects.equals(title.getText(), TITLE_TEXT));
    return this;
  }
}
