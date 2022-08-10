package com.webservice.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.client.ClientResponse.Status;
@Provider
public class MyExceptionMapper  implements ExceptionMapper<MyException> {
     @Override
        public Response toResponse(MyException exception) 
        {
           // System.out.println(exception.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
        }
}