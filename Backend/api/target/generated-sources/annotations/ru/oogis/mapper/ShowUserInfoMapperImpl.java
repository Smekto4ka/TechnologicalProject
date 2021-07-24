package ru.oogis.mapper;

import data.dto.UserInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.oogis.transfer.ShowUserInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T19:55:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ShowUserInfoMapperImpl implements ShowUserInfoMapper {

    @Override
    public ShowUserInfo userInfoToShowUserInfo(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        ShowUserInfo showUserInfo = new ShowUserInfo();

        showUserInfo.setId( userInfo.getId() );
        showUserInfo.setNick( userInfo.getNick() );

        return showUserInfo;
    }

    @Override
    public UserInfo showUserInfoToUserInfo(ShowUserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        UserInfo userInfo1 = new UserInfo();

        userInfo1.setId( userInfo.getId() );
        userInfo1.setNick( userInfo.getNick() );

        return userInfo1;
    }
}
