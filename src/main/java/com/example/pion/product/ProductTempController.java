package com.example.pion.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.pion.product.application.ProductTempService;
import com.example.pion.product.dto.ProductRequest;

@Controller
@RequestMapping("/main")
public class ProductTempController {
	@Autowired
	private ProductTempService productTempService;
	
//	public ProductTempController(ProductTempController productTempController) {
//		this.prodectTempService = prodectTempService;
//	}

	@GetMapping("/string")
	public String getMainString() {
		return "index";
	}
	
	@GetMapping("/model")
	public String temp(Model md) {
		md.addAttribute("name", "상품 A");
		return "/product/productTemp";
	}
	
	@GetMapping("/modelAndView")
	public ModelAndView getMainModel() {
		ModelAndView mv = new ModelAndView("/main/modelA");
		mv.addObject("name", "modelA");
		return mv;
	}
	
	@GetMapping("/responseBody")
	public @ResponseBody RestJson getResponseBody() {
		RestJson result = new RestJson("상품 A", 3000);
		return result;
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveProduct(@RequestBody ProductRequest request) {
		productTempService.save(request);
	}
}
