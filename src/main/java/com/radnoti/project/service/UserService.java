package com.radnoti.project.service;

import com.radnoti.project.enums.RoleEnum;
import com.radnoti.project.mapper.UserMapper;
import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.model.entity.Role;
import com.radnoti.project.model.entity.User;
import com.radnoti.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    //@Autowired - injektálás!!!4!
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long registration(UserDto userDto){
        ZonedDateTime now = ZonedDateTime.now();
        User user = userMapper.fromDtoToEntity(userDto);
        user.setRegisteredAt(now);
        user.setIsDeleted(false);
        user.setRole(new Role(RoleEnum.USER.getId()));
        System.out.println(user);
        userRepository.save(user);
        System.out.println(user);


        /*User user = new User();
        user.setEmail(userDto.getEmail());
        userRepository.save(user);*/



        return 1L;
    }

}

/* Írjak egy mappert, ami a userből csinál userDto-t és fordítva

* */