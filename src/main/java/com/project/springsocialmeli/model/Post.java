package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Post {

    int id;
    int sellerId;
    Product detail;
    int category;
    double price;

    public Post(int id, Product detail){
        this.id = id;
        this.detail = detail;

    }
}
