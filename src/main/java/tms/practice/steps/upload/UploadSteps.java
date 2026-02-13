package tms.practice.steps.upload;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import tms.practice.page.PageFactoryManager;
import tms.practice.page.upload.UploadPage;

public class UploadSteps {

  private WebDriver driver;

  public UploadSteps(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Выполняем загрузку файла")
  public UploadSteps upload(String filePath) {
    PageFactoryManager.create(UploadPage.class, driver)
        .open()
        .waitForLoad()
        .upload(filePath)
        .clickUploadButton();
    return this;
  }
}
