package com.dtu.cdio3.digitalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.cdio3.digitalshop.entity.Product;
import com.dtu.cdio3.digitalshop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> listAll(){
		return productRepo.findAll();
	}
	
	public void save(Product product) {
		productRepo.save(product);
	}
	
	public Product get(int id) {
		return productRepo.getOne(id);
	}
	
	public void delete(int id) {
		productRepo.deleteById(id);
	}
}
