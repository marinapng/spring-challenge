package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY
)
public class PostRequestDTO {

    int sellerId;
    String productName;
    String productType;
    String productBrand;
    String productColor;
    String productNotes;
    int category;
    double price;

}
