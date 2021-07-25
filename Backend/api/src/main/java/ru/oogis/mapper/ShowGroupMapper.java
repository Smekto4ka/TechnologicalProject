package ru.oogis.mapper;

import ru.oogis.dto.CommunicationGroupDto;
import ru.oogis.dto.CommunicationGroupInfo;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowGroupInfo;

@Mapper(componentModel = "spring", uses = {ShowMessageMapper.class , ShowUserMapper.class})
public interface ShowGroupMapper {
    ShowGroupInfo communicationGroupInfoToShowGroupInfo(CommunicationGroupInfo communicationGroupInfo);
    CommunicationGroupInfo showGroupInfoToCommunicationGroupInfo(ShowGroupInfo showGroupInfo);

    ShowGroup communicationGroupDtoToShowGroup(CommunicationGroupDto communicationGroupDto);
    CommunicationGroupDto showGroupToCommunicationGroupDto(ShowGroup showGroup);

}
