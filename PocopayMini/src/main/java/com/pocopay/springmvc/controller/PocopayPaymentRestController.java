package com.pocopay.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.pocopay.springmvc.model.Payment;
import com.pocopay.springmvc.service.PaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/payment/")   // V1 for Version 1
public class PocopayPaymentRestController {

	private static final Logger logger = LoggerFactory.getLogger(PocopayPaymentRestController.class);
	
	@Autowired
	PaymentService paymentService;
	
	private String retResourcePath = "/v1/payment/{id}";
		
	
	//-------------------Do a Payment--------------------------------------------------------	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createPayment(@RequestBody Payment payment, UriComponentsBuilder ucBuilder) {
		logger.debug("Received payment request  from account ID: " + payment.getSrcAccountID() + " to Account ID: " + payment.getDestAccountID());
		paymentService.createPayment(payment);
		HttpHeaders headers = new HttpHeaders();		
		headers.setLocation(ucBuilder.path(retResourcePath).buildAndExpand(payment.getPaymentID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//-------------------Get a Payment--------------------------------------------------------	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payment> getPayment(@PathVariable("id") long id) {
		logger.debug("Received request to get a payment with Payment ID: " + id);
		Payment payment = paymentService.getPaymentById(id);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
}
