package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderitemsn;
	
	private String orderid;
	private String productid;
	private Integer quantity;
	private Integer standprice;
	private Integer itemprice;
	
	public Integer getOrderItemSN() {
		return orderitemsn;
	}
	
	public void setOrderItemSN(Integer orderitemsn) {
		this.orderitemsn = orderitemsn;
	}
	
	public String getOrderID() {
		return orderid;
	}
	
	public void setOrderID(String orderid) {
		this.orderid = orderid;
	}
	
	public String getProductID() {
		return productid;
	}
	
	public void setProductID(String productid) {
		this.productid = productid;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getStandPrice() {
		return standprice;
	}
	
	public void setStandPrice(Integer standPrice) {
		this.standprice = standPrice;
	}
	
	public Integer getItemPrice() {
		return itemprice;
	}
	
	public void setItemPrice(Integer itemPrice) {
		this.itemprice = itemPrice;
	}
}
