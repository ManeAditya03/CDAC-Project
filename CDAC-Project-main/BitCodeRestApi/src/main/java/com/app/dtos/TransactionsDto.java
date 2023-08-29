package com.app.dtos;

import java.time.LocalDate;

public class TransactionsDto {
	private String fullname;
	private double utrno;
	private double amount;
	private LocalDate date;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public TransactionsDto(String fullname, double utrno, double amount, LocalDate date) {
		super();
		this.fullname = fullname;
		this.utrno = utrno;
		this.amount = amount;
		this.date = date;
	}
	public TransactionsDto() {
		super();
	}
}
