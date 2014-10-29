package com.shopping.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	private ArrayList<String> urlList;
	private FilterConfig config = null;
	private ServletContext context;
	@SuppressWarnings("unused")
	private HashMap<String, String> sessionDetails;

	public void destroy() {
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String contextPath = request.getContextPath();
		String jerssyPath = request.getServletPath();
		String url = contextPath + jerssyPath + request.getPathInfo();
		System.out.println("URL" + url);
		boolean allowedRequest = false;

		// Logout and Login
		if (request.getPathInfo() != null) {
			if (request.getPathInfo().equalsIgnoreCase("/accessService/logout")) {
				allowedRequest = true;
				chain.doFilter(req, res);
			} else if (request.getPathInfo().equalsIgnoreCase(
					"/accessService/login")) {
				allowedRequest = true;
				chain.doFilter(req, res);
			}
		}
		// if(urlList.contains(url)) {
		// allowedRequest = true;
		// }

		// other URLS
		if (!allowedRequest) {
			HttpSession session = request.getSession(false);
			String ipaddress = null;
			sessionDetails = (HashMap<String, String>) context
					.getAttribute("sessionDetails");
			try {
				ipaddress = (String) session.getAttribute("ipaddress");
				long before = System.currentTimeMillis();
				chain.doFilter(req, res);
				long after = System.currentTimeMillis();
				config.getServletContext().log(
						"RESPONSE TIME :" + (after - before) + "ms");
			} catch (Exception e) {
				if (ipaddress == null) {
					long before = System.currentTimeMillis();
					chain.doFilter(req, res);
					long after = System.currentTimeMillis();
					config.getServletContext().log(
							"RESPONSE TIME :" + (after - before) + "ms");
				}
			}

		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.context = config.getServletContext();
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		this.context.log("RequestLoggingFilter initialized");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

		}
	}
}
