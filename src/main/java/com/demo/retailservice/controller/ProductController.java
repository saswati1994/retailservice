package com.demo.retailservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.retailservice.model.Product;
import com.demo.retailservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		   
		return productService.addProduct(product);
		
	}
	
	
	@GetMapping("product/filter")
	public ResponseEntity<List<Product>> getProductByFilter(
			@RequestParam(value="brand",required=false, defaultValue="") final String brand,
			@RequestParam(value="colour",required=false, defaultValue="") final String colour,
			@RequestParam(value="size",required=false, defaultValue="") final String size,
			@RequestParam(value="price",required=false, defaultValue="0") final Integer price){

		System.out.println(brand+" "+ colour+" "+ size +" "+price);

		return productService.getProductByFilter(brand,colour,size,price);
		
		
	
		
	}
}
