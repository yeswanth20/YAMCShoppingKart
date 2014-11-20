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
import com.shopping.to.LanguageTo;

@Path("/languageService")
public class Language {
	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public LanguageTo getRoleJSON() {

		LanguageTo languageTo = new LanguageTo();
		languageTo.setLanguageName("languageName");
		return languageTo;
	}

	// LANGUAGE INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertRole(LanguageTo languageTo,
			@Context HttpServletRequest request) {
		try {
//			languageTo = ShoppingCartFactory.getLanguageDao().insert(
//					languageTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			languageTo = ShoppingCartFactory.getLanguageDao().insert(languageTo, 1);
			return Response.status(201).entity(languageTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// LANGUAGE UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateRole(LanguageTo languageTo,
			@Context HttpServletRequest request) {
		try {
//			languageTo = ShoppingCartFactory.getLanguageDao().update(languageTo.getId(),
//					languageTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			languageTo = ShoppingCartFactory.getLanguageDao().update(languageTo.getId(),
					languageTo, 1);
			return Response.status(201).entity(languageTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// LANGUAGE GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllCities(@Context HttpServletRequest request) {
		try {
			Collection<LanguageTo> languageTo = new ArrayList<LanguageTo>();
			languageTo = ShoppingCartFactory.getLanguageDao().getAll();
			return Response.status(201).entity(languageTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// LANGUAGE SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchRole(LanguageTo languageTo,
			@Context HttpServletRequest request) {
		try {
			languageTo = ShoppingCartFactory.getLanguageDao().searchById(
					languageTo.getId());
			return Response.status(201).entity(languageTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}

	// LANGUAGE DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteRole(LanguageTo languageTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getLanguageDao().delete(languageTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}


}
