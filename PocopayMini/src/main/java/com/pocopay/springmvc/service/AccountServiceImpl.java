package com.pocopay.springmvc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pocopay.springmvc.configuration.PropertyPlaceholderConfig;
import com.pocopay.springmvc.constants.PocopayErrorCode;
import com.pocopay.springmvc.exception.ConflictRequestException;
import com.pocopay.springmvc.exception.NotFoundException;
import com.pocopay.springmvc.mapper.AccountMapperImpl; 
import com.pocopay.springmvc.mapper.PaymentMapperImpl;
import com.pocopay.springmvc.model.Account;
import com.pocopay.springmvc.model.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("accountService")
@Transactional
@Import(PropertyPlaceholderConfig.class)
public class AccountServiceImpl implements AccountService{
	
	static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
    @Value("${config.defaultDespositAmount}")
    private BigDecimal defaultDespositAmount;
    
    private AccountMapperImpl accountDataManager;
	
    private PaymentMapperImpl paymentDataManager;
	
	public PaymentMapperImpl getPaymentDataManager() {
		return paymentDataManager;
	}
	public void setPaymentDataManager(PaymentMapperImpl paymentDataManager) {
		this.paymentDataManager = paymentDataManager;
	}
	public AccountMapperImpl getDataManager() {
		return accountDataManager;
	}
	public void setDataManager(AccountMapperImpl dataManager) {
		this.accountDataManager = dataManager;
	}
	public AccountServiceImpl()
	{
		accountDataManager = new AccountMapperImpl();
		paymentDataManager = new PaymentMapperImpl();
	}
	
	@Override
	public Account getAccountByName(String name) {
		
		return accountDataManager.getAccountByName(name);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDataManager.getAllAccounts();
	}

	@Override
	public void createAccount(Account account) {
		account.setAccountBalance(defaultDespositAmount);
		if (isAccountExist(account)) 
		{
			throw  new ConflictRequestException(PocopayErrorCode.ACCOUNT_ALREADY_EXISTS,"Account already exists with the requested credentials");
		}
		accountDataManager.createAccount(account);
		
	}

	@Override
	public void updateAccountBalance(Account account) {
		accountDataManager.updateAccountBalance(account);				
	}

	@Override
	public void deleteUser(Integer userId) {
		accountDataManager.deleteAccount(userId);
		
	}

	@Override
	public boolean isAccountExist(Account account) {
		Account onSystemAccount = accountDataManager.getAccountByName(account.getOwnerName());
		if(onSystemAccount == null)
			return false;
		else 
			return (onSystemAccount.equals(account));			
	}

	@Override
	public int getTotalAccount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Account getAccountByID(Long id) {
		Account account =  accountDataManager.getAccountByID(id);
		if(account == null)
		{
			throw new NotFoundException(PocopayErrorCode.SOURCE_ACCOUNT_NOT_FOUND, "Source Account Not Found with ID : " + id);
		}
		return account;
	}
	@Override
	public List<Payment> getAllPayemtnsBySourceAccountID(long id) {
		List<Payment> payments = paymentDataManager.getAllPayemtnsBySourceAccountID(id);
		//if(payments==null || payments.isEmpty())
		{
			//throw new ContentNotFoundException(PocopayErrorCode.NO_PAYMENT_HISTORY_FOUND, "No payment found for Account ID : " + id);
		}
		return payments;
	}

}
