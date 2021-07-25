package ru.oogis.mapper;

import ru.oogis.dto.MessageDto;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowMessage;


@Mapper(componentModel = "spring" , uses = {ShowUserMapper.class})
public interface ShowMessageMapper {

    ShowMessage messageDtoToShowMessage (MessageDto messageDto);
    MessageDto showMessageToMessageDto(ShowMessage showMessage);
}
