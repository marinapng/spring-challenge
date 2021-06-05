package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.model.Buyer;
import com.project.springsocialmeli.model.Seller;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BuyerDTO {
    String name;
    int id;
    List<Seller> following;
}
