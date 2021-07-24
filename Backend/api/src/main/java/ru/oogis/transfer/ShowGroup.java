package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ShowGroup {
    private Long id;
    private List<ShowUserInfo> users;
    private String name;
    private List<ShowMessage> messages;
    private ShowGroupType groupType;
}
