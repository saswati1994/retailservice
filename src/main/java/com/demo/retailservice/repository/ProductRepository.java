package com.demo.retailservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.demo.retailservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
	
}
