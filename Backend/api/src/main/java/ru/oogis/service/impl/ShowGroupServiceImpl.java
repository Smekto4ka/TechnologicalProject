package ru.oogis.service.impl;

import ru.oogis.dto.CommunicationGroupInfo;
import org.springframework.stereotype.Service;
import ru.oogis.mapper.ShowGroupMapper;
import ru.oogis.mapper.ShowMessageMapper;
import ru.oogis.service.ShowGroupService;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.service.CommunicationService;

import java.util.Collections;
import java.util.List;

@Service
public class ShowGroupServiceImpl implements ShowGroupService {

    private final ShowGroupMapper showGroupMapper;
    private final CommunicationService communicationService;
    private final ShowMessageMapper messageMapper;


    public ShowGroupServiceImpl(ShowGroupMapper showGroupMapper, CommunicationService communicationService, ShowMessageMapper messageMapper) {
        this.showGroupMapper = showGroupMapper;
        this.communicationService = communicationService;
        this.messageMapper = messageMapper;
    }

    @Override
    public ShowGroup createGroup(Long id, ShowGroup showGroup) {
        return showGroupMapper.communicationGroupDtoToShowGroup(
                communicationService.createCommunication(
                        showGroupMapper.showGroupToCommunicationGroupDto(showGroup)));

    }

    @Override
    public void sendMessage(Long groupId, ShowMessage message) {
        communicationService.addMessage(groupId,
                messageMapper.showMessageToMessageDto(message));
    }

    @Override
    public void addUsers(Long groupId, List<Long> users) {
        communicationService.addUsers(groupId, users);
    }

    @Override
    public void deleteUsers(Long groupId, List<Long> users) {
        communicationService.deleteUsers(groupId, users);
    }

    @Override
    public void removeMeFromTheGroup(Long groupId, Long id) {
        communicationService.deleteUsers(groupId, Collections.singletonList(id));
    }

    @Override
    public void renameGroup(Long groupId, String name) {
        CommunicationGroupInfo groupInfo = new CommunicationGroupInfo();
        groupInfo.setId(groupId);
        groupInfo.setName(name);
        communicationService.updateGroup(groupInfo);
    }

    @Override
    public ShowGroup getGroupById(Long id) {
        return showGroupMapper.communicationGroupDtoToShowGroup(
                communicationService.getGroupById(id));
    }
}
