package com.itvedant.testproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.testproduct.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}
