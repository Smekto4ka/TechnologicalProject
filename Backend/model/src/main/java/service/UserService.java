package service;

import data.dto.UserDto;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

   UserDto getUserById(Long id);

   Collection<UserDto> allUsers();

   UserDto updateUser(UserDto userDto);

   UserDto deleteUser(Long id);


}
