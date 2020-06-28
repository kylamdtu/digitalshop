package com.dtu.cdio3.digitalshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtu.cdio3.digitalshop.entity.Category;
import com.dtu.cdio3.digitalshop.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepo;
	
	public List<Category> listAll(){
		return catRepo.findAll();
	}
	
	public void save(Category category) {
		catRepo.save(category);
	}
	
	public Category get(int id) {
		return catRepo.getOne(id);
	}
	
	public void delete(int id) {
		catRepo.deleteById(id);
	}
}
