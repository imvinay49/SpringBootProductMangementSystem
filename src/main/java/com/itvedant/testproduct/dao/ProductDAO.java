package com.itvedant.testproduct.dao;

public class ProductDAO {
	String product_name;
	String product_description;
	Integer price;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "productDAO [product_name=" + product_name + ", product_description=" + product_description + ", price="
				+ price + "]";
	}
	
	
}
