package ru.oogis.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDto {

    private UserInfo sender;

    private String message;
}
