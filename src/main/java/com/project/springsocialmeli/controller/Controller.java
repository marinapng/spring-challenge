package com.project.springsocialmeli.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.dto.BuyerDTO;

import com.project.springsocialmeli.dto.FollowDTO;
import com.project.springsocialmeli.dto.SellerDTO;
import com.project.springsocialmeli.model.Buyer;

import com.project.springsocialmeli.model.Seller;
import com.project.springsocialmeli.service.SocialMeliService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    SocialMeliService socialMeliService;

    @Autowired
    public Controller(SocialMeliService socialMeliService){
        this.socialMeliService = socialMeliService;
    }

    @PostMapping("/buyer/createBuyer")
    public BuyerDTO createBuyer(@RequestParam String name){
        Buyer b = socialMeliService.createBuyer(name);
        BuyerDTO bDto = new BuyerDTO();
        if(b != null) {
            bDto.setName(b.getName());
            bDto.setId(b.getId());
            bDto.setFollowing(b.getFollowing());
        }
        return bDto;
    }

    @PostMapping("/buyer/{buyerId}/follow/{sellerId}")
    public FollowDTO followSeller(@PathVariable int buyerId, @PathVariable int sellerId){
        List<String> names = socialMeliService.follow(buyerId, sellerId);
        FollowDTO fDTO = new FollowDTO();
        fDTO.setSellerName(names.get(1));
        fDTO.setBuyerName(names.get(0));
        return fDTO;
    }

    @PostMapping("/seller/createSeller")
    public SellerDTO createSeller(@RequestParam String name){
        Seller s = socialMeliService.createSeller(name);
        SellerDTO sDto = new SellerDTO();
        if(s != null) {
            sDto.setName(s.getName());
            sDto.setId(s.getId());
            sDto.setFollowers(s.getFollowers());
        }
        return sDto;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @GetMapping("/seller/{sellerId}/followers/count")
    public SellerDTO getSellerFollowers(@PathVariable int sellerId){
        Seller s = socialMeliService.getSellerFollowers(sellerId);
        SellerDTO sDTO = new SellerDTO();
        sDTO.setFollowers_count(s.getFollowers_count());
        sDTO.setName(s.getName());
        sDTO.setId(s.getId());
        return sDTO;
    }
}
