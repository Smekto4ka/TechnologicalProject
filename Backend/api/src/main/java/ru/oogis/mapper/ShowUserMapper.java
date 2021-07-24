package ru.oogis.mapper;

import data.dto.UserDto;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

@Mapper(componentModel = "spring")
public interface ShowUserMapper  extends ShowUserInfoMapper{
    ShowUser userDtoToShowUser(UserDto userDto);

    UserDto showUserToUserDto(ShowUser user);

    ShowUserInfo userDtoToShowUserInfo(UserDto userDto);
}
