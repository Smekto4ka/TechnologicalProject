package ru.oogis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.oogis.service.ShowAccountService;
import ru.oogis.transfer.Marker;
import ru.oogis.transfer.ShowSecurity;
import ru.oogis.transfer.ShowUser;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Validated
@RequestMapping("/api/account")
public class AccountController {

    private final ShowAccountService showAccountService;

    public AccountController(ShowAccountService showAccountService) {
        this.showAccountService = showAccountService;
    }

    //TODO 1 login and password for 1 person
    @PostMapping
    @Validated(Marker.OnCreate.class)
    public ResponseEntity createUser(@Valid @RequestBody ShowUser user, @Valid @RequestBody ShowSecurity security) {
        return ResponseEntity.ok(showAccountService.createUser(user, security));
    }
}
