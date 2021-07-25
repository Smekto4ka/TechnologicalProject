package ru.oogis.dto;

import ru.oogis.data.GroupType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommunicationGroupInfo {
    private Long id;
    private String name;
    private GroupType groupType;
}
