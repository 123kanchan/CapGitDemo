package com.cgpack5.exception;


/*
 * postman acts as client
 * request
 * 
 * 
 * response
 * Rest Service ascts as server
 * 
 * 
 * 
 * 
 */

public class InvalidTrainException  extends Exception{
	public InvalidTrainException()
	{
		super();
	}
	public InvalidTrainException(String errorMsg)
	{
		super(errorMsg);
	}

}
