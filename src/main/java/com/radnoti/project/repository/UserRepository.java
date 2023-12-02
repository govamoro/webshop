package com.radnoti.project.repository;

import com.radnoti.project.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
