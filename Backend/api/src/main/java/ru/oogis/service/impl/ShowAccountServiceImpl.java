package ru.oogis.service.impl;

import org.springframework.stereotype.Service;
import ru.oogis.dto.UserDto;
import ru.oogis.dto.UserInfo;
import ru.oogis.mapper.ShowSecurityMapper;
import ru.oogis.mapper.ShowUserMapper;
import ru.oogis.service.ShowAccountService;
import ru.oogis.service.UserSecurityService;
import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import java.util.Optional;


@Service
public class ShowAccountServiceImpl implements ShowAccountService {

    private final UserSecurityService userSecurityService;
    private final ShowSecurityMapper securityMapper;
    private final ShowUserMapper userMapper;

    public ShowAccountServiceImpl(UserSecurityService userSecurityService, ShowSecurityMapper securityMapper, ShowUserMapper userMapper) {
        this.userSecurityService = userSecurityService;


        this.securityMapper = securityMapper;
        this.userMapper = userMapper;
    }


    @Override
    public ShowUser createUser(ShowUser user, ShowSecurity security) {
        return userMapper.userDtoToShowUser(
                userSecurityService.createUser(userMapper.showUserToUserDto(user),
                        securityMapper.showSecurityToSecurityDto(security))
        );
    }

    @Override
    public Optional<ShowUserInfo> checkUserByNick(String nick) {
        return userSecurityService.checkUserByNick(nick).map(userMapper::userDtoToShowUserInfo);
    }
}
