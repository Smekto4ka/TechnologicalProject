package ru.oogis.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private SecurityData securityData;

    private String nick;
    private String lastName;
    private String firstName;
    private Long age;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<CommunicationGroup> groups = new ArrayList<>();
}
