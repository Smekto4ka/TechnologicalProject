package service;

import data.dto.MessageDto;
import entity.Message;

public interface MessageService {

    Message createMessage(MessageDto messageDto);
}
