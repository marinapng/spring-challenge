package com.project.springsocialmeli.dto;

import com.project.springsocialmeli.model.Buyer;
import com.project.springsocialmeli.model.Seller;
import lombok.Data;

import java.util.List;

@Data
public class BuyerDTO {
    String name;
    int id;
    List<Seller> following;
}
