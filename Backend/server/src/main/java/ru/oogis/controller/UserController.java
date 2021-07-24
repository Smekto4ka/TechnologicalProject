package ru.oogis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.oogis.service.ShowUserService;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class UserController {

    private final ShowUserService showUserService;

    public UserController(ShowUserService showUserService) {
        this.showUserService = showUserService;
    }

    @PutMapping
    public ResponseEntity<ShowUser> updateUser(@RequestBody ShowUser user) {
        return ResponseEntity.ok(showUserService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShowUser> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(showUserService.deleteUser(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowUserInfo>> allUsers() {
        return ResponseEntity.ok(showUserService.allUser());
    }

/*    @GetMapping("/info/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){

    }*/

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        return ResponseEntity.ok(showUserService.getUserById(id));
    }

}
