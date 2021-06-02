package com.project.springsocialmeli.dto;

import com.project.springsocialmeli.model.Buyer;
import lombok.Data;

import java.util.List;

@Data
public class SellerDTO {

    String name;
    int id;
    int followers_count;
    List<Buyer> followers;


}
