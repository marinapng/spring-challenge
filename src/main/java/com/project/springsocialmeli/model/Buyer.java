package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Buyer {

    int id;
    String name;
    List<Seller> following;

    public Buyer(String name, int id){
        this.name = name;
        this.id = id;
        this.following = new ArrayList<>();
    }

    public void follow(Seller seller){
        seller.followers.add(this);
        this.following.add(seller);
    }

    public void unfollow(Seller seller){
        seller.followers.remove(this);
        this.following.remove(seller);
    }

    public List<Seller> getFollowingList(){
        List<Seller> foll = new ArrayList<>();
        for(Seller s : following){
            Seller seller = new Seller(s.getName(), s.getId());
            foll.add(seller);
        }
        return foll;
    }




}
