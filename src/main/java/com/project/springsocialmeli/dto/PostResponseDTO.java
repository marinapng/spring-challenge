package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.model.Product;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostResponseDTO {
    int sellerId;
    int postId;
    Product detail;
    int category;
    double price;
}
