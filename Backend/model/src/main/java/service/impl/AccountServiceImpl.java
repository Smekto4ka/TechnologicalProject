package service.impl;

import data.dto.SecurityDto;
import data.dto.UserDto;
import entity.User;
import mapping.SecurityMapper;
import mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import service.AccService;

@Service
@Transactional
public class AccountServiceImpl implements AccService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final SecurityMapper securityMapper;

    public AccountServiceImpl(UserMapper userMapper, UserRepository userRepository, SecurityMapper securityMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.securityMapper = securityMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto, SecurityDto securityDto) {
        User user = userMapper.userDtoToUser(userDto);
        user.setSecurityData(securityMapper.securityDtoToEntity(securityDto));
        return userMapper.userToUserDto(userRepository.save(user));
    }
}
