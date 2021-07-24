package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowGroupInfo {
    private Long id;
    private String name;
    private ShowGroupType groupType;
}
