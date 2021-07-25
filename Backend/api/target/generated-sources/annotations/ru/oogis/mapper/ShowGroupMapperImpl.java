package ru.oogis.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.data.GroupType;
import ru.oogis.dto.CommunicationGroupDto;
import ru.oogis.dto.CommunicationGroupInfo;
import ru.oogis.dto.MessageDto;
import ru.oogis.dto.UserInfo;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowGroupInfo;
import ru.oogis.transfer.ShowGroupType;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.transfer.ShowUserInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-25T17:52:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ShowGroupMapperImpl implements ShowGroupMapper {

    @Autowired
    private ShowMessageMapper showMessageMapper;
    @Autowired
    private ShowUserMapper showUserMapper;

    @Override
    public ShowGroupInfo communicationGroupInfoToShowGroupInfo(CommunicationGroupInfo communicationGroupInfo) {
        if ( communicationGroupInfo == null ) {
            return null;
        }

        ShowGroupInfo showGroupInfo = new ShowGroupInfo();

        showGroupInfo.setId( communicationGroupInfo.getId() );
        showGroupInfo.setName( communicationGroupInfo.getName() );
        showGroupInfo.setGroupType( groupTypeToShowGroupType( communicationGroupInfo.getGroupType() ) );

        return showGroupInfo;
    }

    @Override
    public CommunicationGroupInfo showGroupInfoToCommunicationGroupInfo(ShowGroupInfo showGroupInfo) {
        if ( showGroupInfo == null ) {
            return null;
        }

        CommunicationGroupInfo communicationGroupInfo = new CommunicationGroupInfo();

        communicationGroupInfo.setId( showGroupInfo.getId() );
        communicationGroupInfo.setName( showGroupInfo.getName() );
        communicationGroupInfo.setGroupType( showGroupTypeToGroupType( showGroupInfo.getGroupType() ) );

        return communicationGroupInfo;
    }

    @Override
    public ShowGroup communicationGroupDtoToShowGroup(CommunicationGroupDto communicationGroupDto) {
        if ( communicationGroupDto == null ) {
            return null;
        }

        ShowGroup showGroup = new ShowGroup();

        showGroup.setId( communicationGroupDto.getId() );
        showGroup.setUsers( userInfoListToShowUserInfoList( communicationGroupDto.getUsers() ) );
        showGroup.setName( communicationGroupDto.getName() );
        showGroup.setMessages( messageDtoListToShowMessageList( communicationGroupDto.getMessages() ) );
        showGroup.setGroupType( groupTypeToShowGroupType( communicationGroupDto.getGroupType() ) );

        return showGroup;
    }

    @Override
    public CommunicationGroupDto showGroupToCommunicationGroupDto(ShowGroup showGroup) {
        if ( showGroup == null ) {
            return null;
        }

        CommunicationGroupDto communicationGroupDto = new CommunicationGroupDto();

        communicationGroupDto.setId( showGroup.getId() );
        communicationGroupDto.setUsers( showUserInfoListToUserInfoList( showGroup.getUsers() ) );
        communicationGroupDto.setName( showGroup.getName() );
        communicationGroupDto.setMessages( showMessageListToMessageDtoList( showGroup.getMessages() ) );
        communicationGroupDto.setGroupType( showGroupTypeToGroupType( showGroup.getGroupType() ) );

        return communicationGroupDto;
    }

    protected ShowGroupType groupTypeToShowGroupType(GroupType groupType) {
        if ( groupType == null ) {
            return null;
        }

        ShowGroupType showGroupType;

        switch ( groupType ) {
            case GROUP: showGroupType = ShowGroupType.GROUP;
            break;
            case PERSONAL: showGroupType = ShowGroupType.PERSONAL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + groupType );
        }

        return showGroupType;
    }

    protected GroupType showGroupTypeToGroupType(ShowGroupType showGroupType) {
        if ( showGroupType == null ) {
            return null;
        }

        GroupType groupType;

        switch ( showGroupType ) {
            case GROUP: groupType = GroupType.GROUP;
            break;
            case PERSONAL: groupType = GroupType.PERSONAL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + showGroupType );
        }

        return groupType;
    }

    protected List<ShowUserInfo> userInfoListToShowUserInfoList(List<UserInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<ShowUserInfo> list1 = new ArrayList<ShowUserInfo>( list.size() );
        for ( UserInfo userInfo : list ) {
            list1.add( showUserMapper.userInfoToShowUserInfo( userInfo ) );
        }

        return list1;
    }

    protected List<ShowMessage> messageDtoListToShowMessageList(List<MessageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ShowMessage> list1 = new ArrayList<ShowMessage>( list.size() );
        for ( MessageDto messageDto : list ) {
            list1.add( showMessageMapper.messageDtoToShowMessage( messageDto ) );
        }

        return list1;
    }

    protected List<UserInfo> showUserInfoListToUserInfoList(List<ShowUserInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<UserInfo> list1 = new ArrayList<UserInfo>( list.size() );
        for ( ShowUserInfo showUserInfo : list ) {
            list1.add( showUserMapper.showUserInfoToUserInfo( showUserInfo ) );
        }

        return list1;
    }

    protected List<MessageDto> showMessageListToMessageDtoList(List<ShowMessage> list) {
        if ( list == null ) {
            return null;
        }

        List<MessageDto> list1 = new ArrayList<MessageDto>( list.size() );
        for ( ShowMessage showMessage : list ) {
            list1.add( showMessageMapper.showMessageToMessageDto( showMessage ) );
        }

        return list1;
    }
}
