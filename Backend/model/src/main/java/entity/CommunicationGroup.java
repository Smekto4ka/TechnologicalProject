package entity;

import data.GroupType;
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
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "groups")
    private List<User> users = new ArrayList<>();

    private String name;
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private GroupType groupType;
}
