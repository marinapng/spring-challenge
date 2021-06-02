package com.project.springsocialmeli.controller;

import com.project.springsocialmeli.dto.BuyerDTO;

import com.project.springsocialmeli.model.Buyer;

import com.project.springsocialmeli.service.BuyerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @PostMapping("/createBuyer")
    public BuyerDTO createSeller(@RequestParam String name){
        Buyer b = buyerService.createBuyer(name);
        BuyerDTO bDto = new BuyerDTO();
        if(b != null) {
            bDto.setName(b.getName());
            bDto.setId(b.getId());
            bDto.setFollowing(b.getFollowing());
        }
        return bDto;
    }
    
}
