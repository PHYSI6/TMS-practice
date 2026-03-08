package tms.practice.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class WaitUtils {

  /**
   * Ожидает необходимое количество секунд.
   *
   * @param seconds необходимое количество секунд для ожидания
   */
  public static void waitInSeconds(Integer seconds) {
    try {
      log.info("Ожидаем '%s' секунд".formatted(seconds));
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      log.error("Возникла проблема при попытке ожидания");
      throw new RuntimeException(e);
    }
  }
}
