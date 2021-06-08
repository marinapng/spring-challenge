package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Post {

    int id;
    int sellerId;
    Product detail;
    int category;
    double price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    Boolean hasPromo;
    Double discount;

    public Post(int id, Product detail, LocalDate date){
        this.id = id;
        this.detail = detail;
        this.date = date;

    }
}
