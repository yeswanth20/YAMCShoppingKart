package com.shopping.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/accessService")
public class AuthService {
	@GET
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public void loginAuth(@Context HttpServletRequest request) {
		if(true){
        	HttpSession httpsession=request.getSession();  
        	httpsession.setAttribute("ipaddress",request.getRemoteHost()); 
		}
	}
	
	@GET
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public void logoutAuth(@Context HttpServletRequest request) {
		//invalidate the session if exists
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
//       return new Viewable("index.html", null);
	}	
}
