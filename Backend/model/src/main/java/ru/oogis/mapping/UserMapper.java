package ru.oogis.mapping;

import ru.oogis.dto.UserDto;
import ru.oogis.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CommunicationMapper.class})
public interface UserMapper extends UserInfoMapper{
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
