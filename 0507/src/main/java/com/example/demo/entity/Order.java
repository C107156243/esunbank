package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_list")
public class Order {
	
	@Id
	private String orderid;
	
	private String memberid;
	private Integer price;
	private Integer paystatus;
	
	public String getOrderID() {
		return orderid;
	}
	
	public void setOrderID(String orderID) {
		this.orderid = orderID;
	}
	
	public String getMemberID() {
		return memberid;
	}
	
	public void setMemberID(String memberID) {
		this.memberid = memberID;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getPaystatus() {
		return paystatus;
	}
	
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
}
