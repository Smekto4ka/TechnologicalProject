package entity;


import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private SecurityData securityData;

    private String lastName;
    private String firstName;
    private Long age;

    private List<CommunicationGroup> groups = new ArrayList<>();
}
