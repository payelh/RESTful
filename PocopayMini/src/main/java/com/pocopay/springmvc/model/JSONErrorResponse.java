package com.pocopay.springmvc.model;

public class JSONErrorResponse {
	 
    private String requestedUrl;
    private int errorCode;
    private String message;
    private String helpLink;
	
    public String getRequestedUrl() {
		return requestedUrl;
	}
	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHelpLink() {
		return helpLink;
	}
	public void setHelpLink(String helpLink) {
		this.helpLink = helpLink;
	}   
    
}