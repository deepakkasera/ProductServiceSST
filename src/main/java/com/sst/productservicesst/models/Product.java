package com.sst.productservicesst.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image;

//    Product(Long id, String title, String description,
//            Double price, Category category, String image) {
//        this.id = id;
//        this.price = price;
//        //and so on
//    }
}
