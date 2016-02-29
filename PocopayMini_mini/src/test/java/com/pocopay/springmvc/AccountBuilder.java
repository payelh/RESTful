package com.pocopay.springmvc;

import java.math.BigDecimal;

import com.pocopay.springmvc.model.Account;

public class AccountBuilder {
	private Account account = new Account();

	public AccountBuilder id(long id) {
		account.setAccountID(id);
		return this;
	}

	public AccountBuilder name(String name) {
		account.setOwnerName(name);
		return this;
	}

	public AccountBuilder dob(String dob) {
		account.setDateOfBirth(dob);
		return this;
	}

	public AccountBuilder balance(BigDecimal balance) {
		account.setAccountBalance(balance);
		return this;
	}

	public Account build() {
		return account;
	}
}
