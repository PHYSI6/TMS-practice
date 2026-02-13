package tms.practice.config;

import java.util.Map;
import java.util.Objects;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

@UtilityClass
public class DriverFactory {

  private static WebDriver driver;

  public WebDriver getInstance() {
    if (Objects.isNull(driver)) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-notifications");
      options.addArguments("--disable-infobars");
      options.addArguments("--disable-save-password-bubble");
      options.setExperimentalOption(
          "prefs",
          Map.of(
              "credentials_enable_service", false,
              "profile.password_manager_enabled", false,
              "profile.password_manager_leak_detection", false
          )
      );
      driver = new ChromeDriver(options);
    }
    return driver;
  }

  public WebDriver createSafari() {
    return new SafariDriver();
  }
}
