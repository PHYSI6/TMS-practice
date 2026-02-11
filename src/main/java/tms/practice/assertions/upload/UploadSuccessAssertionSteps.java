package tms.practice.assertions.upload;

import io.qameta.allure.Step;
import tms.practice.page.upload.UploadSuccessPage;

import static tms.practice.assertions.upload.SoftAssertionsStorage.softAssert;

public class UploadSuccessAssertionSteps extends AssertionSteps {

  private UploadSuccessPage uploadSuccessPage;

  public UploadSuccessAssertionSteps(UploadSuccessPage uploadSuccessPage) {
    this.uploadSuccessPage = uploadSuccessPage;
  }

  @Step("Проверяем, что название файла = '{fileName}'")
  public UploadSuccessAssertionSteps assertFileName(String fileName) {
    softAssert().assertThat(fileName)
        .as("Название загруженного файла '%s' не совпадает '%s'".formatted(fileName, uploadSuccessPage.getFileName()))
        .isEqualTo(uploadSuccessPage.getFileName());
    return this;
  }

  @Step("Проверяем, что название файла = '{fileName}'")
  public UploadSuccessAssertionSteps assertFileName2(String fileName) {
    softAssert().assertThat(fileName)
        .as("Название загруженного файла '%s' не совпадает '%s'".formatted(fileName, uploadSuccessPage.getFileName()))
        .isEqualTo(uploadSuccessPage.getFileName());
    return this;
  }
}
