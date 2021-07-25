package ru.oogis.mapping;

import ru.oogis.dto.CommunicationGroupDto;
import ru.oogis.dto.CommunicationGroupInfo;
import ru.oogis.dto.UserInfo;
import ru.oogis.entity.CommunicationGroup;
import ru.oogis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, MessageMapper.class})
public interface CommunicationMapper {

    CommunicationGroupDto communicationToDto(CommunicationGroup group);

    CommunicationGroupInfo communicationToInfo(CommunicationGroup group);

    @Mapping(target = "users", source = "users")
    CommunicationGroup communicationDtoToEntity(CommunicationGroupDto groupDto);


    default List<User> map(List<UserInfo> value) {
        return Collections.emptyList();
    }
}
