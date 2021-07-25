package ru.oogis.service.impl;

import ru.oogis.dto.SecurityDto;
import ru.oogis.dto.UserDto;
import ru.oogis.entity.User;
import ru.oogis.mapping.SecurityMapper;
import ru.oogis.mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oogis.repository.UserRepository;
import ru.oogis.service.UserSecurityService;

@Service
@Transactional
public class UserSecurityServiceImpl implements UserSecurityService {

    private final UserMapper userMapper;
    private final SecurityMapper securityMapper;
    private final UserRepository userRepository;

    public UserSecurityServiceImpl(UserMapper userMapper, SecurityMapper securityMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.securityMapper = securityMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto, SecurityDto securityDto) {
        User user = userMapper.userDtoToUser(userDto);
        user.setSecurityData(securityMapper.securityDtoToEntity(securityDto));
        return userMapper.userToUserDto(userRepository.save(user));
    }
}
