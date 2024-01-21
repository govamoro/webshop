package com.radnoti.project.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ArtDto {

    private Integer id;
    private String title;
    private String artist;
    private Integer price;
    private String description;
    private String imgUrl;
    private Integer CreatedYear;
    private float xCm;
    private float yCm;
    private Integer material;

}
