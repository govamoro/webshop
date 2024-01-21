package com.radnoti.project.service;

import com.radnoti.project.enums.RoleEnum;
import com.radnoti.project.mapper.UserMapper;
import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.model.entity.Role;
import com.radnoti.project.model.entity.User;
import com.radnoti.project.repository.UserRepository;
import com.radnoti.project.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    //@Autowired - injektálás!!!4!
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final HashUtil hashUtil;

    public Long registration(UserDto userDto) throws NoSuchAlgorithmException {
        if (userDto.getUserName() == null || userDto.getUserName().isBlank()
            || userDto.getEmail() == null || userDto.getEmail().isBlank()
            || userDto.getPassword() == null || userDto.getPassword().isBlank()
            /*|| userDto.getFirstName() == null || userDto.getFirstName().isBlank()
            || userDto.getLastName() == null || userDto.getLastName().isBlank()*/){
            throw new RuntimeException("hibások az adatok");
        }
        if (userRepository.findByUsername(userDto.getUserName()).isPresent()){
            throw new RuntimeException("van már ilyen username");
        }
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("van már ilyen email");
        }

        ZonedDateTime now = ZonedDateTime.now();
        User user = userMapper.fromDtoToEntity(userDto);
        user.setPassword(hashUtil.getSHA256Hash(userDto.getPassword()));
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

    public void login(UserDto userDto) throws NoSuchAlgorithmException {
        if (userDto.getUserName() == null || userDto.getUserName().isBlank()
                || userDto.getPassword() == null || userDto.getPassword().isBlank()){
            throw new RuntimeException("hibások az adatok");
        }
        Optional<User> byUsername = userRepository.findByUsername(userDto.getUserName());
        if (byUsername.isEmpty()){
            throw new RuntimeException("nincs ilyen user");
        }
        if (!byUsername.get().getPassword().equals(hashUtil.getSHA256Hash(userDto.getPassword()))){
            throw new RuntimeException("rossz jelszó");
        }
    }
}

/* Írjak egy mappert, ami a userből csinál userDto-t és fordítva

* */