package ru.oogis.transfer;

import data.dto.CommunicationGroupInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ShowUser {
    private Long id;
    private String nick;
    private String lastName;
    private String firstName;
    private Long age;
    private List<ShowGroupInfo> groups;
}
