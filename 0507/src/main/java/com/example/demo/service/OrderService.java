package com.example.demo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.utils.KeyUtil;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductService productService;
	
	public String create(OrderDto orderDto) {
		
		String orderID = KeyUtil.genUniqueKey();
		Integer price = 0;
		
		for(OrderDetail orderDetail : orderDto.getOrderDetailList()) {
			
			Product product = productService.getProductByPid(orderDetail.getProductID());
			
			orderDetail.setOrderID(orderID);
			orderDetail.setStandPrice(product.getPrice());
			orderDetail.setItemPrice(orderDetail.getStandPrice()*orderDetail.getQuantity());
			price += orderDetail.getItemPrice();
			
			product.setQuantity(product.getQuantity()-orderDetail.getQuantity());
			productService.updateProduct(product);
			
			orderDetailRepository.save(orderDetail);
		}
		

		Order order = new Order();
		order.setOrderID(orderID);
		order.setMemberID(orderDto.getMemberid());
		order.setPaystatus(orderDto.getPaystatus());
		order.setPrice(price);
		orderRepository.save(order);
		
		return orderID;
	}
	
	public OrderDto getOrderByOrderid(String orderid) {
		
		Order order;
		order = orderRepository.findByOrderid(orderid);
		OrderDto orderDto =new OrderDto();
		orderDto.setOrderID(order.getOrderID());
		orderDto.setMemberid(order.getMemberID());
		orderDto.setPrice(order.getPrice());
		orderDto.setPaystatus(order.getPaystatus());
		orderDto.setOrderDetailList(orderDetailRepository.findOrderDetailByOrderid(orderid));
		return orderDto;
	}
}
