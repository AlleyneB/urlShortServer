package com.alleyne.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alleyne.service.IConvertService;
import com.alleyne.service.impl.ConvertServiceImpl;

public class GetUrlServlet extends HttpServlet {

	/**
	 * /urlShortServer/d/ahdh2ns
	 */
	private static final long serialVersionUID = 1L;
	private IConvertService service = new ConvertServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String shortUrl = url.split("/")[3];
		response.sendRedirect("http://"+service.getUrl(shortUrl));
	}


	
}
