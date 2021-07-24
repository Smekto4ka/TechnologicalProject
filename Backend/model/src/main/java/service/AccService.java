package service;

import data.dto.SecurityDto;
import data.dto.UserDto;

public interface AccService {
    UserDto createUser(UserDto userDto, SecurityDto securityDto);
}
