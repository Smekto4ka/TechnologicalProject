package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
public class User {
    @Id
    private Long id;
    @Embedded
    private SecurityData securityData;

    private String nick;
    private String lastName;
    private String firstName;
    private Long age;

    @ManyToMany(mappedBy = "users")
    private List<CommunicationGroup> groups = new ArrayList<>();
}
