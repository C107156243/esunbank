package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.OrderDetail;

public class OrderDto {
	
	private String orderid;
	private String memberid;
	private Integer price;
	private Integer paystatus;
	private List<OrderDetail> orderDetailList;
	
	public String getOrderID() {
		return orderid;
	}
	
	public void setOrderID(String orderid) {
		this.orderid = orderid;
	}
	
	public String getMemberid() {
		return memberid;
	}
	
	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
	
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
