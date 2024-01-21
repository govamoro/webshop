package com.radnoti.project.mapper;

import com.radnoti.project.model.dto.ArtDto;
import com.radnoti.project.model.dto.UserDto;
import com.radnoti.project.model.entity.Art;
import com.radnoti.project.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtMapper {
    ArtDto fromEntityToDto(Art art);
    Art fromDtoToEntity(ArtDto artDto);
}
