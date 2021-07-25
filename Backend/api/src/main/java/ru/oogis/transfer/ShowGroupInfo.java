package ru.oogis.transfer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class ShowGroupInfo {
    @Null(groups = Marker.OnCreate.class)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private ShowGroupType groupType;
}
