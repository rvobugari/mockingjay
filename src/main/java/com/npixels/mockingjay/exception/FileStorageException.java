package com.npixels.mockingjay.exception;

public class FileStorageException extends RuntimeException
{
    public FileStorageException()
    {
    }

    public FileStorageException(String message)
    {
        super(message);
    }

    public FileStorageException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileStorageException(Throwable cause)
    {
        super(cause);
    }

    public FileStorageException(String message, Throwable cause, boolean enableSuppression,
                               boolean stackTrace)
    {
        super(message, cause, enableSuppression, stackTrace);
    }
}
