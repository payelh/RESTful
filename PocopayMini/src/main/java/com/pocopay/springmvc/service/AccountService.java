package com.pocopay.springmvc.service;

import java.util.List;

import com.pocopay.springmvc.model.Account;
import com.pocopay.springmvc.model.Payment;

public interface AccountService {

	//For CRUD operations
	Account getAccountByName(String name);
	
	Account getAccountByID(Long id);
	
	List<Account> getAllAccounts();
	
	void createAccount(Account account);

	void updateAccountBalance(Account account);

	void deleteUser(Integer userId);
	
	List<Payment> getAllPayemtnsBySourceAccountID(long id); 
	
	//Additional
	boolean isAccountExist(Account account);
	public int getTotalAccount();
	
	
}

