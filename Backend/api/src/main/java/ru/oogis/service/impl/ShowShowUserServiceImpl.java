package ru.oogis.service.impl;

import org.springframework.stereotype.Service;
import ru.oogis.mapper.ShowUserMapper;
import ru.oogis.service.ShowUserService;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;
import service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowShowUserServiceImpl implements ShowUserService {

    private final UserService userService;
    private final ShowUserMapper userMapper;

    public ShowShowUserServiceImpl(UserService userService, ShowUserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public ShowUser updateUser(ShowUser user) {
        return userMapper.userDtoToShowUser(
                userService.updateUser(
                        userMapper.showUserToUserDto(user)
                ));
    }

    @Override
    public ShowUser deleteUser(Long id) {
        return userMapper.userDtoToShowUser(
                userService.deleteUser(id)
        );
    }

    @Override
    public List<ShowUserInfo> allUser() {
        return userService.allUsers().stream().map(userMapper::userDtoToShowUserInfo).collect(Collectors.toList());
    }

    @Override
    public ShowUser getUserById(Long id) {
        return userMapper.userDtoToShowUser(userService.getUserById(id));
    }
}
