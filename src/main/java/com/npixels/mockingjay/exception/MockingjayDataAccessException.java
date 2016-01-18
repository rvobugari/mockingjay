package com.npixels.mockingjay.exception;


public class MockingjayDataAccessException extends RuntimeException
{
    public MockingjayDataAccessException()
    {
    }

    public MockingjayDataAccessException(String message)
    {
        super(message);
    }

    public MockingjayDataAccessException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MockingjayDataAccessException(Throwable cause)
    {
        super(cause);
    }

    public MockingjayDataAccessException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
