package tms.practice.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import tms.practice.config.DriverFactory;

public class Hooks {

  @BeforeAll
  public static void allureSetup() {
    Configuration.timeout = 10000; // ожидание элементов
    Configuration.pageLoadTimeout = 20000; // загрузка страницы
    Configuration.pollingInterval = 200; // частота проверок
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(true)
        .savePageSource(true));
  }

  @Before
  public static void setUp() {
    Selenide.open(DriverFactory.createChrome());
  }

  @After
  public static void tearDown() {
    Selenide.closeWebDriver();
  }
}
