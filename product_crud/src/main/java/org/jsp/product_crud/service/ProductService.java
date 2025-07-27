package org.jsp.product_crud.service;

import java.util.List;
import org.jsp.product_crud.entity.Product;
import org.jsp.product_crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public void add(Product product, ModelMap map) {
		repository.save(product);
		map.put("pass", "product added succesfully...!😍");
	}
	
//just declaring method findRecords it will be called and return to repository.findAll ---> it is in built
	public List<Product> findRecords() {
		return repository.findAll();
	}
	
	public void deleteRecords(int id,ModelMap map) {
		repository.deleteById(id);
		map.put("pass", "Product deleted successfully");
	}
	
	public void edit(int id, ModelMap map) {
    	Product product=repository.findById(id).get();	
        map.put("product",product);
	}
	
	public void update(Product product, ModelMap map) {
		repository.save(product);
		map.put("pass", "Product Updated Successfully");
	}
	
	
}
