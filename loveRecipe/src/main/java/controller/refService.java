package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/refService")
public class refService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터 수집
		if (request.getParameter("ingre1") != null && request.getParameter("number1") != null) {
			String ingre1 = request.getParameter("ingre1");
			int number1 = Integer.parseInt(request.getParameter("number1"));

			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			out.print(number1);

		} else if (request.getParameter("ingre2") != null && request.getParameter("number2") != null) {
			String ingre2 = request.getParameter("ingre2");
			int number2 = Integer.parseInt(request.getParameter("number2"));

			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			out.print(number2);

		} else if (request.getParameter("ingre3") != null && request.getParameter("number3") != null) {
			String ingre3 = request.getParameter("ingre3");
			int number3 = Integer.parseInt(request.getParameter("number3"));

			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			out.print(number3);
		}

	}
	
}