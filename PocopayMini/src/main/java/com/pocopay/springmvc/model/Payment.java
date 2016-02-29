package com.pocopay.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Payment Model Class
 * @author Sarker
 * @version 1.0
 * @since February 2016
 */

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 2896769180957219830L;
	
	private Long paymentID;	
	private Long srcAccountID;
	private long destAccountID;
	private BigDecimal paymentAmount;
	private String paymentReference;	
	private LocalDateTime transactionTime; 
	
	public Long getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}
	public Long getSrcAccountID() {
		return srcAccountID;
	}
	public void setSrcAccountID(Long srcAccountID) {
		this.srcAccountID = srcAccountID;
	}
	public long getDestAccountID() {
		return destAccountID;
	}
	public void setDestAccountID(long destAccountID) {
		this.destAccountID = destAccountID;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	
	public void setTransactionTime(Timestamp timestamp) // Used Timestamp instead LocalDateTime, cause mybatis yet doesn't support Java 8 LocalDateTime 
	{
		this.transactionTime = timestamp.toLocalDateTime();
	}
	
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", srcAccountID="
				+ srcAccountID + ", destAccountID=" + destAccountID
				+ ", paymentAmount=" + paymentAmount + ", paymentReference="
				+ paymentReference + ", transactionTime=" + transactionTime
				+ "]";
	}	
}
