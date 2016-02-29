package com.pocopay.springmvc.constants;

public class PocopayErrorCode {

	// First 3 digit HTTP error code, next 3 for internal usage.
	public static final int INTERNAL_ERROR = 500900;	
	
	//204 -- Content Not Found
	
	public static final int NO_PAYMENT_HISTORY_FOUND = 204901;
	
	//404 -- Not Found
	public static final int ACCOUNT_NOT_FOUND = 404901;
	public static final int SOURCE_ACCOUNT_NOT_FOUND = 404902;
	public static final int DESTINATION_ACCOUNT_NOT_FOUND = 404903;
	public static final int NO_PAYMENT_FOUND_WITH_ID = 404904;
	
	//403 -- Forbidden
	public static final int INSUFFICIENT_TRANSACTION_BALANCE = 403903;	
	public static final int NEGATIVE_BALANCE_TRANSACTION_REQUESTED = 403904;
	
	//409 -- Conflict
	public static final int ACCOUNT_ALREADY_EXISTS = 409905;
	
	
	
	
}
