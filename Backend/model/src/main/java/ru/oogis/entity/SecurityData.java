package ru.oogis.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Embeddable
public class SecurityData {
    @NotNull
    private String login;
    @NotNull
    private String password;

}
