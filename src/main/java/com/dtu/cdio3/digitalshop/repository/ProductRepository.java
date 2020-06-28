package com.dtu.cdio3.digitalshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtu.cdio3.digitalshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
