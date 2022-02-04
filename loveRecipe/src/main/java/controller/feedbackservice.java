package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.feedDTO;


@WebServlet("/feedbackservice")
public class feedbackservice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		System.out.println(name);
		System.out.println(message);
		
		feedDTO dto = new feedDTO(name, message);
		
		DAO dao = new DAO();
		int cnt  = dao.feedupload(dto);
		
		if(cnt>0) {
			System.out.println("피드백 저장 성공");
			
		}else {
			System.out.println("피드백 저장 실패");
		}
		
		response.sendRedirect("main.jsp");
	}

}
