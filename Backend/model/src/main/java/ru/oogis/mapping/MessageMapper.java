package ru.oogis.mapping;

import ru.oogis.dto.MessageDto;
import ru.oogis.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {UserMapper.class})
public interface MessageMapper {
    MessageDto messageToMessageInfo(Message message);
}
