package com.project.springsocialmeli.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Buyer {

    int id;
    String name;
    List<Seller> following = new ArrayList<>();

    public Buyer(String name){
        this.name = name;
    }

    public void follow(Seller seller){
        seller.followers.add(this);
        this.following.add(seller);
    }




}