package ru.oogis.service.impl;

import ru.oogis.dto.MessageDto;
import ru.oogis.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oogis.repository.MessageRepository;
import ru.oogis.repository.UserRepository;
import ru.oogis.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public Message createMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setSender(userRepository.findById(messageDto.getSender().getId()).orElseThrow());
        messageRepository.save(message);
        return message;
    }
}
