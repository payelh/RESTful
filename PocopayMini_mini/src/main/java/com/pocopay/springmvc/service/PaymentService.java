package com.pocopay.springmvc.service;

import com.pocopay.springmvc.model.Payment;

public interface PaymentService {

	Payment getPaymentById(Long id);	
	void createPayment(Payment payment);
		
	
}
