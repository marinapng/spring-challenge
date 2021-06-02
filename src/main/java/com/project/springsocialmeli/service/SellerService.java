package com.project.springsocialmeli.service;

import com.project.springsocialmeli.model.Seller;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class SellerService {

    List<Seller> sellers = new ArrayList<>();

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

    public Seller findSellerByName(String name){
        for(Seller s : sellers){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

}
