package ru.oogis.service;

import ru.oogis.dto.SecurityDto;
import ru.oogis.dto.UserDto;

public interface UserSecurityService {
    UserDto createUser(UserDto userDto, SecurityDto securityDto);
}
