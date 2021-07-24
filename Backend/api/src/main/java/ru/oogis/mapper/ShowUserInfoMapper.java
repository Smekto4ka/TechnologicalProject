package ru.oogis.mapper;

import data.dto.UserInfo;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowUserInfo;

@Mapper(componentModel = "spring")
public interface ShowUserInfoMapper {
    ShowUserInfo userInfoToShowUserInfo(UserInfo userInfo);

    UserInfo showUserInfoToUserInfo(ShowUserInfo userInfo);
}
