
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import tms.practice.page.upload.UploadSuccessPage;
import tms.practice.steps.bus.upload.UploadSteps;
import tms.practice.steps.assertions.upload.UploadSuccessAssertionSteps;

@Story("Работа с файлами")
public class UploadTest extends BaseTest {

  @Test(description = "Загрузка файла")
  @Description("Проверяет успешность загрузки файла")
  @Link("https://mvnrepository.com/search?q=allure")
  @TmsLink("123123")
  public void fileUpload() {
    final String fileName = "base_schema.xml";
    final String filePath =
        "/Users/danborisevich/Downloads/УЧЕБА/practice-makes-perfect/src/main/resources/files/%s".formatted(fileName);
    new UploadSteps(driver, wait)
        .upload(filePath);
    new UploadSuccessAssertionSteps(new UploadSuccessPage(driver, wait))
        .assertFileName(fileName)
        .assertFileName2(fileName);
  }
}
