import java.time.Duration;
import java.util.Objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

  protected static final String BASE_URL = "https://the-internet.herokuapp.com";
  protected static final String URL_PATTERN = "%s%s";
  private static final Integer WAIT_TIME = 10;

  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (Objects.nonNull(driver)) {
      driver.close();
      driver.quit();
    }
  }
}
