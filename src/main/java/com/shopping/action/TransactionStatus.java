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
import com.shopping.to.TransactionStatusTo;

@Path("/transactionStatusService")
public class TransactionStatus {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionStatusTo getTransactionStatusJSON() {

		TransactionStatusTo transactionStatusTo = new TransactionStatusTo();
		transactionStatusTo.setStatusName("statusName");
		return transactionStatusTo;
	}

	// TransactionStatus INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertTransactionStatus(TransactionStatusTo transactionStatusTo,
			@Context HttpServletRequest request) {
		try {
//			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().insert(
//					transactionStatusTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().insert(transactionStatusTo, 1);
			return Response.status(201).entity(transactionStatusTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Failed to Insert";
			return Response.status(403).entity(error).build();
		}
	}

	// TransactionStatus UPDATE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateTransactionStatus(TransactionStatusTo transactionStatusTo,
			@Context HttpServletRequest request) {
		try {
//			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().update(transactionStatusTo.getId(),
//					transactionStatusTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().update(transactionStatusTo.getId(),
					transactionStatusTo, 1);
			return Response.status(201).entity(transactionStatusTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Faild to Update";
			return Response.status(403).entity(error).build();
		}
	}

	// TransactionStatus GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllTransactionStatus(@Context HttpServletRequest request) {
		try {
			Collection<TransactionStatusTo> transactionStatusTo = new ArrayList<TransactionStatusTo>();
			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().getAll();
			return Response.status(201).entity(transactionStatusTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}

	// TransactionStatus SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchTransactionStatus(TransactionStatusTo transactionStatusTo,
			@Context HttpServletRequest request) {
		try {
			transactionStatusTo = ShoppingCartFactory.getTransactionStatusDao().searchById(
					transactionStatusTo.getId());
			return Response.status(201).entity(transactionStatusTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}

	// TransactionStatus DELETE
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public Response deleteTransactionStatus(TransactionStatusTo transactionStatusTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getTransactionStatusDao().delete(transactionStatusTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}


}
