package ru.oogis.mapping;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.dto.MessageDto;
import ru.oogis.entity.Message;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-02T14:55:34+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public MessageDto messageToMessageInfo(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setSender( userMapper.userToUserInfo( message.getSender() ) );
        messageDto.setMessage( message.getMessage() );

        return messageDto;
    }
}
