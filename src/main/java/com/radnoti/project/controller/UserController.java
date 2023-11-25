package com.radnoti.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @PostMapping(path = "/test")
    public void adduser() {
        System.out.println("HELLOOOOO");

    }

}
