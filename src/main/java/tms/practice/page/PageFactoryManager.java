package tms.practice.page;

import com.codeborne.selenide.Selenide;

public class PageFactoryManager {

  // не нужно больше
  public static <T> T create(Class<T> pageClass) {
    return Selenide.page(pageClass);
  }
}
