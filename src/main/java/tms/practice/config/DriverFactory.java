package tms.practice.config;

import java.util.Map;

import com.codeborne.selenide.SelenideConfig;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.chrome.ChromeOptions;

@UtilityClass
public class DriverFactory {

  public SelenideConfig createChrome() {
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
    return new SelenideConfig()
        .headless(true)
        .browserCapabilities(options)
        .browser("chrome");
  }
}
