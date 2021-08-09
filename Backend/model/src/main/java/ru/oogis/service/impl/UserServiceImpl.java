package ru.oogis.service.impl;

import ru.oogis.dto.UserDto;
import ru.oogis.entity.User;
import ru.oogis.mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oogis.repository.UserRepository;
import ru.oogis.service.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }



    @Override
    public UserDto getUserById(Long id) {
        //TODO exception
        return userRepository.findById(id).map(userMapper::userToUserDto).orElseThrow();
    }

    @Override
    public Collection<UserDto> allUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userMapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        //TODO exception
        User oldUser = userRepository.findById(userDto.getId()).orElseThrow();
        oldUser.setAge(userDto.getAge());
        oldUser.setLastName(userDto.getLastName());
        oldUser.setFirstName(userDto.getFirstName());
        oldUser.setNick(userDto.getNick());
        return userMapper.userToUserDto(oldUser);
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return userMapper.userToUserDto(user);
    }

    @Override
    public Optional<UserDto> userByNick(String nick) {
        return userRepository.findByNick(nick).map(userMapper::userToUserDto);
    }
}
