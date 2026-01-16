import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HerokuappTest extends BaseTest {

  private final By ADD_ELEMENT_BTN = By.xpath("//button[text()='Add Element']");
  private final By DELETE_BTN = By.xpath("//button[text()='Delete']");

  @BeforeMethod
  public void preconditions() {
    final String pageEndpoint = "/add_remove_elements/";
    final String pageUrl = String.format(URL_PATTERN, BASE_URL, pageEndpoint);
    driver.get(pageUrl);
    WebElement addButton = driver.findElement(ADD_ELEMENT_BTN);
    addButton.click();
    addButton.click();
  }

  @Test
  public void addTwoElements() {
    wait.until(d -> d.findElements(DELETE_BTN).size() == 2);
    assertThat(driver.findElements(DELETE_BTN).size())
        .as("После двух добавлений должно быть 2 кнопки Delete")
        .isEqualTo(2);
  }

  @Test
  public void deleteTwoElements() {
    List<WebElement> deleteButtons = driver.findElements(DELETE_BTN);
    deleteButtons.forEach(WebElement::click);
    wait.until(d -> d.findElements(DELETE_BTN).isEmpty());
    assertThat(driver.findElements(DELETE_BTN).size())
        .as("Послу удаления двух кнопок должно остаться 0 кнопок Delete")
        .isEqualTo(0);
  }
}
