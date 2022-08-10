package com.webservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class SimpleRESTService {
    @GET
    public String hello(@QueryParam("id") final Integer id) {
        if (id == null) 
        {
        	MyException ex=new MyException();
        	ex.setMessage("You need to pass an Id!");
        	throw ex;
        }
        
        return "Hello " +id;
    }
 
}