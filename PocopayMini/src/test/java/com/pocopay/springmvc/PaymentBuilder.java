package com.pocopay.springmvc;

import java.math.BigDecimal;

import com.pocopay.springmvc.model.Payment;

public class PaymentBuilder {

	private Payment payment = new Payment();

	public PaymentBuilder id(long id) {
		payment.setPaymentID(id);
		return this;
	}

	public PaymentBuilder src_id(Long id) {
		payment.setSrcAccountID(id);
		return this;
	}

	public PaymentBuilder dest_id(Long id) {
		payment.setDestAccountID(id);
		return this;
	}
	
	public PaymentBuilder balance(BigDecimal amount) {
		payment.setPaymentAmount(amount);
		return this;
	}

	public PaymentBuilder ref(String ref) {
		payment.setPaymentReference(ref);
		return this;
	}

	public Payment build() {
		return payment;
	}
}
