package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.MemberDTO;
import model.MemberVO;




/**
 * Servlet implementation class JoinService
 */
@WebServlet("/JoinService")
public class JoinService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[JoinService]");
		
		
		
		request.setCharacterEncoding("UTF-8");
		
	
		String id = request.getParameter("id");
		String pw =request.getParameter("pw");
		String nickname =request.getParameter("nickname");
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		
		MemberVO dto =new MemberVO(id,pw, nickname, email, phone);
		
		System.out.println("id :"+ id);
		System.out.println("pw :"+ pw);
		System.out.println("nickname : "+ nickname);
		System.out.println("email :"+ email);
		System.out.println("phone :"+ phone);
	
		DAO dao = new DAO();
		int cnt = dao.join(dto);
		

		
		if(cnt>0) {
			System.out.println("회원가입 성공");
			HttpSession session =request.getSession();
			session.setAttribute("id", dto.getId());
			
			response.sendRedirect("main.jsp");
		}else {
			System.out.println("회원가입 실패");
			response.sendRedirect("new.jsp");
		}
		
		
	}

}
