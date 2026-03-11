package tms.practice.response.user;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersRs implements Rs{
  private String id;
  private Timestamp createdAt;
  private Integer page;
  @JsonProperty("per_page")
  private Integer perPage;
  private Integer total;
  private List<User> data;
  //private Object data;
  private Support support;
}
