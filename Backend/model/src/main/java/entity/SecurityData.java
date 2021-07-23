package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Setter
@Getter
@Entity
public class SecurityData {
    @Id
    private Long id;
    private String login;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}
