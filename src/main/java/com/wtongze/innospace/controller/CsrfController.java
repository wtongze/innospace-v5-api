package com.wtongze.innospace.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {
    @GetMapping("/csrf")
    @CrossOrigin(origins = "http://localhost:4200")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
