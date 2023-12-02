package com.radnoti.project.service;

import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.model.entity.User;
import com.radnoti.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    //@Autowired - injektálás!!!4!
    private final UserRepository userRepository;
    public Long registration(UserDto userDto){
        System.out.println(userDto);
        /*User user = new User();
        user.setEmail(userDto.getEmail());
        userRepository.save(user);*/
        return 1L;
    }

}

/* Írjak egy mappert, ami a userből csinál userDto-t és fordítva

* */