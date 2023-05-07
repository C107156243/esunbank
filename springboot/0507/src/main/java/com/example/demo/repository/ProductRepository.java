package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query("SELECT p FROM Product p WHERE p.pid = ?1")
	Optional<Product> findProductByPid(String pid);
}
