package tms.practice.page;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

  public static <T> T create(Class<T> pageClass,
                             WebDriver driver) {
    try {
      return pageClass.getConstructor(WebDriver.class).newInstance(driver);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
