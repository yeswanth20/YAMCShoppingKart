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
import com.shopping.to.CityTo;

@Path("/cityService")
public class City {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public CityTo getCityJSON() {

		CityTo cityTo = new CityTo();
		cityTo.setCityName("cityName");
		return cityTo;
	}

	// CITY INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertCity(CityTo cityTo,
			@Context HttpServletRequest request) {
		try {
//			cityTo = ShoppingCartFactory.getCityDao().insert(
//					cityTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			cityTo = ShoppingCartFactory.getCityDao().insert(cityTo, 1);
			return Response.status(201).entity(cityTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// CITY UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateCity(CityTo cityTo,
			@Context HttpServletRequest request) {
		try {
//			cityTo = ShoppingCartFactory.getCityDao().update(cityTo.getId(),
//					cityTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			cityTo = ShoppingCartFactory.getCityDao().update(cityTo.getId(),
					cityTo, 1);
			return Response.status(201).entity(cityTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// CITY GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllCities(@Context HttpServletRequest request) {
		try {
			Collection<CityTo> cityTo = new ArrayList<CityTo>();
			cityTo = ShoppingCartFactory.getCityDao().getAll();
			return Response.status(201).entity(cityTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// CITY SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchCity(CityTo cityTo,
			@Context HttpServletRequest request) {
		try {
			cityTo = ShoppingCartFactory.getCityDao().searchById(
					cityTo.getId());
			return Response.status(201).entity(cityTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}

	// CITY DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteCity(CityTo cityTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getCityDao().delete(cityTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}

}
