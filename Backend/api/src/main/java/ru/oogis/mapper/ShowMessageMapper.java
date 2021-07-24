package ru.oogis.mapper;

import data.dto.MessageDto;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowMessage;

@Mapper(componentModel = "spring" )
public interface ShowMessageMapper {

    ShowMessage messageDtoToShowMessage (MessageDto messageDto);
    MessageDto showMessageToMessageDto(ShowMessage showMessage);
}
