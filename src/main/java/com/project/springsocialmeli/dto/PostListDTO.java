package com.project.springsocialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.springsocialmeli.model.Post;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostListDTO {

    int buyerId;
    List<Post> posts;
}
