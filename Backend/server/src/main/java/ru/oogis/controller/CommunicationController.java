package ru.oogis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.oogis.service.ShowGroupService;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.transfer.ShowUserInfo;

import java.util.List;

@RestController
@CrossOrigin
@Validated

public class CommunicationController {

    private final ShowGroupService groupService;

    public CommunicationController(ShowGroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/{id}")
    public ResponseEntity createGroup(@PathVariable Long id, @RequestBody ShowGroup group) {
        return ResponseEntity.ok(groupService.createGroup(id, group));
    }

    @PutMapping("/send/{groupId}")
    public ResponseEntity sendMessage(@PathVariable Long groupId, @RequestBody ShowMessage message) {
        groupService.sendMessage(groupId, message);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/users/add/{groupId}")
    public ResponseEntity addUsers(@PathVariable Long groupId, @RequestBody List<Long> users) {
        groupService.addUsers(groupId, users);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/users/delete/{groupId}")
    public ResponseEntity deleteUsers(@PathVariable Long groupId, @RequestBody List<Long> users) {
        groupService.deleteUsers(groupId, users);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/user/delete/{groupId}/{id}")
    public ResponseEntity removeMeFromTheGroup(@PathVariable Long groupId, @PathVariable Long id) {
        groupService.removeMeFromTheGroup(groupId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/rename/{groupId}/{name}")
    public ResponseEntity renameGroup(@PathVariable Long groupId, @PathVariable String name) {
        groupService.renameGroup(groupId, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowGroup> getGroupById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }
}
