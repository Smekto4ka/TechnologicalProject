package ru.oogis.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String nick;
    private String lastName;
    private String firstName;
    private Long age;
    private List<CommunicationGroupInfo> groups;
}
