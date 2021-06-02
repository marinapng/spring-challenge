package com.project.springsocialmeli.service;

import com.project.springsocialmeli.model.Buyer;
import com.project.springsocialmeli.model.Seller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialMeliService {

    List<Buyer> buyers = new ArrayList<>();
    List<Seller> sellers = new ArrayList<>();



    ///// BUYER

    public Buyer createBuyer(String name){
        Buyer b = null;
        if(!doesBuyerExists(name)){
            b = new Buyer(name, this.buyers.size() + 1);
            buyers.add(b);

        }
        return b;
    }

    public boolean doesBuyerExists(String name){
        for(Buyer b : buyers){
            if(b.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public List<String> follow(int buyerId, int sellerId){
        Buyer b = getBuyerById(buyerId);
        Seller s = getSellerById(sellerId);
        b.follow(s);
        List<String> buyerAndSeller = new ArrayList<>();
        buyerAndSeller.add(b.getName());
        buyerAndSeller.add(s.getName());
        return buyerAndSeller;
     }

    public Buyer getBuyerById(int buyerId){
        for(Buyer b : buyers){
            if(b.getId() == buyerId){
                return b;
            }
        }
        return null;
    }


    //// SELLER

    public Seller createSeller(String name){
        Seller s = null;
        if(!doesSellerExists(name)){
            s = new Seller(name, sellers.size() + 1);
            sellers.add(s);
        }
        return s;
    }

    public boolean doesSellerExists(String name){
        for(Seller s : sellers){
            if(s.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Seller getSellerById(int sellerId){
        for(Seller s : sellers){
            if(s.getId() == sellerId){
                return s;
            }
        }
        return null;
    }

    public Seller getSellerFollowers(int sellerId){
        Seller s = getSellerById(sellerId);
        s.getFollowersCount();
        return s;
    }


}
