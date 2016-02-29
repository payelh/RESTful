package com.pocopay.springmvc.exception;

/**
 * Custom Exception to trhow, when there is already same account in System.
 * 
 * @author Sarker
 * @version 1.0
 */

public class ContentNotFoundException extends RuntimeException {
		
	private static final long serialVersionUID = 2575298155813428435L;
	private int internalErrorCode;
    public ContentNotFoundException(int internalErrorCode, String msg){
        super(msg);
        this.internalErrorCode = internalErrorCode;
    }
	public int getInternalErrorCode() {
		return internalErrorCode;
	}    
}
