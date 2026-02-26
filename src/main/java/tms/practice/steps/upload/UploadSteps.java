package tms.practice.steps.upload;

import io.qameta.allure.Step;
import tms.practice.page.upload.UploadPage;

public class UploadSteps {

  @Step("Выполняем загрузку файла")
  public UploadSteps upload(String filePath) {
    UploadPage.openPage()
        .waitForLoad()
        .upload(filePath)
        .clickUploadButton()
        .waitForLoad();
    return this;
  }
}
