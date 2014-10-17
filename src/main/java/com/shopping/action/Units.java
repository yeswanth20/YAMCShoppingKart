package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.UnitsTo;


@Path("/unitService")
public class Units {
	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public UnitsTo getTrackInJSON() {

		UnitsTo unitTo = new UnitsTo();
		unitTo.setUnitName("unitName");
		unitTo.setStatusMsg("status");
		unitTo.setCreatedBy(1);
		unitTo.setModifiedBy(1);
		return unitTo;
	}

	// POST TESTING
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(UnitsTo unitTo) {
		String result =  "Track saved : " + unitTo.getUnitName();
		return Response.status(201).entity(result).build();
		
	}
	
	// UNIT INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert") 
	public Response insertUnits(UnitsTo unitTo,@Context HttpServletRequest request){
		try 
		{
			unitTo=ShoppingCartFactory.getUnitsDao().insert(unitTo,12);
			unitTo.setStatusMsg("sucess");
			return Response.status(201).entity(unitTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "ConstraintViolationException";
		unitTo.setStatusMsg(error);
		return Response.status(403).entity(error).build();
		}
	}
	
	// UNIT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/update") 
	public Response updateUnits(UnitsTo unitTo,@Context HttpServletRequest request){
		try 
		{
			unitTo=ShoppingCartFactory.getUnitsDao().update(unitTo.getId(),unitTo,4);
			unitTo.setStatusMsg("sucess");
			return Response.status(201).entity(unitTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "ConstraintViolationException";
		unitTo.setStatusMsg(error);
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
			Collection<UnitsTo> unitTo = new ArrayList<UnitsTo>();
			unitTo=ShoppingCartFactory.getUnitsDao().getAll();
			return Response.status(201).entity(unitTo).build();	
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
	public Response searchUnits(UnitsTo unitTo,@Context HttpServletRequest request){
		try 
		{
			unitTo=ShoppingCartFactory.getUnitsDao().searchById(unitTo.getId());
			return Response.status(201).entity(unitTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "Unable to Find Reord";
		return Response.status(403).entity(error).build();
		}
	}
	

}
