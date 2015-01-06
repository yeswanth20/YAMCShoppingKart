package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.BrandTo;
import com.shopping.to.UnitsTo;

@Path("/unitService")
public class Units {
	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public UnitsTo getUnitJSON() {

		UnitsTo unitTo = new UnitsTo();
		unitTo.setUnitName("unitName");
		return unitTo;
	}

	// POST TESTING
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUnitJSON(UnitsTo unitTo) {
		String result = "Unit Name Received : " + unitTo.getUnitName();
		return Response.status(201).entity(result).build();

	}

	// UNIT INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertUnits(UnitsTo unitTo,
			@Context HttpServletRequest request) {
		try {
//			unitTo = ShoppingCartFactory.getUnitsDao().insert(
//					unitTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			unitTo = ShoppingCartFactory.getUnitsDao().insert(
					unitTo,1);
			return Response.status(201).entity(unitTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// UNIT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateUnits(UnitsTo unitTo,
			@Context HttpServletRequest request) {
		try {
//			unitTo = ShoppingCartFactory.getUnitsDao().update(unitTo.getId(),
//					unitTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			unitTo = ShoppingCartFactory.getUnitsDao().update(unitTo.getId(),
					unitTo, 1);
			return Response.status(201).entity(unitTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// UNITS GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllUnits(@Context HttpServletRequest request) {
		try {
			Collection<UnitsTo> unitTo = new ArrayList<UnitsTo>();
			unitTo = ShoppingCartFactory.getUnitsDao().getAll();
			return Response.status(201).entity(unitTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// UNITS SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchUnits(UnitsTo unitTo,
			@Context HttpServletRequest request) {
		try {
			unitTo = ShoppingCartFactory.getUnitsDao().searchById(
					unitTo.getId());
			return Response.status(201).entity(unitTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}
	
	//UNITS Search By Name
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/searchByName")
    public Response searchBrands(@QueryParam("unitName") String unitName,@QueryParam("pageNumber") int pageNumber,
                    @QueryParam("pageSize") int pageSize,@Context HttpServletRequest request) {
            try {
                    Collection<UnitsTo> unitTo = new ArrayList<UnitsTo>();
                    unitTo = ShoppingCartFactory.getUnitsDao().searchByUnitName(unitName, pageNumber, pageSize);
                    return Response.status(201).entity(unitTo).build();
            } catch (Exception  e) {
                    e.printStackTrace();
                    String error = "Unable to Find Record";
                    return Response.status(403).entity(error).build();
            }
    }
	

	// UNITS DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteUnits(UnitsTo unitTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getUnitsDao().delete(unitTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}
}
