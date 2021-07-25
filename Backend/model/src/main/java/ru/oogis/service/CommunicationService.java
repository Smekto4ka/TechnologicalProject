package ru.oogis.service;

import ru.oogis.dto.*;

import java.util.List;
import java.util.Optional;

public interface CommunicationService {

    CommunicationGroupDto createCommunication(CommunicationGroupDto communicationDto);

    CommunicationGroupDto addUsers(Long groupId, List<Long> users);

    Optional<CommunicationGroupDto> deleteUsers(Long groupId, List<Long> users);

    CommunicationGroupDto updateGroup(CommunicationGroupInfo info);

    CommunicationGroupDto getGroupById(Long id);

    CommunicationGroupDto addMessage (Long groupId , MessageDto message);
}
