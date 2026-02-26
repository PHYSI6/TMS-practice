import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import tms.practice.config.DriverFactory;

public abstract class BaseTest {

  @BeforeSuite
  public void allureSetup() {
    Configuration.timeout = 10000; // ожидание элементов
    Configuration.pageLoadTimeout = 20000; // загрузка страницы
    Configuration.pollingInterval = 200; // частота проверок
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(true)
        .savePageSource(true));
  }

  @BeforeMethod
  public void setUp() {
    Selenide.open(DriverFactory.createChrome());
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    Selenide.closeWebDriver();
  }
}
