import java.nio.file.Path;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import tms.practice.assertions.upload.UploadSuccessAssertionSteps;
import tms.practice.page.upload.UploadSuccessPage;
import tms.practice.steps.upload.UploadSteps;

@Story("Работа с файлами")
public class UploadTest extends BaseTest {

  @Test(description = "Загрузка файла")
  @Description("Проверяет успешность загрузки файла")
  @Link("https://mvnrepository.com/search?q=allure")
  @TmsLink("123123")
  public void fileUpload() {
    final String fileName = "base_schema.xml";
    final String filePath = Path.of("src", "main", "resources", "files", fileName).toAbsolutePath().toString();
    new UploadSteps()
        .upload(filePath);
    //new UploadSuccessAssertionSteps(PageFactoryManager.create(UploadSuccessPage.class))
    new UploadSuccessAssertionSteps(Selenide.page(UploadSuccessPage.class))
        .assertFileName2(fileName)
        .assertFileName(fileName)
        .assertAll();
  }
}