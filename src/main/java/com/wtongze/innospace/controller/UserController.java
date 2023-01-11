package com.wtongze.innospace.controller;

import com.wtongze.innospace.entity.User;
import com.wtongze.innospace.model.InnoSpaceUserDetails;
import com.wtongze.innospace.model.Test;
import com.wtongze.innospace.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public Test post(@RequestBody Test t) {
        System.out.println(t);
        return t;
    }

    @GetMapping("/user")
//    @Secured("ROLE_USER")
    public InnoSpaceUserDetails get(Authentication p) {
        InnoSpaceUserDetails d = (InnoSpaceUserDetails) p.getPrincipal();
        return d;
    }
}
