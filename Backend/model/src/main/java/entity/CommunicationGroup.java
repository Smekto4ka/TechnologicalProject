package entity;

import java.util.ArrayList;
import java.util.List;

public class CommunicationGroup {
    private Long id;
    private List<User> users = new ArrayList<>();
    private String name;
    private List<Message> messages = new ArrayList<>();
}
