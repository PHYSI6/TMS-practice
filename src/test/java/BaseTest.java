import java.time.Duration;
import java.util.Map;
import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

  private static final Integer WAIT_TIME = 10;

  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
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
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    if (Objects.nonNull(driver)) {
      if (result.getStatus() == ITestResult.FAILURE) {
        attachScreenshot();
      }
      driver.quit();
    }
  }

  @Attachment(value = "Screenshot (on failure)", type = "image/png")
  private byte[] attachScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
