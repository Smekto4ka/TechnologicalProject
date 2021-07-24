package ru.oogis.transfer;

import data.dto.UserInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShowMessage {

    private ShowUserInfo sender;
    private String message;
}
