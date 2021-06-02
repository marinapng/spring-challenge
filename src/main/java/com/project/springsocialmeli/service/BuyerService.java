package com.project.springsocialmeli.service;

import com.project.springsocialmeli.model.Buyer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerService {

    List<Buyer> buyers = new ArrayList<>();


    public Buyer createBuyer(String name){
        Buyer b = null;
        if(!findBuyerByName(name)){
            b = new Buyer(name);
            buyers.add(b);

        }
        return b;
    }

    public boolean findBuyerByName(String name){
        for(Buyer b : buyers){
            if(b.getName().equals(name)){
                return true;
            }
        }
        return false;
    }



}
