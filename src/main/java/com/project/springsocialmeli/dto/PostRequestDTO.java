package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY
)
public class PostRequestDTO {

    int sellerId;
    String data;
    String productName;
    String productType;
    String productBrand;
    String productColor;
    String productNotes;
    int category;
    double price;

}
