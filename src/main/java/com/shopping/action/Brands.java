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

@Path("/brandService")
public class Brands {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public BrandTo getTrackInJSON() {

		BrandTo brandTo = new BrandTo();
		brandTo.setBrandNameEng("brandNameEng");
		return brandTo;
	}

	// BRAND INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertBrand(BrandTo brandTo,
			@Context HttpServletRequest request) {
		try {
//			brandTo = ShoppingCartFactory.getBrandDao().insert(
//					brandTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			brandTo = ShoppingCartFactory.getBrandDao().insert(
					brandTo,1);
			
			return Response.status(201).entity(brandTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// BRAND UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateBrand(BrandTo brandTo,
			@Context HttpServletRequest request) {
		try {
//			brandTo = ShoppingCartFactory.getBrandDao().update(
//					brandTo.getId(),
//					brandTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			brandTo = ShoppingCartFactory.getBrandDao().update(
					brandTo.getId(),
					brandTo,1);
			return Response.status(201).entity(brandTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// BRAND GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllBrands(@Context HttpServletRequest request) {
		try {
			Collection<BrandTo> brandTo = new ArrayList<BrandTo>();
			brandTo = ShoppingCartFactory.getBrandDao().getAll();
			return Response.status(201).entity(brandTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// BRAND SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchBrands(BrandTo brandTo,
			@Context HttpServletRequest request) {
		try {
			brandTo = ShoppingCartFactory.getBrandDao().searchById(
					brandTo.getId());
			return Response.status(201).entity(brandTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}
	
	//Brand Search By Name
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/searchByName")
    public Response searchBrands(@QueryParam("brnadName") String brnadName,@QueryParam("pageNumber") int pageNumber,
                    @QueryParam("pageSize") int pageSize,@Context HttpServletRequest request) {
            try {
                    Collection<BrandTo> brandTo = new ArrayList<BrandTo>();
                    brandTo = ShoppingCartFactory.getBrandDao().searchByName(brnadName, pageNumber, pageSize);
                    return Response.status(201).entity(brandTo).build();
            } catch (Exception  e) {
                    e.printStackTrace();
                    String error = "Unable to Find Record";
                    return Response.status(403).entity(error).build();
            }
    }

	// BRAND DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteBrand(BrandTo brandTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getBrandDao().delete(brandTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}
}
