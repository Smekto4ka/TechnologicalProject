package service.impl;

import data.dto.MessageDto;
import entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.MessageRepository;
import repository.UserRepository;
import service.MessageService;

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
