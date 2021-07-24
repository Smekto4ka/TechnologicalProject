package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShowSecurity {
    private Long userId;
    private String login;
    private String password;
}
