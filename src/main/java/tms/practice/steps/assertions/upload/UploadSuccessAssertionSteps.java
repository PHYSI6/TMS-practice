package tms.practice.steps.assertions.upload;

import io.qameta.allure.Step;
import tms.practice.page.upload.UploadSuccessPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UploadSuccessAssertionSteps {

  private UploadSuccessPage uploadSuccessPage;

  public UploadSuccessAssertionSteps(UploadSuccessPage uploadSuccessPage) {
    this.uploadSuccessPage = uploadSuccessPage;
  }

  @Step("Проверяем, что название файла = '{fileName}'")
  public UploadSuccessAssertionSteps assertFileName(String fileName) {
    assertThat(fileName)
        .as("Название загруженного файла '%s' не совпадает '%s'".formatted(fileName, uploadSuccessPage.getFileName()))
        .isEqualTo(uploadSuccessPage.getFileName());
    return this;
  }

  @Step("Проверяем, что название файла = '{fileName}'")
  public UploadSuccessAssertionSteps assertFileName2(String fileName) {
    assertThat(fileName + "dd")
        .as("Название загруженного файла '%s' не совпадает '%s'".formatted(fileName, uploadSuccessPage.getFileName()))
        .isEqualTo(uploadSuccessPage.getFileName());
    return this;
  }
}
