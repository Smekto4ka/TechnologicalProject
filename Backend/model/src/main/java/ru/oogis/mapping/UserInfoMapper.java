package ru.oogis.mapping;

import ru.oogis.dto.UserInfo;
import ru.oogis.entity.User;

//@Mapper(componentModel = "spring" )
public interface UserInfoMapper {
    UserInfo userToUserInfo(User user);
}
