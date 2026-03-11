import org.testng.annotations.Test;
import tms.practice.assertion.user.UsersRsAssertionSteps;
import tms.practice.response.user.User;
import tms.practice.response.user.UsersRs;
import tms.practice.service.user.UserService;
import tms.practice.steps.user.UserSteps;

public class UsersTest {

  @Test
  public void testGetUser() {
    UsersRs usersRs = new UserSteps(new UserService())
        .getUsers();
    new UsersRsAssertionSteps(usersRs)
        .dataAssertionSteps()
        .assertFirstId(1)
        .stepBack()
        .supportAssertionSteps()
        .assertUrlIsNotNull()
        .stepBack()
        .assertAll();
  }

  @Test
  public void testCreateUser() {
    User user = User.builder()
        .email("ddd@reqres.in")
        .firstName("Daniil")
        .lastName("Bor")
        .build();
    new UserSteps(new UserService())
        .createUser(user);
  }

  @Test
  public void testUpdateUser() {

    UserSteps userSteps = new UserSteps(new UserService());
    User randomUser = userSteps.getUsers().getData()
        .stream()
        .findAny()
        .orElse(null);
    randomUser.setEmail("borisevich@mail.ru");
  }
}
