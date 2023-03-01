package com.study.handler.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.study.ErrorResponse;
import com.study.exception.DataAlreadyExistsException;
import com.study.exception.NoDataFoundException;
import com.study.exception.ParameterException;
import com.study.exception.UserNotActiveException;
import com.study.exception.UserRoleException;

import jakarta.el.MethodNotFoundException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler( Exception.class )
	@ResponseStatus( HttpStatus.BAD_REQUEST )
	public @ResponseBody ErrorResponse handleException( Exception ex ) {
		return new ErrorResponse( HttpStatus.BAD_REQUEST.value(), "There's a problem with the proccess.");
	}
	
	@ExceptionHandler( DataAlreadyExistsException.class )
	@ResponseStatus( HttpStatus.CONFLICT )
	public @ResponseBody ErrorResponse handleException( DataAlreadyExistsException ex ) {
		return new ErrorResponse( HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	@ExceptionHandler( MethodNotFoundException.class )
	@ResponseStatus( HttpStatus.METHOD_NOT_ALLOWED )
	public @ResponseBody ErrorResponse handleException( MethodNotFoundException ex ) {
		return new ErrorResponse( HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
	}
	
	@ExceptionHandler( HttpRequestMethodNotSupportedException.class )
	@ResponseStatus( HttpStatus.METHOD_NOT_ALLOWED )
	public @ResponseBody ErrorResponse handleException( HttpRequestMethodNotSupportedException ex ) {
		return new ErrorResponse( HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage());
	}
	
	@ExceptionHandler( NoDataFoundException.class )
	@ResponseStatus( HttpStatus.BAD_REQUEST )
	public @ResponseBody ErrorResponse handleException( NoDataFoundException ex ) {
		return new ErrorResponse( HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	@ExceptionHandler( ParameterException.class )
	@ResponseStatus( HttpStatus.BAD_REQUEST )
	public @ResponseBody ErrorResponse handleException( ParameterException ex ) {
		return new ErrorResponse( HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	@ExceptionHandler( DataIntegrityViolationException.class )
	@ResponseStatus( HttpStatus.BAD_REQUEST )
	public @ResponseBody ErrorResponse handleException( DataIntegrityViolationException ex ) {
		return new ErrorResponse( HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
	
	@ExceptionHandler( UserRoleException.class )
	@ResponseStatus( HttpStatus.FORBIDDEN )
	public @ResponseBody ErrorResponse handleException( UserRoleException ex ) {
		return new ErrorResponse( HttpStatus.FORBIDDEN.value(), ex.getMessage());
	}
	
	@ExceptionHandler( UserNotActiveException.class )
	@ResponseStatus( HttpStatus.FORBIDDEN )
	public @ResponseBody ErrorResponse handleException( UserNotActiveException ex ) {
		return new ErrorResponse( HttpStatus.FORBIDDEN.value(), ex.getMessage());
	}
	
	
}
