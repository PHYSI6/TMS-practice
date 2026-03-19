package tms.practice.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tms.practice.enums.Role;
import tms.practice.response.Rs;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersRs implements Rs {
  private Long id;
  private String username;
  private String password;
  private Role role;
}
