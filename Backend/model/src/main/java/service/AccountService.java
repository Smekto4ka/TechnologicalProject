package service;

import data.dto.SecurityDto;
import data.dto.UserDto;

public interface AccountService {

    UserDto createUser(UserDto userDto, SecurityDto securityDto);
}
