package ru.oogis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.dto.MessageDto;
import ru.oogis.transfer.ShowMessage;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-25T17:52:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ShowMessageMapperImpl implements ShowMessageMapper {

    @Autowired
    private ShowUserMapper showUserMapper;

    @Override
    public ShowMessage messageDtoToShowMessage(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        ShowMessage showMessage = new ShowMessage();

        showMessage.setSender( showUserMapper.userInfoToShowUserInfo( messageDto.getSender() ) );
        showMessage.setMessage( messageDto.getMessage() );

        return showMessage;
    }

    @Override
    public MessageDto showMessageToMessageDto(ShowMessage showMessage) {
        if ( showMessage == null ) {
            return null;
        }

        MessageDto messageDto = new MessageDto();

        messageDto.setSender( showUserMapper.showUserInfoToUserInfo( showMessage.getSender() ) );
        messageDto.setMessage( showMessage.getMessage() );

        return messageDto;
    }
}
