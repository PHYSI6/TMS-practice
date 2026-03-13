package db;

import org.testng.annotations.Test;
import tms.practice.db.service.user.UserDatabaseService;

public class UserDbTest {

  @Test
  public void testUserDb() {
    UserDatabaseService userService = new UserDatabaseService();
    System.out.println(userService.getUserById(1L));
  }
}
