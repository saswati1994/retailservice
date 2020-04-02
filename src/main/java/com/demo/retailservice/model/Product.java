package com.demo.retailservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "prod_id")
	private Long productId;

	@Column(name = "prod_name")
	private String productName;

	@Column(name = "prod_desc")
	private String productDescription;

	@Column(name = "brand")
	private String brand;

	@Column(name = "colour")
	private String colour;

	@Column(name = "size")
	private String size;

	@Column(name = "price")
	private Integer price;

	
}
