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
import com.shopping.to.WeightsTo;

@Path("/weightService")
public class Weights {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public WeightsTo getTrackInJSON() {

		WeightsTo weightsTo = new WeightsTo();
		weightsTo.setWeightName("weightName");
		weightsTo.setUnit(12);
		return weightsTo;
	}

	// WEIGHT INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertWeights(WeightsTo weightsTo,
			@Context HttpServletRequest request) {
		try {
//			weightsTo = ShoppingCartFactory.getWeightsDao().insert(
//					weightsTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			weightsTo = ShoppingCartFactory.getWeightsDao().insert(
					weightsTo,1);
			return Response.status(201).entity(weightsTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// WEIGHT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateWeight(WeightsTo weightsTo,
			@Context HttpServletRequest request) {
		try {
//			weightsTo = ShoppingCartFactory.getWeightsDao().update(
//					weightsTo.getId(),
//					weightsTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			weightsTo = ShoppingCartFactory.getWeightsDao().update(
					weightsTo.getId(),
					weightsTo,1);
			
			return Response.status(201).entity(weightsTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// WEIGHTS GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllWeights(@Context HttpServletRequest request) {
		try {
			Collection<WeightsTo> weightsTo = new ArrayList<WeightsTo>();
			weightsTo = ShoppingCartFactory.getWeightsDao().getAll();
			return Response.status(201).entity(weightsTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Reords";
			return Response.status(403).entity(error).build();
		}
	}

	// WEIGHT SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchWeight(WeightsTo weightsTo,
			@Context HttpServletRequest request) {
		try {
			weightsTo = ShoppingCartFactory.getWeightsDao().searchById(
					weightsTo.getId());
			return Response.status(201).entity(weightsTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Reord";
			return Response.status(403).entity(error).build();
		}
	}
	
	// WEIGHT DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteUnits(WeightsTo weightsTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getWeightsDao().delete(weightsTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}

}
