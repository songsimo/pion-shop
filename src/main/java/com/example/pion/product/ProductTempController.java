package com.example.pion.product;

import com.example.pion.product.application.ProductTempService;
import com.example.pion.product.dto.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class ProductTempController {

    @Autowired
    private ProductTempService productTempService;

//    public ProductTempController(ProductTempService productTempService) {
//        this.productTempService = productTempService;
//    }

    @GetMapping("/string")
    public String getString() {
        return "index";
    }

    @GetMapping
    public String temp(Model md) {
        md.addAttribute("name", "상품 A");
        return "/product/productTemp";
    }

    @GetMapping("/model")
    public ModelAndView getModel() {
        ModelAndView mv = new ModelAndView("/main/model");
        mv.addObject("name", "model");
        return mv;
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequest productRequest) {
        productTempService.save(productRequest);
    }
}
