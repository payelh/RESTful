package com.pocopay.springmvc.mapper;

import java.util.List;

import com.pocopay.springmvc.model.Account;

public interface AccountMapper {
	
	Account getAccountByName(String name);
	
	Account getAccountByID(Long id);
	
	List<Account> getAllAccounts();
	
	void createAccount(Account account);

	void updateAccountBalance(Account account);

	void deleteAccount(Integer userId);	
}
