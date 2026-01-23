package page_object.login;

import org.testng.annotations.Test;
import page_object.BaseTest;
import tms.practice.page_object.page.login.LoginPage;
import tms.practice.page_object.page.products.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

  @Test
  public void shouldLoginWithValidCredentials() {
    LoginPage loginPage = new LoginPage(driver, wait);
    ProductsPage productsPage = new ProductsPage(driver, wait);
    final String userName = "standard_user";
    final String password = "secret_sauce";
    loginPage.open()
        .waitForLoad()
        .typeUserName(userName)
        .typePassword(password)
        .clickLoginButton();
    assertThat(productsPage.isLoaded())
        .as("Страница с продуктами не открыта")
        .isTrue();
  }
}
