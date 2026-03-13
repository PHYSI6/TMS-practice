package tms.practice.api.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tms.practice.api.response.Rs;
import tms.practice.db.enums.Role;

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
