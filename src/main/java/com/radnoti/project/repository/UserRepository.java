package com.radnoti.project.repository;

import com.radnoti.project.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("Select u from User u where u.userName = :username")
    Optional<User> findByUsername(String username);
}
