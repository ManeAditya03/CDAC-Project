package com.app.dtos;

public class PlaceOrderDto {

	private double utrno;
	private double amount;
	private Long userid;
	public double getUtrno() {
		return utrno;
	}
	public void setUtrno(double utrno) {
		this.utrno = utrno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public PlaceOrderDto(double utrno, double amount, Long userid) {
		super();
		this.utrno = utrno;
		this.amount = amount;
		this.userid = userid;
	}
	public PlaceOrderDto() {
		super();
	}
}
