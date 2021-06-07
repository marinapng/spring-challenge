package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Post {

    int id;
    int sellerId;
    Product detail;
    int category;
    double price;
    String data;

    public Post(int id, Product detail, String data){
        this.id = id;
        this.detail = detail;
        this.data = data;

    }
}
