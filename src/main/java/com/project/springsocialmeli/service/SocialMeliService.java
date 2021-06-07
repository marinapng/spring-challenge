package com.project.springsocialmeli.service;

import com.project.springsocialmeli.dto.PostRequestDTO;
import com.project.springsocialmeli.model.Buyer;
import com.project.springsocialmeli.model.Post;
import com.project.springsocialmeli.model.Product;
import com.project.springsocialmeli.model.Seller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialMeliService {

    List<Buyer> buyers = new ArrayList<>();
    List<Seller> sellers = new ArrayList<>();
    List<Post> posts = new ArrayList<>();
    List<Product> products = new ArrayList<>();

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

    public Buyer getBuyerFollowing(int buyerId){
        return getBuyerById(buyerId);
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

    public Post createPost(PostRequestDTO postRequestDTO){
        Product product = new Product(this.products.size() + 1, postRequestDTO.getProductName(),
                                        postRequestDTO.getProductType(), postRequestDTO.getProductBrand(),
                                        postRequestDTO.getProductColor(), postRequestDTO.getProductNotes());
        this.products.add(product);
        Post post = new Post(this.posts.size() + 1, product);
        this.posts.add(post);
        Seller s = getSellerById(postRequestDTO.getSellerId());
        return s.createPost(post, product, postRequestDTO.getCategory(), postRequestDTO.getPrice());
    }

}
