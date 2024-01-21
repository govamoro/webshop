package com.radnoti.project.service;

import com.radnoti.project.mapper.ArtMapper;
import com.radnoti.project.model.dto.ArtDto;
import com.radnoti.project.model.entity.Art;
import com.radnoti.project.repository.ArtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ArtService {

    @Autowired
    private ArtRepository artRepository;
    @Autowired
    private ArtMapper artMapper;

    public Art saveProduct(ArtDto artDto) {
        Art art = artMapper.fromDtoToEntity(artDto);
        return artRepository.save(art);
    }

    public Art getProductById(Integer id) {
        return artRepository.findById(id).orElse(null);
    }

}
