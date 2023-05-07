package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllproduct(){
		return productRepository.findAll();
	}
	
	public Product getProductByPid(String pid) {
		return productRepository.findProductByPid(pid).get();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void deleteProduct(String pid) {
		Optional<Product> productOptional = productRepository.findProductByPid(pid);
		productRepository.delete(productOptional.get());
	}
	
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
}
