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
import com.shopping.to.UsersTo;

@Path("/userService")
public class Users {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public UsersTo getTrackInJSON() {

		UsersTo usersTo = new UsersTo();
		usersTo.setUserName("userName");
		usersTo.setPassword("password");
		return usersTo;
	}


	// USER INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertUnits(UsersTo usersTo,
			@Context HttpServletRequest request) {
		try {
//			usersTo = ShoppingCartFactory.getUserDao().insert(
//					unitTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			usersTo = ShoppingCartFactory.getUserDao().insert(usersTo, 1);
			return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// USER UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateUnits(UsersTo usersTo,
			@Context HttpServletRequest request) {
		try {
//			usersTo = ShoppingCartFactory.getUserDao().update(usersTo.getId(),
//					usersTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			usersTo = ShoppingCartFactory.getUserDao().update(usersTo.getId(),
					usersTo, 1);
			return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// USER GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllUnits(@Context HttpServletRequest request) {
		try {
			Collection<UsersTo> usersTo = new ArrayList<UsersTo>();
			usersTo = ShoppingCartFactory.getUserDao().getAll();
			return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// USER SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchUnits(UsersTo usersTo,
			@Context HttpServletRequest request) {
		try {
			usersTo = ShoppingCartFactory.getUserDao().searchById(
					usersTo.getId());
			return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}

	// USER DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteUnits(UsersTo usersTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getUserDao().delete(usersTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}

}
