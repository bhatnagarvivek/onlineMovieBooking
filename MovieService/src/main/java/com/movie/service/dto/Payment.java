package com.movie.service.dto;

import java.math.BigDecimal;

public class Payment {

	private Long id;

	private Long booking_id;

	private Long transaction_id;

	private BigDecimal amount;

	private String status;

	private String payment_gateway;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_gateway() {
		return payment_gateway;
	}

	public void setPayment_gateway(String payment_gateway) {
		this.payment_gateway = payment_gateway;
	}

}