package ru.oogis.dto;

import ru.oogis.data.GroupType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommunicationGroupDto {

    private Long id;
    private List<UserInfo> users ;
    private String name;
    private List<MessageDto> messages;
    private GroupType groupType;
}
