package ru.oogis.service;

import ru.oogis.dto.MessageDto;
import ru.oogis.entity.Message;

public interface MessageService {

    Message createMessage(MessageDto messageDto);
}
