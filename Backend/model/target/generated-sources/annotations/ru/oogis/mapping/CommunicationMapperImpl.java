package ru.oogis.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.oogis.dto.CommunicationGroupDto;
import ru.oogis.dto.CommunicationGroupInfo;
import ru.oogis.dto.MessageDto;
import ru.oogis.dto.UserInfo;
import ru.oogis.entity.CommunicationGroup;
import ru.oogis.entity.Message;
import ru.oogis.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-25T14:40:49+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class CommunicationMapperImpl implements CommunicationMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public CommunicationGroupDto communicationToDto(CommunicationGroup group) {
        if ( group == null ) {
            return null;
        }

        CommunicationGroupDto communicationGroupDto = new CommunicationGroupDto();

        communicationGroupDto.setId( group.getId() );
        communicationGroupDto.setUsers( userListToUserInfoList( group.getUsers() ) );
        communicationGroupDto.setName( group.getName() );
        communicationGroupDto.setMessages( messageListToMessageDtoList( group.getMessages() ) );
        communicationGroupDto.setGroupType( group.getGroupType() );

        return communicationGroupDto;
    }

    @Override
    public CommunicationGroupInfo communicationToInfo(CommunicationGroup group) {
        if ( group == null ) {
            return null;
        }

        CommunicationGroupInfo communicationGroupInfo = new CommunicationGroupInfo();

        communicationGroupInfo.setId( group.getId() );
        communicationGroupInfo.setName( group.getName() );
        communicationGroupInfo.setGroupType( group.getGroupType() );

        return communicationGroupInfo;
    }

    @Override
    public CommunicationGroup communicationDtoToEntity(CommunicationGroupDto groupDto) {
        if ( groupDto == null ) {
            return null;
        }

        CommunicationGroup communicationGroup = new CommunicationGroup();

        communicationGroup.setUsers( map( groupDto.getUsers() ) );
        communicationGroup.setId( groupDto.getId() );
        communicationGroup.setName( groupDto.getName() );
        communicationGroup.setMessages( messageDtoListToMessageList( groupDto.getMessages() ) );
        communicationGroup.setGroupType( groupDto.getGroupType() );

        return communicationGroup;
    }

    protected List<UserInfo> userListToUserInfoList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserInfo> list1 = new ArrayList<UserInfo>( list.size() );
        for ( User user : list ) {
            list1.add( userMapper.userToUserInfo( user ) );
        }

        return list1;
    }

    protected List<MessageDto> messageListToMessageDtoList(List<Message> list) {
        if ( list == null ) {
            return null;
        }

        List<MessageDto> list1 = new ArrayList<MessageDto>( list.size() );
        for ( Message message : list ) {
            list1.add( messageMapper.messageToMessageInfo( message ) );
        }

        return list1;
    }

    protected User userInfoToUser(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        User user = new User();

        user.setId( userInfo.getId() );
        user.setNick( userInfo.getNick() );

        return user;
    }

    protected Message messageDtoToMessage(MessageDto messageDto) {
        if ( messageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setSender( userInfoToUser( messageDto.getSender() ) );
        message.setMessage( messageDto.getMessage() );

        return message;
    }

    protected List<Message> messageDtoListToMessageList(List<MessageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Message> list1 = new ArrayList<Message>( list.size() );
        for ( MessageDto messageDto : list ) {
            list1.add( messageDtoToMessage( messageDto ) );
        }

        return list1;
    }
}
