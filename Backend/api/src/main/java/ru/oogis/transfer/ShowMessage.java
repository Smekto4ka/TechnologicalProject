package ru.oogis.transfer;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ShowMessage {
    @NotNull
    @Valid
    private ShowUserInfo sender;
    @NotEmpty
    @Size(min = 1)
    private String message;
}
