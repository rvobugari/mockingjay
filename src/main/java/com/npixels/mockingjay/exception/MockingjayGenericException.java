package com.npixels.mockingjay.exception;


public class MockingjayGenericException extends RuntimeException
{
    public MockingjayGenericException()
    {
    }

    public MockingjayGenericException(String message)
    {
        super(message);
    }

    public MockingjayGenericException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MockingjayGenericException(Throwable cause)
    {
        super(cause);
    }

    public MockingjayGenericException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
