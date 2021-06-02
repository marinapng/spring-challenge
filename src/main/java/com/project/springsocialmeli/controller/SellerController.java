package com.project.springsocialmeli.controller;

import com.project.springsocialmeli.dto.SellerDTO;
import com.project.springsocialmeli.model.Seller;
import com.project.springsocialmeli.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SellerController {

    SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @PostMapping("/createSeller")
    public SellerDTO createSeller(@RequestParam String name){
        Seller s = sellerService.createSeller(name);
        SellerDTO sDto = new SellerDTO();
        if(s != null) {
            sDto.setName(s.getName());
            sDto.setId(s.getId());
            sDto.setFollowers(s.getFollowers());
        }
        return sDto;
    }


}
