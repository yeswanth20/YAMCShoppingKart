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
import com.shopping.to.TransactionOrderTo;

@Path("/transactionOrderService")
public class TransactionOrder {

	// GET TESTING
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionOrderTo getTransactionOrderJSON() {

		TransactionOrderTo transactionOrderTo = new TransactionOrderTo();
		transactionOrderTo.setTxnOrderID("txnOrderID");
		return transactionOrderTo;
	}

	// TransactionStatus INSERT
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertTransactionOrder(TransactionOrderTo transactionOrderTo,
			@Context HttpServletRequest request) {
		try {
//			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().insert(
//					transactionOrderTo,
//					Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().insert(transactionOrderTo, 1);
			return Response.status(201).entity(transactionOrderTo).build();
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
	public Response updateTransactionOrder(TransactionOrderTo transactionOrderTo,
			@Context HttpServletRequest request) {
		try {
//			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().update(transactionOrderTo.getId(),
//					transactionOrderTo, Integer.parseInt(request.getSession()
//							.getAttribute("userId").toString()));
			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().update(transactionOrderTo.getId(),
					transactionOrderTo, 1);
			return Response.status(201).entity(transactionOrderTo).build();
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
	public Response getAllTransactionOrder(@Context HttpServletRequest request) {
		try {
			Collection<TransactionOrderTo> transactionOrderTo = new ArrayList<TransactionOrderTo>();
			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().getAll();
			return Response.status(201).entity(transactionOrderTo).build();
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
	public Response searchTransactionOrder(TransactionOrderTo transactionOrderTo,
			@Context HttpServletRequest request) {
		try {
			transactionOrderTo = ShoppingCartFactory.getTransactionOrderDao().searchById(
					transactionOrderTo.getId());
			return Response.status(201).entity(transactionOrderTo).build();
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
	public Response deleteTransactionStatus(TransactionOrderTo transactionOrderTo,
			@Context HttpServletRequest request) {
		boolean status = false;
		try {
			status = ShoppingCartFactory.getTransactionOrderDao().delete(transactionOrderTo.getId());
			return Response.status(201).entity(status).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(403).entity(status).build();
		}
	}



}
