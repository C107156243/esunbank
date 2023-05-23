package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;


public interface OrderRepository extends JpaRepository<Order, String>{
	
//	@Query("SELECT o FROM Order o WHERE o.orderid = ?1")
//	Optional<Order> findOrderByOrderid(String orderid);
	Order findByOrderid(String orderid);
}
