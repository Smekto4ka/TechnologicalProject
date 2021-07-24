package ru.oogis.service;

import data.dto.SecurityDto;
import data.dto.UserDto;
import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;

public interface ShowAccountService {
    ShowUser createUser(ShowUser user , ShowSecurity security);
}
