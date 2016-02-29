package com.pocopay.springmvc.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pocopay.springmvc.constants.PocopayErrorCode;
import com.pocopay.springmvc.exception.NotFoundException;
import com.pocopay.springmvc.exception.ForbiddenRequestException;
import com.pocopay.springmvc.mapper.PaymentMapperImpl;
import com.pocopay.springmvc.model.Account;
import com.pocopay.springmvc.model.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("paymentService")
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
    private AccountService accountService;

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	private PaymentMapperImpl dataManager;
	public PaymentMapperImpl getDataManager() {
		return dataManager;
	}

	public void setDataManager(PaymentMapperImpl dataManager) {
		this.dataManager = dataManager;
	}
	
	public PaymentServiceImpl()
	{
		this.dataManager = new PaymentMapperImpl();
	}

	@Override
	public Payment getPaymentById(Long id) {
		Payment payment= dataManager.getPaymentById(id);
		if(payment == null)
			throw new NotFoundException(PocopayErrorCode.NO_PAYMENT_FOUND_WITH_ID, "No Payment found with ID: " + id);
		return payment;
	}

	@Override
	public void createPayment(Payment payment) {
		
		logger.debug("createPayment() Method initiated from Account with ID:  " + payment.getSrcAccountID() + " to account with ID : " +payment.getDestAccountID());
		
		Account srcAccount = accountService.getAccountByID(payment.getSrcAccountID());
		Account destAccount = accountService.getAccountByID(payment.getDestAccountID());
		
		BigDecimal transactionAmount =payment.getPaymentAmount() ;
		
		validateRequest(srcAccount,destAccount, transactionAmount);
		
		srcAccount.setAccountBalance(srcAccount.getAccountBalance().subtract(transactionAmount));
		destAccount.setAccountBalance(destAccount.getAccountBalance().add(transactionAmount));
		
		
		accountService.updateAccountBalance(srcAccount);		
		accountService.updateAccountBalance(destAccount);
		
		
		dataManager.createPayment(payment);		
		
	}
	
		
	void validateRequest(Account sourceAccount,Account destAccount, BigDecimal transactionAmount)
	{		
		if(sourceAccount == null)
			throw new NotFoundException(PocopayErrorCode.SOURCE_ACCOUNT_NOT_FOUND, "Source Account Not Found");
		
		if(destAccount == null)
			throw new NotFoundException(PocopayErrorCode.DESTINATION_ACCOUNT_NOT_FOUND, "Destination Account Not Found");
		
		if(transactionAmount.signum() < 0)
			throw new ForbiddenRequestException(PocopayErrorCode.NEGATIVE_BALANCE_TRANSACTION_REQUESTED, "Negative amount can't be transferred");
		
		if(transactionAmount.compareTo(sourceAccount.getAccountBalance())>0)
			throw new ForbiddenRequestException(PocopayErrorCode.INSUFFICIENT_TRANSACTION_BALANCE, "Insufficient balance in source account");		
	}
	
}
