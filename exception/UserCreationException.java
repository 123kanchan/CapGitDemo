package com.cgpack5.exception;

public class UserCreationException extends Exception {
	public UserCreationException()
	{
		super();
	}
	public UserCreationException(String errorMsg)
	{
		super(errorMsg);
	}
	
}
