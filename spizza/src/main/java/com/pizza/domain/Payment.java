package com.pizza.domain;

import java.io.Serializable;

public class Payment implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private PaymentDetails paymentDetails;

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
}
