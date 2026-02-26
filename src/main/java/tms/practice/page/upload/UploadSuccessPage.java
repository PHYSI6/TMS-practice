package tms.practice.page.upload;

import java.time.Duration;

import io.qameta.allure.Step;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import tms.practice.page.BasePage;

import static com.codeborne.selenide.Condition.exactText;

public class UploadSuccessPage extends BasePage {

  public static final String TITLE = "File Uploaded!";

  @FindBy(how = How.TAG_NAME, using = "h")
  private SelenideElement title;

  @FindBy(id = "uploaded-files")
  private SelenideElement fileName;

  @Step("Ожидаем загрузки страницы успешности загрузки файла")
  @Override
  public UploadSuccessPage waitForLoad() {
    title.shouldHave(exactText(TITLE), Duration.ofSeconds(20));
    return this;
  }

  @Step("Получаем название файла")
  public String getFileName() {
    return fileName.getText();
  }
}
