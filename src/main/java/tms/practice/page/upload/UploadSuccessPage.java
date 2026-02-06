package tms.practice.page.upload;

import java.util.Objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tms.practice.page.BasePage;

public class UploadSuccessPage extends BasePage {

  public static final String TITLE = "File Uploaded!";

  @FindBy(tagName = "h3")
  private WebElement title;

  @FindBy(id = "uploaded-files")
  private WebElement fileName;

  public UploadSuccessPage(WebDriver driver,
                           WebDriverWait wait) {
    super(driver, wait);
  }

  @Step("Ожидаем загрузки страницы успешности загрузки файла")
  @Override
  public UploadSuccessPage waitForLoad() {
    wait.until(isTrue -> Objects.equals(title.getText(), TITLE));
    return this;
  }

  @Step("Получаем название файла")
  public String getFileName() {
    return fileName.getText();
  }
}
