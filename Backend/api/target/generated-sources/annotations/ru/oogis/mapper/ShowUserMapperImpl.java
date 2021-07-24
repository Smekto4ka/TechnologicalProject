package ru.oogis.mapper;

import data.dto.CommunicationGroupInfo;
import data.dto.UserDto;
import data.dto.UserInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.transfer.ShowGroupInfo;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T19:55:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ShowUserMapperImpl implements ShowUserMapper {

    @Autowired
    private ShowGroupMapper showGroupMapper;

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

    @Override
    public ShowUser userDtoToShowUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        ShowUser showUser = new ShowUser();

        showUser.setId( userDto.getId() );
        showUser.setNick( userDto.getNick() );
        showUser.setLastName( userDto.getLastName() );
        showUser.setFirstName( userDto.getFirstName() );
        showUser.setAge( userDto.getAge() );
        showUser.setGroups( communicationGroupInfoListToShowGroupInfoList( userDto.getGroups() ) );

        return showUser;
    }

    @Override
    public UserDto showUserToUserDto(ShowUser user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNick( user.getNick() );
        userDto.setLastName( user.getLastName() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setAge( user.getAge() );
        userDto.setGroups( showGroupInfoListToCommunicationGroupInfoList( user.getGroups() ) );

        return userDto;
    }

    @Override
    public ShowUserInfo userDtoToShowUserInfo(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        ShowUserInfo showUserInfo = new ShowUserInfo();

        showUserInfo.setId( userDto.getId() );
        showUserInfo.setNick( userDto.getNick() );

        return showUserInfo;
    }

    protected List<ShowGroupInfo> communicationGroupInfoListToShowGroupInfoList(List<CommunicationGroupInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<ShowGroupInfo> list1 = new ArrayList<ShowGroupInfo>( list.size() );
        for ( CommunicationGroupInfo communicationGroupInfo : list ) {
            list1.add( showGroupMapper.communicationGroupInfoToShowGroupInfo( communicationGroupInfo ) );
        }

        return list1;
    }

    protected List<CommunicationGroupInfo> showGroupInfoListToCommunicationGroupInfoList(List<ShowGroupInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<CommunicationGroupInfo> list1 = new ArrayList<CommunicationGroupInfo>( list.size() );
        for ( ShowGroupInfo showGroupInfo : list ) {
            list1.add( showGroupMapper.showGroupInfoToCommunicationGroupInfo( showGroupInfo ) );
        }

        return list1;
    }
}
