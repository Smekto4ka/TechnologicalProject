package ru.oogis.mapper;

import data.dto.CommunicationGroupDto;
import data.dto.CommunicationGroupInfo;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowGroupInfo;

@Mapper(componentModel = "spring" )
public interface ShowGroupMapper {
    ShowGroupInfo communicationGroupInfoToShowGroupInfo(CommunicationGroupInfo communicationGroupInfo);
    CommunicationGroupInfo showGroupInfoToCommunicationGroupInfo(ShowGroupInfo showGroupInfo);

    ShowGroup communicationGroupDtoToShowGroup(CommunicationGroupDto communicationGroupDto);
    CommunicationGroupDto showGroupToCommunicationGroupDto(ShowGroup showGroup);

}
