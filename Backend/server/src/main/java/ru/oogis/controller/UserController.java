package ru.oogis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.oogis.service.ShowUserService;
import ru.oogis.transfer.Marker;
import ru.oogis.transfer.ShowUser;
import ru.oogis.transfer.ShowUserInfo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/user")
public class UserController {

    private final ShowUserService showUserService;

    public UserController(ShowUserService showUserService) {
        this.showUserService = showUserService;
    }

    @PutMapping
    @Validated(Marker.OnUpdate.class)
    public ResponseEntity<ShowUser> updateUser(@Valid @RequestBody ShowUser user) {
        return ResponseEntity.ok(showUserService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShowUser> deleteUser(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(showUserService.deleteUser(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowUserInfo>> allUsers() {
        return ResponseEntity.ok(showUserService.allUser());
    }



    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable @Min(1) Long id){
        return ResponseEntity.ok(showUserService.getUserById(id));
    }

}
