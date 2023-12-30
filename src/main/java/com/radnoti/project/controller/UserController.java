package com.radnoti.project.controller;

import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    /*@PostMapping(path = "/test")
    public String adduser() {
        return "HELLOOOOO";

    }*/

    @PostMapping(path = "/registration")
    public Long registration(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        return userService.registration(userDto);
    }

    @PostMapping(path = "/login")
    public void login(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        userService.login(userDto);
    }
}
