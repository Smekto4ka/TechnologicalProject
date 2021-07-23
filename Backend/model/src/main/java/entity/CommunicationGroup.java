package entity;

import data.GroupType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CommunicationGroup {
    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "interlocutors")
    private List<User> users = new ArrayList<>();

    private String name;
    @OneToMany
    private List<Message> messages = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private GroupType groupType;
}
