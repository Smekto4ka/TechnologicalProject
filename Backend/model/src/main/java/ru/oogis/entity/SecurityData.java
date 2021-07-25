package ru.oogis.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Embeddable
public class SecurityData {
    private String login;
    private String password;

}
