package com.pocopay.springmvc.exception;

//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.http.HttpStatus;	
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such account in Pocopay Systems")  // 404

/**
 * Custom Exception class which is used for Exception Handling
 * @author Sarker
 * @version 1.0
 */

public class ForbiddenRequestException extends RuntimeException {
		
	/**
	 * Unique ID for Serialized object
	 */
	private static final long serialVersionUID = -323640711996264449L;
	private int internalErrorCode;
    public ForbiddenRequestException(int internalErrorCode, String msg){
        super(msg);
        this.internalErrorCode = internalErrorCode;
    }
	public int getInternalErrorCode() {
		return internalErrorCode;
	}
		
}
