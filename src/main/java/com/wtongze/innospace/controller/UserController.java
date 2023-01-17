package com.wtongze.innospace.controller;

import com.wtongze.innospace.model.InnoSpaceUserDetails;
import com.wtongze.innospace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("postTest")
    public String postTest(@RequestBody String a) {
        return a;
    }

    @GetMapping("/test")
    @Secured("ROLE_USER")
    public String getTest() {
        return "test-private";
    }

    @GetMapping("/user")
    @Secured("ROLE_USER")
    public InnoSpaceUserDetails get(Authentication p) {
        InnoSpaceUserDetails d = (InnoSpaceUserDetails) p.getPrincipal();
        return d;
    }
}
