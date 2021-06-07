package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.model.Product;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostResponseDTO {

    int sellerId;
    int postId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    Product detail;
    int category;
    double price;
}
