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
import com.shopping.to.ScreensUrlTo;

@Path("/screenUrlService")
public class ScreenUrls {
	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ScreensUrlTo getScreenUrls() {

		ScreensUrlTo screensUrlTo = new ScreensUrlTo();
		screensUrlTo.setScreenName("screenName");
		screensUrlTo.setScreenUrl("URLS");
		return screensUrlTo;
	}


	// ScreenUrls INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertScreenUrls(ScreensUrlTo screensUrlTo,
			@Context HttpServletRequest request) {
		try {
			screensUrlTo = ShoppingCartFactory.getScreenUrlDao().insert(
					screensUrlTo);
			return Response.status(201).entity(screensUrlTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// ScreenUrls GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllScreenUrls(@Context HttpServletRequest request) {
		try {
			Collection<String> screenUrls = new ArrayList<String>();
			screenUrls = ShoppingCartFactory.getScreenUrlDao().getAll();
			return Response.status(201).entity(screenUrls).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}
}
