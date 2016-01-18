package com.npixels.mockingjay.exception;

public class JsonTransformationException extends RuntimeException
{
    public JsonTransformationException()
    {
    }

    public JsonTransformationException(String message)
    {
        super(message);
    }

    public JsonTransformationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public JsonTransformationException(Throwable cause)
    {
        super(cause);
    }

    public JsonTransformationException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
