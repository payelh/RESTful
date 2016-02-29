package com.pocopay.springmvc.mapper;

import java.util.List;

import com.pocopay.springmvc.model.Payment;

public interface PaymentMapper {

	Payment getPaymentById(Long id);
	
	void createPayment(Payment payment);
	
	List<Payment> getAllPayemtnsBySourceAccountID(Long srcAccountID);
	
}
