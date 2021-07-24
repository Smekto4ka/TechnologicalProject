package mapping;

import data.dto.CommunicationGroupDto;
import data.dto.CommunicationGroupInfo;
import data.dto.UserInfo;
import entity.CommunicationGroup;
import entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserInfoMapper.class, MessageMapper.class})
public interface CommunicationMapper {

    CommunicationGroupDto communicationToDto(CommunicationGroup group);

    CommunicationGroupInfo communicationToInfo(CommunicationGroup group);

    @Mapping(target = "users", source = "users")
    CommunicationGroup communicationDtoToEntity(CommunicationGroupDto groupDto);


    default List<User> map(List<UserInfo> value) {
        return Collections.emptyList();
    }
}
