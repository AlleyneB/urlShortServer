package com.alleyne.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alleyne.service.IConvertService;
import com.alleyne.service.impl.ConvertServiceImpl;

public class UrlShortServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IConvertService service = new ConvertServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		String shortUrl = service.setUrl(url);
		System.out.println(shortUrl);
		request.setAttribute("shortUrl", "urlShortServer/d/"+shortUrl);
		request.getRequestDispatcher("/showAddResult.jsp").forward(request, response);
	}


	
}
