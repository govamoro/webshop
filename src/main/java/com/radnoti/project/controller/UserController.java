package com.radnoti.project.controller;

import com.radnoti.project.configurations.JwtConfig;
import com.radnoti.project.enums.RoleEnum;
import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.model.entity.Role;
import com.radnoti.project.model.entity.User;
import com.radnoti.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final JwtConfig jwtConfig;
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

    @GetMapping(path = "/jwttest")
    public void test(){
        User user = new User();
        Role role = new Role();
        role.setType(RoleEnum.USER.getType());

        user.setId(50);
        user.setRole(role);
        user.setEmail("valami@valami");
        user.setUserName("valami50");
        user.setFirstName("BoB");
        user.setLastName("BAB");
        String jwt = jwtConfig.generateJwt(user);
        System.out.println(jwt);
        System.out.println(jwtConfig.validateJwt(jwt));
    }

}
