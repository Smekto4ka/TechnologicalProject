package mapping;

import data.dto.MessageDto;
import entity.Message;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T15:05:30+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public MessageDto messageToMessageInfo(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setSender( userInfoMapper.userToUserInfo( message.getSender() ) );
        messageDto.setMessage( message.getMessage() );

        return messageDto;
    }
}
