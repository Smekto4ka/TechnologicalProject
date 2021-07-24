package service.impl;

import data.dto.CommunicationGroupDto;
import data.dto.CommunicationGroupInfo;
import data.dto.MessageDto;
import data.dto.UserInfo;
import entity.CommunicationGroup;
import entity.User;
import mapping.CommunicationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CommunicationRepository;
import repository.UserRepository;
import service.CommunicationService;
import service.MessageService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CommunicationServiceImpl implements CommunicationService {

    private final CommunicationRepository communicationRepository;
    private final CommunicationMapper communicationMapper;
    private final UserRepository userRepository;
    private final MessageService messageService;

    public CommunicationServiceImpl(CommunicationRepository communicationRepository, CommunicationMapper communicationMapper, UserRepository userRepository, MessageService messageService) {
        this.communicationRepository = communicationRepository;
        this.communicationMapper = communicationMapper;
        this.userRepository = userRepository;
        this.messageService = messageService;
    }

    @Override
    public CommunicationGroupDto createCommunication(CommunicationGroupDto communicationDto) {
        CommunicationGroup group = communicationMapper.communicationDtoToEntity(communicationDto);
        //TODO exception
        group.setUsers(communicationDto.getUsers().stream()
                .map(dto -> userRepository.findById(dto.getId()).orElseThrow()).collect(Collectors.toList()));
        return communicationMapper.communicationToDto(communicationRepository.save(group));
    }

    @Override
    public CommunicationGroupDto getGroupById(Long id) {
        return communicationMapper.communicationToDto(communicationRepository.findById(id).orElseThrow());
    }

    @Override
    public CommunicationGroupDto addUsers(Long groupId, List<Long> users) {
        CommunicationGroup group = communicationRepository.findById(groupId).orElseThrow();
        List<Long> oldUserId = group.getUsers().stream().map(User::getId).collect(Collectors.toList());
        List<User> newUser = StreamSupport.stream(
                userRepository.findAllById(
                        users.stream()
                                .filter(newId -> !oldUserId.contains(newId))
                                .collect(Collectors.toList()))
                        .spliterator(), false).collect(Collectors.toList());
        group.getUsers().addAll(newUser);
        return communicationMapper.communicationToDto(group);
    }

    @Override
    public Optional<CommunicationGroupDto> deleteUsers(Long groupId, List<Long> users) {
        CommunicationGroup group = communicationRepository.findById(groupId).orElseThrow();
        List<User> newUsers = group.getUsers()
                .stream().filter(user -> !users.contains(user.getId())).collect(Collectors.toList());
        group.setUsers(newUsers);
        if (newUsers.isEmpty()) {
            communicationRepository.deleteById(groupId);
            return Optional.empty();
        } else {
            return Optional.of(communicationMapper.communicationToDto(group));
        }
    }

    @Override
    public CommunicationGroupDto updateGroup(CommunicationGroupInfo info) {
        CommunicationGroup group = communicationRepository.findById(info.getId()).orElseThrow();
        group.setName(info.getName());
        return communicationMapper.communicationToDto(group);
    }


    @Override
    public CommunicationGroupDto addMessage(Long groupId, MessageDto message) {
        CommunicationGroup group = communicationRepository.findById(groupId).orElseThrow();
        group.getMessages().add(messageService.createMessage(message));
        return communicationMapper.communicationToDto(group);
    }
}
