package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Seller {
    int id;
    String name;
    List<Buyer> followers;
    List<Post> posts;
    List<Product> products;
    Integer followers_count;

    public Seller(String name, int id){
        this.name = name;
        this.id = id;
        followers = new ArrayList<>();
        products = new ArrayList<>();
        posts = new ArrayList<>();
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

    public void getFollowersCount(){
        this.followers_count = this.followers.size();
    }

    public List<Buyer> getFollowersList(){
        List<Buyer> buyers = new ArrayList<>();
        for(Buyer b : followers){
            Buyer toAdd = new Buyer(b.getName(), b.getId());
            buyers.add(toAdd);
        }
        return buyers;
    }

    public Post createPost(Post post, Product product, int category, double price){
        post.setSellerId(this.id);
        post.setCategory(category);
        post.setPrice(price);
        this.products.add(product);
        this.posts.add(post);
        return post;
    }



}
