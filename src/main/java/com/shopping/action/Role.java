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
import com.shopping.to.RoleTo;

@Path("/roleService")
public class Role {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public RoleTo getRoleJSON() {

		RoleTo roleTo = new RoleTo();
		roleTo.setRoleName("roleName");
		return roleTo;
	}

	// ROLE INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertRole(RoleTo roleTo,
			@Context HttpServletRequest request) {
		try {
//			roleTo = ShoppingCartFactory.getRoleDao().insert(
//					roleTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			roleTo = ShoppingCartFactory.getRoleDao().insert(roleTo, 1);
			return Response.status(201).entity(roleTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// ROLE UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateRole(RoleTo roleTo,
			@Context HttpServletRequest request) {
		try {
//			roleTo = ShoppingCartFactory.getRoleDao().update(roleTo.getId(),
//					roleTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			roleTo = ShoppingCartFactory.getRoleDao().update(roleTo.getId(),
					roleTo, 1);
			return Response.status(201).entity(roleTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// ROLE GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllCities(@Context HttpServletRequest request) {
		try {
			Collection<RoleTo> roleTo = new ArrayList<RoleTo>();
			roleTo = ShoppingCartFactory.getRoleDao().getAll();
			return Response.status(201).entity(roleTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// ROLE SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchRole(RoleTo roleTo,
			@Context HttpServletRequest request) {
		try {
			roleTo = ShoppingCartFactory.getRoleDao().searchById(
					roleTo.getId());
			return Response.status(201).entity(roleTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}

	// ROLE DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteRole(RoleTo roleTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getRoleDao().delete(roleTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}

}
