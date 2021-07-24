package mapping;

import data.dto.UserInfo;
import entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface UserInfoMapper {
    UserInfo userToUserInfo(User user);
}
