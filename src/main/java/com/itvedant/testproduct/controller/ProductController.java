package com.itvedant.testproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.testproduct.dao.ProductDAO;
import com.itvedant.testproduct.dao.ProductUpdateDAO;
import com.itvedant.testproduct.entity.Product;
import com.itvedant.testproduct.service.ProductService;

@Controller
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@PostMapping("")
	public ResponseEntity<?> addProduct(@RequestBody ProductDAO dao) {
		return ResponseEntity.ok(this.productService.addProduct(dao));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllProduct(){
		return ResponseEntity.ok(this.productService.getAllProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		try {
			var product = this.productService.getById(id);
			if(product != null) {
				return ResponseEntity.ok(product);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\"Product with ID \" + id + \" not found.\"");
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"An unexpected error occurred: " + e.getMessage()
					);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody ProductUpdateDAO dao){
		try {
			var product = this.productService.updateById(id, dao);
			if(product != null) {
				return ResponseEntity.ok(product);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						"\"Product with ID \" + id + \" not found.\""
						);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"An unexpected error occurred: " + e.getMessage()
					);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		try {
			var product = this.productService.deleteById(id);
			if(product != null) {
				return ResponseEntity.ok(product);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						"Error while finding the ID"
						);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"An unexpected error occurred: " + e.getMessage()
					);
		}
	}
}
