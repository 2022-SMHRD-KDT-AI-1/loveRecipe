package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.menuvo;

@WebServlet("/menuservice")
public class menuservice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String contry = request.getParameter("contry");
		String type = request.getParameter("type");
		String kcal = request.getParameter("kcal");

		System.out.println("contry:" + contry);
		System.out.println("type:" + type);
		System.out.println("kcal:" + kcal);

		DAO dao = new DAO();
		ArrayList<menuvo> menulist = dao.selectmenu(contry, type, kcal);

		if (menulist != null) {
			System.out.println("검색성공");

			HttpSession session = request.getSession();
			session.setAttribute("menulist", menulist);

		} else {
			System.out.println("검색 실패");
		}

		response.sendRedirect("result.jsp");

	}

}