package ru.oogis.service.impl;

import org.springframework.stereotype.Service;
import ru.oogis.mapper.ShowSecurityMapper;
import ru.oogis.mapper.ShowUserMapper;
import ru.oogis.service.ShowAccountService;
import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;
import service.AccService;


@Service
public class ShowAccountServiceImpl implements ShowAccountService {

    private final AccService accountService;
    private final ShowSecurityMapper securityMapper;
    private final ShowUserMapper userMapper;

    public ShowAccountServiceImpl(AccService accountService, ShowSecurityMapper securityMapper, ShowUserMapper userMapper) {
        this.accountService = accountService;
        this.securityMapper = securityMapper;
        this.userMapper = userMapper;
    }


    @Override
    public ShowUser createUser(ShowUser user, ShowSecurity security) {
        return userMapper.userDtoToShowUser(
                accountService.createUser(userMapper.showUserToUserDto(user),
                        securityMapper.showSecurityToSecurityDto(security))
        );
    }
}
