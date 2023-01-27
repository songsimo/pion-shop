package com.example.pion.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pion.product.application.ProductTempService;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;

@Controller
@RequestMapping("/main")
public class ProductTempController {
	@Autowired
	private ProductTempService productTempService;
	
//	public ProductTempController(ProductTempController productTempController) {
//		this.prodectTempService = prodectTempService;
//	}
	
	@GetMapping("/thanks")
	public String getMainPage() {
		System.out.println(".................");
		return "main";
	}

	@GetMapping("/string")
	public String getMainString() {
		return "index";
	}
	
	@GetMapping("/model")
	public String temp(Model md) {
		md.addAttribute("name", "상품 A");
		return "/product/productTemp";
	}
	
	@GetMapping("/find/all")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public List<ProductResponse> findAllProduct() {
		return productTempService.findAllProduct();
	}
	
//	@GetMapping("/find/all")
//	public ResponseEntity<List<ProductResponse>> findAllProduct() {
//		return ResponseEntity.ok(productTempService.findAllProduct());
//	}
	
	@GetMapping("/detail/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ModelAndView getProductDetailById(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("product/productDetail");
		
		ProductResponse result = productTempService.findProductById(id);
		
		mv.addObject("product", result);
		return mv;
	}
	
	@GetMapping("/find/{id}")
	public String getProductById(@PathVariable String id) {
		System.out.println("findById : " + id);
		return "/product/productList";
	}
	
	@GetMapping("/params")
	public String getProductByParams(@ModelAttribute ProductRequest request) {
		System.out.println("params : " + request.getName() + " " + request.getPrice());
		return "/product/productList";
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
	
	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseStatus(code = HttpStatus.MOVED_PERMANENTLY)
	public String saveProduct(ProductRequest request) {
		productTempService.save(request);
		return "redirect:/";
	}
	
	@GetMapping("/exception")
	public void throwException() {
		throw new RuntimeException();
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public String getErrorPage() {
		return "error";
	}
}
