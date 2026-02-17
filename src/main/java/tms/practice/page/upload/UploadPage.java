package tms.practice.page.upload;

import java.util.Objects;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.FileInput;
import tms.practice.page.BasePage;
import tms.practice.utils.WaitUtils;

@Log4j2
public class UploadPage extends BasePage {

  private static final String TITLE = "File Uploader";
  private static final String URL = "https://the-internet.herokuapp.com/upload";

  @FindBy(tagName = "h3")
  private WebElement title;

  @FindBy(id = "file-upload")
  private FileInput fileUploader;

  @FindBy(id = "file-submit")
  private Button uploadButton;

  public UploadPage(WebDriver driver) {
    super(driver);
  }

  @Step("Ожидаем загрузки страницы загрузки файла")
  @Override
  public UploadPage waitForLoad() {
    wait.until(isTrue -> Objects.equals(title.getText(), TITLE));
    return this;
  }

  @Step("Открываем страницу по url: " + URL)
  public UploadPage open() {
    driver.get(URL);
    return this;
  }

  @Step("Загружаем файл по пути '{filePath}'")
  public UploadPage upload(String filePath) {
    fileUploader.setFileToUpload(filePath);
    return this;
  }

  @Step("Нажимаем на кнопку загрузки")
  public void clickUploadButton() {
    uploadButton.click();
  }
}
