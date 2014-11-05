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
import com.shopping.orm.UserOrm;
import com.shopping.to.ProductTo;

@Path("/productService")
public class Product {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductTo getTrackInJSON() {

		ProductTo productTo = new ProductTo();

		productTo.setProductNameEng("productNameEng");
		productTo.setCreatedBy(new UserOrm().getCreatedBy());
		productTo.setModifiedBy(new UserOrm().getModifiedBy());
		productTo.setStockAvailable(true);
		return productTo;
	}

	// PRODUCT INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertProduct(ProductTo productTo,
			@Context HttpServletRequest request) {
		try {
//			productTo = ShoppingCartFactory.getProductDao().insert(
//					productTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			productTo = ShoppingCartFactory.getProductDao().insert(
					productTo,1);
			
			return Response.status(201).entity(productTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// PRODUCT UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateProduct(ProductTo productTo,
			@Context HttpServletRequest request) {
		try {
//			productTo = ShoppingCartFactory.getProductDao().update(
//					productTo.getId(),
//					productTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			
			productTo = ShoppingCartFactory.getProductDao().update(
					productTo.getId(),
					productTo,1);
			
			return Response.status(201).entity(productTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// PRODUCT GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllProducts(@Context HttpServletRequest request) {
		try {
			Collection<ProductTo> productTo = new ArrayList<ProductTo>();
			productTo = ShoppingCartFactory.getProductDao().getAll();
			return Response.status(201).entity(productTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// PRODUCT SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchProducts(ProductTo productTo,
			@Context HttpServletRequest request) {
		try {
			productTo = ShoppingCartFactory.getProductDao().searchById(
					productTo.getId());
			return Response.status(201).entity(productTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}
	
	// PRODUCT DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteUnits(ProductTo productTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getProductDao().delete(productTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}

}
