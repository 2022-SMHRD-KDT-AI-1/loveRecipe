package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("[LogoutService]");
		
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("info");
		
		
		System.out.println("로그아웃 성공");
		response.sendRedirect("main.jsp");
	}

}
