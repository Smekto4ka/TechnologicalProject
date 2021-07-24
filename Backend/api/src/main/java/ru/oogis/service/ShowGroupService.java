package ru.oogis.service;

import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.transfer.ShowUserInfo;

import java.util.List;

public interface ShowGroupService {

    ShowGroup createGroup(Long id, ShowGroup showGroup);

    void sendMessage(Long groupId , ShowMessage message);

    void addUsers( Long groupId,  List<Long> users) ;

    void deleteUsers( Long groupId,  List<Long> users) ;

    void removeMeFromTheGroup( Long groupId,  Long id);

    void renameGroup( Long groupId,  String name);

    ShowGroup getGroupById( Long id);
}
