package mapping;

import data.dto.UserDto;
import data.dto.UserInfo;
import entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CommunicationMapper.class})
public interface UserMapper extends UserInfoMapper{
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
