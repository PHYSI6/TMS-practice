import java.util.List;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import tms.practice.UserDatabaseAssertionSteps;
import tms.practice.entity.UserCommon;
import tms.practice.entity.user.UserEntity;
import tms.practice.request.UserRq;
import tms.practice.response.user.UsersRs;
import tms.practice.service.login.LoginService;
import tms.practice.service.user.UserDatabaseService;

import tms.practice.service.user.UserService;
import tms.practice.steps.login.LoginMixedSteps;
import tms.practice.steps.user.UserDatabaseSteps;
import tms.practice.steps.user.UserSteps;


public class LoginTest {

  @Test
  public void updateUser() {
    LoginMixedSteps loginMixedSteps = new LoginMixedSteps(new LoginService());
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
        .assertAll();
  }
}
