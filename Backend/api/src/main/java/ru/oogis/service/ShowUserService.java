package ru.oogis.service;

import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import java.util.List;

public interface ShowUserService {
   ShowUser updateUser (ShowUser user);
   ShowUser deleteUser (Long id);
   List<ShowUserInfo> allUser();
   ShowUser getUserById(Long id);
}
