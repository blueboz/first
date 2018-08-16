package com.pizza.domain;

import java.io.Serializable;

public class PaymentDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String account;
	
	private String paymentType;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}
