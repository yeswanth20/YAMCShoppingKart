package com.shopping.action;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.BrandTo;

@Path("/brandService")
public class Brand {

	// BRAND INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert") 
	public Response insertBrand(BrandTo brandTo,@Context HttpServletRequest request){
		try 
		{
//			brandTo=ShoppingCartFactory.getBrandDao().insert(brandTo);
			brandTo=ShoppingCartFactory.getBrandDao().insert(brandTo, 1);
			return Response.status(201).entity(brandTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "ConstraintViolationException";
		brandTo.setStatusMsg(error);
		return Response.status(403).entity(error).build();
		}
	}
}
