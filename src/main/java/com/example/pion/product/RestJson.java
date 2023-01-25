package com.example.pion.product;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RestJson {

    private String name;
    private int price;
}