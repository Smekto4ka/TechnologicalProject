package entity;


import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class User {
    @Id
    private Long id;
    @OneToOne
    private SecurityData securityData;

    private String lastName;
    private String firstName;
    private Long age;

    @ManyToMany(mappedBy = "MessageGroups")
    private List<CommunicationGroup> groups = new ArrayList<>();
}
