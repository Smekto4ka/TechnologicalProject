package ru.oogis.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.dto.CommunicationGroupInfo;
import ru.oogis.dto.UserDto;
import ru.oogis.dto.UserInfo;
import ru.oogis.entity.CommunicationGroup;
import ru.oogis.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-25T14:40:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CommunicationMapper communicationMapper;

    @Override
    public UserInfo userToUserInfo(User user) {
        if ( user == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setId( user.getId() );
        userInfo.setNick( user.getNick() );

        return userInfo;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNick( user.getNick() );
        userDto.setLastName( user.getLastName() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setAge( user.getAge() );
        userDto.setGroups( communicationGroupListToCommunicationGroupInfoList( user.getGroups() ) );

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setNick( userDto.getNick() );
        user.setLastName( userDto.getLastName() );
        user.setFirstName( userDto.getFirstName() );
        user.setAge( userDto.getAge() );
        user.setGroups( communicationGroupInfoListToCommunicationGroupList( userDto.getGroups() ) );

        return user;
    }

    protected List<CommunicationGroupInfo> communicationGroupListToCommunicationGroupInfoList(List<CommunicationGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<CommunicationGroupInfo> list1 = new ArrayList<CommunicationGroupInfo>( list.size() );
        for ( CommunicationGroup communicationGroup : list ) {
            list1.add( communicationMapper.communicationToInfo( communicationGroup ) );
        }

        return list1;
    }

    protected CommunicationGroup communicationGroupInfoToCommunicationGroup(CommunicationGroupInfo communicationGroupInfo) {
        if ( communicationGroupInfo == null ) {
            return null;
        }

        CommunicationGroup communicationGroup = new CommunicationGroup();

        communicationGroup.setId( communicationGroupInfo.getId() );
        communicationGroup.setName( communicationGroupInfo.getName() );
        communicationGroup.setGroupType( communicationGroupInfo.getGroupType() );

        return communicationGroup;
    }

    protected List<CommunicationGroup> communicationGroupInfoListToCommunicationGroupList(List<CommunicationGroupInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<CommunicationGroup> list1 = new ArrayList<CommunicationGroup>( list.size() );
        for ( CommunicationGroupInfo communicationGroupInfo : list ) {
            list1.add( communicationGroupInfoToCommunicationGroup( communicationGroupInfo ) );
        }

        return list1;
    }
}
