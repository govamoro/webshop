package com.radnoti.project.repository;

import com.radnoti.project.model.dto.ArtDto;
import com.radnoti.project.model.entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends CrudRepository<Art, Integer> {

}
