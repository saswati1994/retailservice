package com.demo.retailservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.retailservice.model.Product;
import com.demo.retailservice.repository.ProductRepository;


@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public ResponseEntity<String> addProduct(Product product) {

    productRepository.save(product);

    return new ResponseEntity("product added", HttpStatus.CREATED);

  }


  public ResponseEntity<List<Product>> getProductByFilter(String brand,
      String colour, String size, Integer price) {

    Product productSearch = new Product();


    if(!brand.isEmpty()) {
      productSearch.setBrand(brand);
    }

    if(!colour.isEmpty()) {
      productSearch.setColour(colour);
    }

    if(!size.isEmpty()) {
      productSearch.setSize(size);
    }

    if(price != 0) {
      productSearch.setPrice(price);
    }

    System.out.println(productSearch);
    Example<Product> productExample = Example.of(productSearch);
    System.out.println(productExample);
    List<Product> products = productRepository.findAll(productExample);
    System.out.println(products);


    return new ResponseEntity(products, HttpStatus.OK);

  }
}
