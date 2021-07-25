package ru.oogis.entity;

import com.sun.istack.NotNull;
import ru.oogis.data.GroupType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
public class CommunicationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups")
    private List<User> users = new ArrayList<>();
    @NotNull
    private String name;
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();
    @NotNull
    @Enumerated(EnumType.STRING)
    private GroupType groupType;
}
