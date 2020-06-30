package com.dtu.cdio3.digitalshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtu.cdio3.digitalshop.entity.Product;
import com.dtu.cdio3.digitalshop.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductAPI {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(productService.listAll());
	}
	
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productService.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product product = productService.get(id);

        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> delete(@PathVariable int id) {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
