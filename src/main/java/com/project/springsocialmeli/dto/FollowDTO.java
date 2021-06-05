package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowDTO {

    String sellerName;
    String buyerName;
}
