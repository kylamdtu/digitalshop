package com.dtu.cdio3.digitalshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtu.cdio3.digitalshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
