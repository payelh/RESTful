package com.pocopay.springmvc.controller;

import java.util.List;

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

import com.pocopay.springmvc.model.Account;
import com.pocopay.springmvc.model.Payment;
import com.pocopay.springmvc.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1/account/")   // V1 for Version 1
public class PocopayAccountRestController {

	private static final Logger logger = LoggerFactory.getLogger(PocopayAccountRestController.class);
	
	@Autowired
	AccountService accountService;	
	private String retResourcePath = "/v1/account/{id}";	 
	 
	//-------------------Create an Account--------------------------------------------------------	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
		logger.debug("Recived request for create payment");
		accountService.createAccount(account);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(retResourcePath).buildAndExpand(account.getAccountID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//-------------------Get an Account--------------------------------------------------------
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
		logger.debug("Received request to retrieve Account with id " + id);
		Account account = accountService.getAccountByID(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	//-------------------List all Payment from an account--------------------------------------------------------
	
	@RequestMapping(value = "{id}/transaction/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Payment>> getPayment(@PathVariable("id") long id){
		logger.debug("Received request to list Payment from Account with id " + id);
		List<Payment> payments = accountService.getAllPayemtnsBySourceAccountID(id);
		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);	
	}
	
}
