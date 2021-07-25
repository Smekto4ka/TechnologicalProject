package ru.oogis.service;

import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;

public interface ShowAccountService {
    ShowUser createUser(ShowUser user , ShowSecurity security);
}
