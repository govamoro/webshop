package com.radnoti.project.controller;

import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Long registration(@RequestBody UserDto userDto){
        return userService.registration(userDto);
    }

}
