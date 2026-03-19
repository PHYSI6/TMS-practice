import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WebTest {

  @Test(description = "Туда-сюда WEB")
  public void webTest() {
    assertEquals(2, 1 + 1);
  }
}
