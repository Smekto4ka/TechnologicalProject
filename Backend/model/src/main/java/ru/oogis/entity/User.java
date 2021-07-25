package ru.oogis.entity;


import com.sun.istack.NotNull;
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
    @NotNull
    private String nick;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private Long age;

    @ManyToMany(mappedBy = "users")
    private List<CommunicationGroup> groups = new ArrayList<>();
}
