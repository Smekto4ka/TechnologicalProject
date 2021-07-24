package mapping;

import data.dto.MessageDto;
import data.dto.UserInfo;
import entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {UserInfoMapper.class})
public interface MessageMapper {
    MessageDto messageToMessageInfo(Message message);
}
