package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Setter
@Getter
public class ShowGroup {
    @Null(groups = Marker.OnCreate.class)
    @NotNull(groups = Marker.OnUpdate.class)
    @Min(value = 1 , groups = Marker.OnUpdate.class)
    private Long id;
    @Valid
    private List<ShowUserInfo> users;
    @NotNull
    private String name;
    @Null(groups = Marker.OnCreate.class)
    private List<ShowMessage> messages;
    @NotNull
    private ShowGroupType groupType;
}
