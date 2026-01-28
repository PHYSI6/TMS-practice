package tms.practice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WaitUtils {

  /**
   * Ожидает необходимое количество секунд.
   *
   * @param seconds необходимое количество секунд для ожидания
   */
  public static void waitInSeconds(Integer seconds) {
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
