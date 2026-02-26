package tms.practice.page.upload;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tms.practice.element.FileUploader;
import tms.practice.page.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UploadPage extends BasePage {

  private static final String TITLE = "File Uploader";
  private static final String URL = "https://the-internet.herokuapp.com/upload";

  private final SelenideElement title = $("h3");
  private final FileUploader fileUploader = new FileUploader($(byId("file-upload")));
  private final SelenideElement uploadButton = $(byId("file-submit"));

  @Step("Открываем страницу по url '" + URL + "'")
  public static UploadPage openPage() {
    return open(URL, UploadPage.class);
  }

  @Step("Ожидаем загрузки страницы загрузки файла")
  @Override
  public UploadPage waitForLoad() {
    title.shouldHave(exactText(TITLE));
    return this;
  }

  @Step("Загружаем файл по пути '{filePath}'")
  public UploadPage upload(String filePath) {
    fileUploader.upload(filePath);
    return this;
  }

  @Step("Нажимаем на кнопку загрузки")
  public UploadSuccessPage clickUploadButton() {
    uploadButton.click();
    return Selenide.page(UploadSuccessPage.class);
  }
}