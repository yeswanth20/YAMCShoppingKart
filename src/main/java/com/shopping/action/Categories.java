package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
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
		
		// CATEGORY INSERT
		@POST
		@Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
		@Path("/insert") 
		public Response insertCategory(CategoriesTo categoriesTo,@Context HttpServletRequest request){
			try 
			{
				categoriesTo=ShoppingCartFactory.getCategoriesDao().insert(categoriesTo,12);
				categoriesTo.setStatusMsg("sucess");
				return Response.status(201).entity(categoriesTo).build();	
			}
			catch (Exception e)
			{
			e.printStackTrace();
			String error = "ConstraintViolationException";
			categoriesTo.setStatusMsg(error);
			return Response.status(403).entity(error).build();
			}
		}
		
		// UNIT UPDATE
		@POST
		@Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
		@Path("/update") 
		public Response updateUnits(CategoriesTo categoriesTo,@Context HttpServletRequest request){
			try 
			{
				categoriesTo=ShoppingCartFactory.getCategoriesDao().update(categoriesTo.getId(),categoriesTo,12);
				categoriesTo.setStatusMsg("sucess");
				return Response.status(201).entity(categoriesTo).build();	
			}
			catch (Exception e)
			{
			e.printStackTrace();
			String error = "ConstraintViolationException";
			categoriesTo.setStatusMsg(error);
			return Response.status(403).entity(error).build();
			}
		}
		// UNITS GET ALL
		@POST
		@Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
		@Path("/getAll") 
		public Response getAllUnits(@Context HttpServletRequest request){
			try 
			{
				Collection<CategoriesTo> categoriesTo = new ArrayList<CategoriesTo>();
				categoriesTo=ShoppingCartFactory.getCategoriesDao().getAll();
				return Response.status(201).entity(categoriesTo).build();	
			}
			catch (Exception e)
			{
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
		public Response searchUnits(CategoriesTo categoriesTo,@Context HttpServletRequest request){
			try 
			{
				categoriesTo=ShoppingCartFactory.getCategoriesDao().searchById(categoriesTo.getId());
				return Response.status(201).entity(categoriesTo).build();	
			}
			catch (Exception e)
			{
			e.printStackTrace();
			String error = "Unable to Find Reord";
			return Response.status(403).entity(error).build();
			}
		}
		

	}
