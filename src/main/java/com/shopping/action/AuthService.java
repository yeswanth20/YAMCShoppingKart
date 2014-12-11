package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.ProductTo;
import com.shopping.to.UsersTo;

@Path("/accessService")
public class AuthService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response loginAuth(UsersTo usersTo,
			@Context HttpServletRequest request) {
		int userId;
		try {
			userId = ShoppingCartFactory.getUserDao().verifyLogin(
					usersTo.getUserName(), usersTo.getPassword());
			if (userId != 0) {
				request.setAttribute("userId", userId);
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("ipaddress", request.getRemoteHost());
				
				Collection<ProductTo> productTo = new ArrayList<ProductTo>();
				int pageNumber=1;
				int pageSize=10;
				productTo = ShoppingCartFactory.getProductDao().getAll(pageNumber, pageSize);
				return Response.status(201).entity(productTo).build();
			}
//				return Response.status(201).entity("sucess"+userId).build();
//				servletResponse.sendRedirect("http://localhost:8080/MySite/pages/Create_Profile.html");			}
				
//				URI uri = uriInfo.getBaseUriBuilder().path("../user.html").build();
//				return Response.seeOther(uri).build();
				else{
				return Response.status(201).entity("Invalid Login").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logoutAuth(@Context HttpServletRequest request) {
		// invalidate the session if exists
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return Response.status(201).entity("LOGOUT SUCESS").build();

	}
}
