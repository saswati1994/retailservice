package com.demo.retailservice.service;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.retailservice.model.Product;
import com.demo.retailservice.repository.ProductRepository;


@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public ResponseEntity<String> addProduct(String brand,String colour,String size,Integer price){
		
		Product product = new Product();
		product.setBrand("Lee");
		product.setColour("black");
		product.setPrice(1000);
		product.setProductDescription("abc");
		product.setProductId(1L);
		product.setProductName("dress");
		product.setSize("s");
		
		when(productRepository.save(any(Product.class))).thenReturn(product);
		ResponseEntity<String> productResult= productService.addProduct(product);
		assertNotNull(productResult);
		return productResult;
		
}
	


	@Test
	public ResponseEntity<List<Product>> getProductByFilter(String brand,
		      String colour, String size, Integer price){
		
		Product product = new Product();
		product.setBrand("Lee");
		product.setColour("black");
		product.setPrice(1000);
		product.setProductDescription("abc");
		product.setProductId(1L);
		product.setProductName("dress");
		product.setSize("s");
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		when(productRepository.findAll(any(Product.class))).thenReturn(productList);
		ResponseEntity<List<Product>> productResponse = productService.getProductByFilter(brand, colour, size, price);
		assertNotNull(productResponse);
		return productResponse;
		
	}

	
	
}
