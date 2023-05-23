package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

//	@Query("SELECT od FROM OrderDetail od WHERE od.orderid = ?1")
//	Optional<OrderDetail> findOrderDetailByOrderid(String orderid);
	List<OrderDetail> findOrderDetailByOrderid(String orderid);
}
