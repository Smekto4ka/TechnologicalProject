package ru.oogis.service;

import ru.oogis.dto.UserInfo;
import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import java.util.Optional;

public interface ShowAccountService {
    ShowUser createUser(ShowUser user , ShowSecurity security);

    Optional<ShowUserInfo> checkUserByNick(String nick);
}
