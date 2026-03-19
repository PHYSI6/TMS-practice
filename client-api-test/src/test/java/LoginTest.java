import org.testng.annotations.Test;


public class LoginTest {

  @Test(description = "Api туда-сюда")
  public void updateUser() {
   /* LoginMixedSteps loginMixedSteps = new LoginMixedSteps(new LoginService());
    UserSteps userSteps = new UserSteps(new UserService());
    String username = Faker.instance().name().username();
    UserDatabaseSteps userDatabaseSteps = new UserDatabaseSteps(new UserDatabaseService());
    UserRq userRq = UserRq.builder()
        .username(username)
        .password("123")
        .build();
    UserCommon userCommon = loginMixedSteps.login(userRq);
    List<UsersRs> usersRs = userSteps.getAll(userCommon);
    UsersRs randomUserRs = usersRs.stream()
        .filter(s -> !s.getUsername().equals(userRq.getUsername()))
        .findAny()
        .orElse(null);
    String newUserName = Faker.instance().name().username();
    randomUserRs.setUsername(newUserName);
    userSteps.update(userCommon, randomUserRs);
    UserEntity userEntity = userDatabaseSteps.getById(randomUserRs.getId());
    new UserDatabaseAssertionSteps(userEntity)
        .assertUserName(newUserName)
        .assertAll();*/
  }
}
