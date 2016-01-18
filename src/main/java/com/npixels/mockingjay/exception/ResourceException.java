package com.npixels.mockingjay.exception;

import com.npixels.mockingjay.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author Raja Vobugari
 */
public class ResourceException extends WebApplicationException {

    /**
     * Creates an instance of ResourceException.
     *
     * @param cause Throwable cause for this exception. The String value returned by
     *              cause.getMessage become the value of field "message" in the response
     *              body.
     * @param status HTTP status code. Becomes the HTTP status code of the response.
     * @param code Alphanumeric code of this exception. Becomes the value of the field
     *             "code" in the response body.
     */
    public ResourceException(Throwable cause, int status, String code)
    {
        super(Response.status(status)
                .entity(new ErrorDTO(code, cause.getMessage()))
                .build());
    }
}
