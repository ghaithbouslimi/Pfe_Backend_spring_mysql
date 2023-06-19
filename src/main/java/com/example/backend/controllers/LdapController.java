package com.example.backend.controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class LdapController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}



