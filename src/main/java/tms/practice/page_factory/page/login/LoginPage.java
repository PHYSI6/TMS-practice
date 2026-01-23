package tms.practice.page_factory.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page_factory.BasePage;

public class LoginPage extends BasePage {

  public static final String TITLE_TEXT = "Swag Labs";

  private static final String URL = "https://www.saucedemo.com/";

  @FindBy(id = "user-name")
  private WebElement usernameField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  public LoginPage(WebDriver driver,
                   WebDriverWait wait) {
    super(driver, wait);
  }

  @Override
  public LoginPage waitForLoad() {
    wait.until(ExpectedConditions.visibilityOf(loginButton));
    return this;
  }

  public LoginPage open() {
    driver.get(URL);
    return this;
  }

  public LoginPage typeUserName(String username) {
    usernameField.sendKeys(username);
    return this;
  }

  public LoginPage typePassword(String password) {
    passwordField.sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}