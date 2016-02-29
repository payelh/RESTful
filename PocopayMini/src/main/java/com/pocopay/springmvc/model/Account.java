package com.pocopay.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Account Model Class
 * @author Sarker
 * @version 1.0
 * @since February 2016
 */

public class Account implements Serializable{
	
	private static final long serialVersionUID = -2705181522773000951L;
	private Long accountID;
	private String ownerName;
	private String dateOfBirth;
	private BigDecimal accountBalance;
	public Long getAccountID() {
		return accountID;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", ownerName=" + ownerName
				+ ", dateOfBirth=" + dateOfBirth + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	
		
}
