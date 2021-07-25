package ru.oogis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.oogis.service.ShowGroupService;
import ru.oogis.transfer.Marker;
import ru.oogis.transfer.ShowGroup;
import ru.oogis.transfer.ShowMessage;
import ru.oogis.transfer.ShowUserInfo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/group")
public class CommunicationController {

    private final ShowGroupService groupService;

    public CommunicationController(ShowGroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/{id}")
    @Validated(Marker.OnCreate.class)
    public ResponseEntity createGroup(@PathVariable @Min(value = 1) Long id,
                                      @Valid @RequestBody ShowGroup group) {
        return ResponseEntity.ok(groupService.createGroup(id, group));
    }

    @PutMapping("/send/{groupId}")
    public ResponseEntity sendMessage(@PathVariable @Min(1) Long groupId,
                                      @Valid @RequestBody ShowMessage message) {
        groupService.sendMessage(groupId, message);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/users/add/{groupId}")
    public ResponseEntity addUsers(@PathVariable @Min(1) Long groupId,
                                   @RequestBody @NotEmpty List<Long> users) {
        groupService.addUsers(groupId, users);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/users/delete/{groupId}")
    public ResponseEntity deleteUsers(@PathVariable @Min(1) Long groupId,
                                      @RequestBody @NotEmpty List<Long> users) {
        groupService.deleteUsers(groupId, users);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/user/delete/{groupId}/{id}")
    public ResponseEntity removeMeFromTheGroup(@PathVariable @Min(1) Long groupId,
                                               @PathVariable @Min(1) Long id) {
        groupService.removeMeFromTheGroup(groupId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/rename/{groupId}/{name}")
    public ResponseEntity renameGroup(@PathVariable @Min(1) Long groupId,
                                      @PathVariable @Size(min = 1) String name) {
        groupService.renameGroup(groupId, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowGroup> getGroupById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }
}
