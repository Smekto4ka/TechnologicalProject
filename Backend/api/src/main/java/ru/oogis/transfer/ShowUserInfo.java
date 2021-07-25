package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ShowUserInfo {
    @NotNull
    @Min(1)
    private Long id;
    private String nick;
}
