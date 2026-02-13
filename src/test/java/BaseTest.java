import java.util.Map;
import java.util.Objects;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tms.practice.config.DriverFactory;

public abstract class BaseTest {

  protected WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = DriverFactory.getInstance();
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
