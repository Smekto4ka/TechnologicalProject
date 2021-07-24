package data.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SecurityDto {
    private Long userId;
    private String login;
    private String password;
}
