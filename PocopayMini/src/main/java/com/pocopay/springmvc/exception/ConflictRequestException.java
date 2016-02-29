package com.pocopay.springmvc.exception;

/**
 * Custom Exception to trhow, when there is already same account in System.
 * 
 * @author Sarker
 * @version 1.0
 */

public class ConflictRequestException extends RuntimeException {
	
	private static final long serialVersionUID = -8657609008878558793L;	
	private int internalErrorCode;
    public ConflictRequestException(int internalErrorCode, String msg){
        super(msg);
        this.internalErrorCode = internalErrorCode;
    }
	public int getInternalErrorCode() {
		return internalErrorCode;
	}    
}
