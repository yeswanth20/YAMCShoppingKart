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
import com.shopping.to.CategoriesTo;

@Path("/categoryService")
public class Categories {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriesTo getTrackInJSON() {
		CategoriesTo categoriesTo = new CategoriesTo();
		categoriesTo.setCategoryNameEng("categoryNameEng");
		return categoriesTo;
	}

	// CATEGORY INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertCategory(CategoriesTo categoriesTo,
			@Context HttpServletRequest request) {
		try {
			categoriesTo = ShoppingCartFactory.getCategoriesDao().insert(
					categoriesTo,
					Integer.parseInt(request.getSession()
							.getAttribute("userId").toString()));
			return Response.status(201).entity(categoriesTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// UNIT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateCategory(CategoriesTo categoriesTo,
			@Context HttpServletRequest request) {
		try {
			categoriesTo = ShoppingCartFactory.getCategoriesDao().update(
					categoriesTo.getId(),
					categoriesTo,
					Integer.parseInt(request.getSession()
							.getAttribute("userId").toString()));
			return Response.status(201).entity(categoriesTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	// UNITS GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllCategory(@Context HttpServletRequest request) {
		try {
			Collection<CategoriesTo> categoriesTo = new ArrayList<CategoriesTo>();
			categoriesTo = ShoppingCartFactory.getCategoriesDao().getAll();
			return Response.status(201).entity(categoriesTo).build();
		} catch (Exception e) {
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
	public Response searchCategory(CategoriesTo categoriesTo,
			@Context HttpServletRequest request) {
		try {
			categoriesTo = ShoppingCartFactory.getCategoriesDao().searchById(
					categoriesTo.getId());
			return Response.status(201).entity(categoriesTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Reord";
			return Response.status(403).entity(error).build();
		}
	}

}
