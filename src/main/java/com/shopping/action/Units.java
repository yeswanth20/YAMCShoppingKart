package com.shopping.action;

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

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(UnitsTo unitTo) {
		String result =  "Track saved : " + unitTo.getUnitName();
		return Response.status(201).entity(result).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUnit") 
	public Response insertUnits(UnitsTo unitTo,@Context HttpServletRequest request){
		try 
		{
			unitTo=ShoppingCartFactory.getUnitsDao().insert(unitTo);
			unitTo.setStatusMsg("sucess");
						
			return Response.status(201).entity(unitTo).build();	
		}
		catch (Exception e)
		{
		e.printStackTrace();
		String error = "ConstraintViolationException";
		unitTo.setStatusMsg(error);
		return Response.status(201).entity(error).build();
		}
	}

}
