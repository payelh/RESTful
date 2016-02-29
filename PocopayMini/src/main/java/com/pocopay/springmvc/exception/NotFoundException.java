package com.pocopay.springmvc.exception;

/**
 * Custom Exception to trhow, when there is already same account in System.
 * 
 * @author Sarker
 * @version 1.0
 */

public class NotFoundException extends RuntimeException {
		
	private static final long serialVersionUID = 5387493797752592337L;	
	
	private int internalErrorCode;
    public NotFoundException(int internalErrorCode, String msg){
        super(msg);
        this.internalErrorCode = internalErrorCode;
    }
	public int getInternalErrorCode() {
		return internalErrorCode;
	}    
}
