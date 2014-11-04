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
import com.shopping.to.DiscountTypeTo;

@Path("/discountTypeService")
public class DiscountType {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public DiscountTypeTo getTrackInJSON() {
		DiscountTypeTo discountTypeTo = new DiscountTypeTo();
		discountTypeTo.setDiscountName("discountName");
		return discountTypeTo;
	}

	// DiscountType INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertDiscountType(DiscountTypeTo discountTypeTo,
			@Context HttpServletRequest request) {
		try {
//			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao().insert(
//					discountTypeTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao().insert(
					discountTypeTo,1);
			
			return Response.status(201).entity(discountTypeTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// DiscountType UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateDiscountType(DiscountTypeTo discountTypeTo,
			@Context HttpServletRequest request) {
		try {
//			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao().update(
//					discountTypeTo.getId(),
//					discountTypeTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao().update(
					discountTypeTo.getId(),
					discountTypeTo,1);
			
			return Response.status(201).entity(discountTypeTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// DiscountType GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllDiscountType(@Context HttpServletRequest request) {
		try {
			Collection<DiscountTypeTo> discountTypeTo = new ArrayList<DiscountTypeTo>();
			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao().getAll();
			return Response.status(201).entity(discountTypeTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Reords";
			return Response.status(403).entity(error).build();
		}
	}

	// DiscountType SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchDiscountType(DiscountTypeTo discountTypeTo,
			@Context HttpServletRequest request) {
		try {
			discountTypeTo = ShoppingCartFactory.getDiscountTypeDao()
					.searchById(discountTypeTo.getId());
			return Response.status(201).entity(discountTypeTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Reord";
			return Response.status(403).entity(error).build();
		}
	}
}
