package com.cgpack5.exception;

public class AdminCreationException extends Exception {
	public AdminCreationException()
	{
		super();
	}
	public AdminCreationException(String errorMsg)
	{
		super(errorMsg);
	}
}
