/**
 * 
 */
package com.group.expense.exception;

import com.group.expense.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author AKivanda
 *
 */
public class GenericException implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "Error");
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }
}
