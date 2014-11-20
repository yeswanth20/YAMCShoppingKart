package com.shopping.session;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionImpl implements ServletContextListener,
		HttpSessionListener, ServletRequestListener {
	Map<String, String> sessionDeatilsMap = new HashMap<String, String>();
	ServletContext objServletContext;
	ServletRequest requestParam;

	public SessionImpl() {
	}

	public void contextInitialized(ServletContextEvent sce) {
		objServletContext = sce.getServletContext();
		objServletContext.setAttribute("sessionDetails", sessionDeatilsMap);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("sessionID", null);
	}

	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		sessionDeatilsMap.put(session.getId(),requestParam.getAttribute("userId").toString());
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		sessionDeatilsMap.remove(session.getId());
	}

	public void requestDestroyed(ServletRequestEvent sre) {

	}

	public void requestInitialized(ServletRequestEvent sre) {
		requestParam = sre.getServletRequest();
	}
}