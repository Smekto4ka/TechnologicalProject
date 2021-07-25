package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Setter
@Getter
public class ShowSecurity {

    @Null(groups = Marker.OnCreate.class)
    @NotNull(groups = Marker.OnUpdate.class)
    @Min(value = 1, groups = Marker.OnUpdate.class)
    private Long userId;
    @NotNull
    private String login;
    @NotNull
    private String password;
}
