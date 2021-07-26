package ru.oogis.service;

import ru.oogis.dto.SecurityDto;
import ru.oogis.dto.UserDto;

import java.util.Optional;

public interface UserSecurityService {
    UserDto createUser(UserDto userDto, SecurityDto securityDto);

    Optional<UserDto> checkUserByNick(String nick);
}
