package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Setter
@Getter
public class SecurityData {
    @Id
    private Long id;
    private String login;
    private String password;
    @OneToOne
    private User user;


}
