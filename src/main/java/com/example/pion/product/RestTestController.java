package com.example.pion.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestTestController {

    @GetMapping("/get")
    public String getString() {
        return "index";
    }

    @GetMapping("/getJson")
    public RestJson getJson() {

        return new RestJson("상품이름", 1000);
    }
}