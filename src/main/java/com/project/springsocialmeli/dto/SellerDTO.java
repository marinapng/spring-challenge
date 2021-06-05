package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.model.Buyer;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SellerDTO {

    String name;
    int id;
    Integer followers_count;
    List<Buyer> followers;


}
