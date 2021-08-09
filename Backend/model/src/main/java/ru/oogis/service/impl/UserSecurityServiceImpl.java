package ru.oogis.service.impl;

import ru.oogis.dto.SecurityDto;
import ru.oogis.dto.UserDto;
import ru.oogis.entity.User;
import ru.oogis.mapping.SecurityDtoMapper;
import ru.oogis.mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oogis.repository.UserRepository;
import ru.oogis.service.UserSecurityService;

import java.util.Optional;

@Service
@Transactional
public class UserSecurityServiceImpl implements UserSecurityService {

    private final UserMapper userMapper;
    private final SecurityDtoMapper securityDtoMapper;
    private final UserRepository userRepository;


    //TODO 1 login and password for 1 person

    public UserSecurityServiceImpl(UserMapper userMapper, SecurityDtoMapper securityDtoMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.securityDtoMapper = securityDtoMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto, SecurityDto securityDto) {
        User user = userMapper.userDtoToUser(userDto);
        user.setSecurityData(securityDtoMapper.securityDtoToEntity(securityDto));
        return userMapper.userToUserDto(userRepository.save(user));
    }

    public Optional<UserDto> checkUserByNick(String nick){
        return userRepository.findByNick(nick).map(userMapper::userToUserDto);
    }
}
