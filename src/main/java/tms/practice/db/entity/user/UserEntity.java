package tms.practice.db.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tms.practice.db.enums.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  private Long id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private Role role;
}
