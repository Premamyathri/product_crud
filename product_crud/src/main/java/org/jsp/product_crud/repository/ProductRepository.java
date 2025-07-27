package org.jsp.product_crud.repository;

import org.jsp.product_crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
