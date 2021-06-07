package com.project.springsocialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product {

    int id;
    String name;
    String type;
    String brand;
    String color;
    String notes;

    public Product(int id, String name, String type, String brand, String color, String notes){
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
