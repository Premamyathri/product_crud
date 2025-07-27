package org.jsp.product_crud.controller;

import java.util.List;

import org.jsp.product_crud.entity.Product;
import org.jsp.product_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	
	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String main() {
		return "main.html";
	}
	@GetMapping("/add")
	public String loadadd() {
		return "add.html";
	}
	
	
//	@PostMapping("/add")
//	public String add(@ModelAttribute Product product,ModelMap map) {
//		System.out.println(product);
//		map.put("pass","Product added Succesfully");
//		return "main.html";
//	}

	@PostMapping("/add")
	public String add(Product product,ModelMap map) {
		service.add(product, map);
		return "main.html";
	}
	
	@GetMapping("/view")
	public String view(ModelMap map) {
		List<Product> products=service.findRecords();
		map.put("products", products);
		return "view.html";
}
	
//	@GetMapping("/edit")
//	public String edit() {
//		return "edit.html";
//	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, ModelMap map) {
		service.deleteRecords(id,map);
		return view(map);
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, ModelMap map) {
		service.edit(id, map);
		return "edit.html";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute Product product, ModelMap map) {
		service.update(product, map);
		return view(map);	
	}
}

