package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.viewrefVO;

public class recmain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String href = request.getParameter("href");

		viewrefVO vo = new viewrefVO(href);

		response.setCharacterEncoding("UTF-8");
		
		request.setAttribute("vo", vo);

		RequestDispatcher rd = request.getRequestDispatcher("detailvrec.jsp");
		rd.forward(request, response);
	}

}