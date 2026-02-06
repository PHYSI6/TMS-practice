package tms.practice.steps.bus.upload;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page.upload.UploadPage;

public class UploadSteps {

  private WebDriver driver;
  private WebDriverWait wait;

  public UploadSteps(WebDriver driver,
                     WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  @Step("Выполняем загрузку файла")
  public UploadSteps upload(String filePath) {
    new UploadPage(driver, wait)
        .open()
        .waitForLoad()
        .upload(filePath)
        .clickUploadButton();
    return this;
  }
}
