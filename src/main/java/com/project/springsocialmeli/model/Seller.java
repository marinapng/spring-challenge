package com.project.springsocialmeli.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seller {
    int id;
    String name;
    List<Buyer> followers;

    public Seller(String name, int id){
        this.name = name;
        this.id = id;
        followers = new ArrayList<>();
    }

    public List<Buyer> getFollowers(){
        return this.followers;
    }

    public Buyer getFollowedByID(int id){
        for(Buyer b : followers){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public String getName(){
        return this.name;
    }
}
