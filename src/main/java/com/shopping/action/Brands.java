package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

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
public class Brands {

	// BRAND INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert") 
	public Response insertBrand(BrandTo brandTo,@Context HttpServletRequest request){
		try 
		{
			brandTo=ShoppingCartFactory.getBrandDao().insert(brandTo, 1);
			brandTo.setStatusMsg("sucess");
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
	
	
	// UNIT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/update") 
	public Response updateBrand(BrandTo brandTo,@Context HttpServletRequest request){
		try 
		{
			brandTo=ShoppingCartFactory.getBrandDao().update(brandTo.getId(),brandTo,4);
			brandTo.setStatusMsg("sucess");
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
	// UNITS GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll") 
	public Response getAllUnits(@Context HttpServletRequest request){
		try 
		{
			Collection<BrandTo> brandTo = new ArrayList<BrandTo>();
			brandTo=ShoppingCartFactory.getBrandDao().getAll();
			return Response.status(201).entity(brandTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "Unable to Find Reords";
		return Response.status(403).entity(error).build();
		}
	}
	
	// UNITS SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/search") 
	public Response searchUnits(BrandTo brandTo,@Context HttpServletRequest request){
		try 
		{
			brandTo=ShoppingCartFactory.getBrandDao().searchById(brandTo.getId());
			return Response.status(201).entity(brandTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "Unable to Find Reord";
		return Response.status(403).entity(error).build();
		}
	}
	
}
