package tms.practice.page.upload;

import java.util.Objects;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page.BasePage;

@Story("dfdsf")
@Tag("web")
public class UploadPage extends BasePage {

  private static final String TITLE = "File Uploader";
  private static final String URL = "https://the-internet.herokuapp.com/upload";

  @FindBy(tagName = "h3")
  private WebElement title;

  @FindBy(id = "file-upload")
  private WebElement fileUploader;

  @FindBy(id = "file-submit")
  private WebElement uploadButton;

  public UploadPage(WebDriver driver,
                    WebDriverWait wait) {
    super(driver, wait);
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
    fileUploader.sendKeys(filePath);
    return this;
  }

  @Step("Нажимаем на кнопку загрузки")
  public void clickUploadButton() {
    uploadButton.click();
  }
}
