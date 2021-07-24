package data.dto;

import data.GroupType;
import entity.Message;
import entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
