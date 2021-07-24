package ru.oogis.mapper;

import data.dto.MessageDto;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.transfer.ShowUserInfo;

@Mapper(componentModel = "spring" , uses = {ShowUserInfoMapper.class})
public interface ShowMessageMapper {

    ShowMessage messageDtoToShowMessage (MessageDto messageDto);
    MessageDto showMessageToMessageDto(ShowMessage showMessage);
}
