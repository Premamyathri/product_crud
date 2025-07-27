package org.jsp.product_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private double price;
	private String category;
	private String imageLink;
}
