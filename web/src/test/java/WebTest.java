import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WebTest {

  @DisplayName("Веб калькулятор боооньк")
  @Test
  public void webTest() {
    assertEquals(2, 1 + 1);
  }
}
