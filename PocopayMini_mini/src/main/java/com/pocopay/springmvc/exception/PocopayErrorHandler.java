package com.pocopay.springmvc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pocopay.springmvc.model.JSONErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ControllerAdvice
public class PocopayErrorHandler {
	private static final Logger logger = LoggerFactory.getLogger(PocopayErrorHandler.class);
	
	   // Handle Conflicting Request Exception	-- 409	
		@ExceptionHandler(ConflictRequestException.class)
		@ResponseStatus(value = HttpStatus.CONFLICT)		  
		public @ResponseBody JSONErrorResponse handleConflictException(HttpServletRequest request, ConflictRequestException ex){
			logger.warn("Error Handler -> handleConflictException() ->  " + ex.toString());
			JSONErrorResponse jsonResponse = new JSONErrorResponse();
		    jsonResponse.setRequestedUrl(request.getRequestURL().toString());
		    jsonResponse.setErrorCode(ex.getInternalErrorCode());
		    jsonResponse.setMessage(ex.getMessage());
		    jsonResponse.setHelpLink("http://pocopaymin.com/devSupport/"+ex.getInternalErrorCode()); //You may provide a link for developer support
		    return jsonResponse;	    
		}
			
		//Handle Forbidden Request Exception -- 403	
		@ExceptionHandler(ForbiddenRequestException.class)
		@ResponseStatus(value = HttpStatus.FORBIDDEN)		  
		public @ResponseBody JSONErrorResponse handleForbiddenRequestException(HttpServletRequest request, ForbiddenRequestException ex){
			logger.warn("Error Handler -> handleForbiddenRequestException() ->  " + ex.toString());
		    JSONErrorResponse jsonResponse = new JSONErrorResponse();
		    jsonResponse.setRequestedUrl(request.getRequestURL().toString());
		    jsonResponse.setErrorCode(ex.getInternalErrorCode());
		    jsonResponse.setMessage(ex.getMessage());
		    jsonResponse.setHelpLink("http://pocopaymin.com/devSupport/"+ex.getInternalErrorCode()); //You may provide a link for developer support
		    return jsonResponse;	    
		}		
		
		//Handle Not Found Exception -- 404		
		@ExceptionHandler(NotFoundException.class)
		@ResponseStatus(value = HttpStatus.NOT_FOUND)		  
		public @ResponseBody JSONErrorResponse handleNotFoundException(HttpServletRequest request, NotFoundException ex){
			logger.warn("Error Handler -> handleNotFoundException() ->  " + ex.toString());
			JSONErrorResponse jsonResponse = new JSONErrorResponse();
		    jsonResponse.setRequestedUrl(request.getRequestURL().toString());
		    jsonResponse.setErrorCode(ex.getInternalErrorCode());
		    jsonResponse.setMessage(ex.getMessage());
		    jsonResponse.setHelpLink("http://pocopaymin.com/devSupport/"+ex.getInternalErrorCode()); //You may provide a link for developer support
		    return jsonResponse;	    
		}		
		
		//Handle Content Found Exception -- 204		
		@ExceptionHandler(ContentNotFoundException.class)
		@ResponseStatus(value = HttpStatus.NO_CONTENT)		  
		public @ResponseBody JSONErrorResponse handleContentNotFoundException(HttpServletRequest request, ContentNotFoundException ex){
			logger.warn("Error Handler -> handleContentNotFoundException() ->  " + ex.toString());
			JSONErrorResponse jsonResponse = new JSONErrorResponse();
		    jsonResponse.setRequestedUrl(request.getRequestURL().toString());
		    jsonResponse.setErrorCode(ex.getInternalErrorCode());
		    jsonResponse.setMessage(ex.getMessage());
		    jsonResponse.setHelpLink("http://pocopaymin.com/devSupport/"+ex.getInternalErrorCode()); //You may provide a link for developer support
		    return jsonResponse;	    
		}	
	}
