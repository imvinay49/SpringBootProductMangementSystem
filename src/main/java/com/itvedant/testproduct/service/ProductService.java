package com.itvedant.testproduct.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.testproduct.dao.ProductDAO;
import com.itvedant.testproduct.dao.ProductUpdateDAO;
import com.itvedant.testproduct.entity.Product;
import com.itvedant.testproduct.repository.ProductRespository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRespository productRespository;
	
	//Add a Product
	public Product addProduct(ProductDAO dao) {
		Product product = new Product();
		
		product.setProduct_name(dao.getProduct_name());
		product.setProduct_description(dao.getProduct_description());
		product.setPrice(dao.getPrice());
		
		productRespository.save(product);
		return product;
		
	}
	
	//Get All Product
	public List<Product> getAllProduct(){
		List<Product> products = new ArrayList<Product>();
		
		products = productRespository.findAll();
		
		return products;
	}
	
	//Get Product By Id
	public Product getById(Integer id) {
		Product product = new Product();
		
		product = productRespository.findById(id).get();
		
		if(product != null) {
			return product;
		}
		
		return null;
	}
	
	//Update Product by id
	public Product updateById(Integer id,ProductUpdateDAO dao) {
		Product product = new Product();
		product = productRespository.findById(id).get();
		
		if(product != null) {
			product.setProduct_name(dao.getProduct_name());
			product.setProduct_description(dao.getProduct_description());
			product.setPrice(dao.getPrice());
			
			productRespository.save(product);
			return product;
		}
		
		return null;
	}
	
	//Delete by id
	public String deleteById(Integer id) {
		Product product = new Product();
		product = productRespository.findById(id).get();
		
		if(product != null) {
			this.productRespository.deleteById(id);
			return "Product Deleted Successfully";
		}else {
			return "Product not found with the Id";
		}
	}
}
