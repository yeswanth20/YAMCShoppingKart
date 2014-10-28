package com.shopping.session;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionImpl implements ServletContextListener, HttpSessionListener {
	Map<String, String> sessionDeatilsMap = new HashMap<String, String>();
	ServletContext objServletContext;

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
		session.setAttribute("sessionID", session.getId());
		sessionDeatilsMap.put(session.getId(), "11111111111");
		objServletContext.setAttribute("sessionDetails", sessionDeatilsMap);
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		sessionDeatilsMap.remove(session.getId());
	}
}