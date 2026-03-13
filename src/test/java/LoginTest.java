import java.util.List;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.RepeatedTest;
import org.testng.annotations.Test;
import tms.practice.api.entity.UserCommon;
import tms.practice.api.request.UserRq;
import tms.practice.api.response.user.UsersRs;
import tms.practice.api.service.login.LoginService;
import tms.practice.api.service.user.UserService;
import tms.practice.api.steps.login.LoginMixedSteps;
import tms.practice.api.steps.user.UserSteps;
import tms.practice.db.UserDatabaseAssertionSteps;
import tms.practice.db.entity.user.UserEntity;
import tms.practice.db.service.user.UserDatabaseService;
import tms.practice.db.steps.user.UserDatabaseSteps;

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
