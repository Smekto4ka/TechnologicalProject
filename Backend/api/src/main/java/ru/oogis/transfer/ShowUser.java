package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;
import validation.EnableMatchConstraint;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Setter
@Getter
@EnableMatchConstraint
public class ShowUser {
    @Null(groups = Marker.OnCreate.class)
    @NotNull(groups = Marker.OnUpdate.class)
    @Min(value = 1, groups = Marker.OnUpdate.class)
    private Long id;
    @NotNull
 //   @CheckNick()
    private String nick;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private Long age;
    @Valid
    private List<ShowGroupInfo> groups;
}
