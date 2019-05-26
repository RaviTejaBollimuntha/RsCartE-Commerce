package com.rscart.exception;

/**
 * @author Raviteja Bollimuntha
 *
 */
public class RsCartException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public RsCartException()
	{
		super();
	}

	public RsCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RsCartException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RsCartException(String message)
	{
		super(message);
	}

	public RsCartException(Throwable cause)
	{
		super(cause);
	}
	
}
