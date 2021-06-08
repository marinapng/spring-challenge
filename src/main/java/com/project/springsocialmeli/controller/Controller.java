package com.project.springsocialmeli.controller;

import com.project.springsocialmeli.dto.*;

import com.project.springsocialmeli.model.Buyer;

import com.project.springsocialmeli.model.Post;
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

    @GetMapping("/seller/{sellerId}/followers/count")
    public SellerDTO getSellerFollowersCount(@PathVariable int sellerId){
        Seller s = socialMeliService.getSellerFollowers(sellerId, "");
        SellerDTO sDTO = new SellerDTO();
        sDTO.setFollowers_count(s.getFollowers_count());
        sDTO.setName(s.getName());
        sDTO.setId(s.getId());
        return sDTO;
    }

    @GetMapping("/seller/{sellerId}/followers/list")
    public SellerDTO getSellerFollowersList(@PathVariable int sellerId, @RequestParam String order){
        Seller s = socialMeliService.getSellerFollowers(sellerId, order);
        SellerDTO sDTO = new SellerDTO();
        sDTO.setName(s.getName());
        sDTO.setId(s.getId());
        sDTO.setFollowers(s.getFollowersList());
        return sDTO;
    }

    @GetMapping("/buyer/{buyerId}/following/list")
    public BuyerDTO getBuyerFollowing(@PathVariable int buyerId, @RequestParam String order ){
        Buyer b = socialMeliService.getBuyerFollowing(buyerId, order);
        BuyerDTO bDTO = new BuyerDTO();
        bDTO.setFollowing(b.getFollowingList());
        bDTO.setName(b.getName());
        bDTO.setId(b.getId());
        return bDTO;
    }

    @PostMapping("/products/newpost")
    public PostResponseDTO createPost(@RequestBody PostRequestDTO postRequestDTO){
         Post p = socialMeliService.createPost(postRequestDTO);
         PostResponseDTO pDTO = new PostResponseDTO();
         pDTO.setPostId(p.getId());
         pDTO.setCategory(p.getCategory());
         pDTO.setDetail(p.getDetail());
         pDTO.setPrice(p.getPrice());
         pDTO.setSellerId(p.getSellerId());
         pDTO.setDate(p.getDate());
         return pDTO;

    }

    @PostMapping("/products/newpromopost")
    public PostResponseDTO createPromoPost(@RequestBody PostRequestDTO postRequestDTO){
        Post p = socialMeliService.createPromoPost(postRequestDTO);
        PostResponseDTO pDTO = new PostResponseDTO();
        pDTO.setPostId(p.getId());
        pDTO.setCategory(p.getCategory());
        pDTO.setDetail(p.getDetail());
        pDTO.setPrice(p.getPrice());
        pDTO.setSellerId(p.getSellerId());
        pDTO.setDate(p.getDate());
        pDTO.setHasPromo(p.getHasPromo());
        pDTO.setDiscount(p.getDiscount());
        return pDTO;
    }

    @GetMapping("/products/followed/{buyerId}/list")
    public PostListDTO getPostFromSellers(@PathVariable int buyerId, @RequestParam String order){
        List<Post> p = socialMeliService.getPostsFromFollowing(buyerId, order);
        PostListDTO pDTO = new PostListDTO();
        pDTO.setPosts(p);
        pDTO.setBuyerId(buyerId);
        return pDTO;

    }

    @PostMapping("/buyer/{buyerId}/unfollow/{sellerIdToUnfollow}")
    public FollowDTO unfollow(@PathVariable int buyerId, @PathVariable int sellerIdToUnfollow){
        List<String> names = socialMeliService.unfollow(buyerId, sellerIdToUnfollow);
        FollowDTO fDTO = new FollowDTO();
        fDTO.setSellerName(names.get(1));
        fDTO.setBuyerName(names.get(0));
        return fDTO;
    }

    @GetMapping("/products/{sellerId}/countPromo/")
    public SellerDTO countPromoProducts(@PathVariable int sellerId){
        Seller s = socialMeliService.countPromoProducts(sellerId);
        SellerDTO sDTO = new SellerDTO();
        sDTO.setPromoproducts_count(s.getPromoproducts_count());
        sDTO.setName(s.getName());
        sDTO.setId(s.getId());
        return sDTO;
    }


}
