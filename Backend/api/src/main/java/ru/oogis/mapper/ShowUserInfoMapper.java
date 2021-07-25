package ru.oogis.mapper;

import ru.oogis.dto.UserInfo;
import ru.oogis.transfer.ShowUserInfo;


//@Primary
//@Mapper(componentModel = "spring")
public interface ShowUserInfoMapper {
    ShowUserInfo userInfoToShowUserInfo(UserInfo userInfo);

    UserInfo showUserInfoToUserInfo(ShowUserInfo userInfo);
}
