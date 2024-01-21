package com.radnoti.project.controller;

import com.radnoti.project.model.dto.ArtDto;
import com.radnoti.project.model.entity.Art;
import com.radnoti.project.service.ArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ArtController {

    @Autowired
    private ArtService artService;

    @PostMapping("/add")
    public Art addProduct(@RequestBody ArtDto artDto){
        return artService.saveProduct(artDto);
    }

    @GetMapping("/{productId}")
    public Art getProduct(@PathVariable Integer productId) {
        return artService.getProductById(productId);
    }
}
