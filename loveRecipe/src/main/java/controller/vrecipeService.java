package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.viewrefVO;

public class vrecipeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rname = request.getParameter("rname");
		String ingre = request.getParameter("ingre");
		String type = request.getParameter("type");
		int calory = Integer.parseInt(request.getParameter("calory"));

		viewrefVO vo = new viewrefVO(rname, ingre, calory, type);
		
		response.setCharacterEncoding("UTF-8");

		request.setAttribute("vo", vo);

		RequestDispatcher rd = request.getRequestDispatcher("detailvrec.jsp");
		rd.forward(request, response);
	}

}