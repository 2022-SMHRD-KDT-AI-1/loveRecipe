package controller;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.MemberVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("[LoginService]");

	
	request.setCharacterEncoding("UTF-8");
	
	
	String id =request.getParameter("id");
	String pw =request.getParameter("pw");
	
	
	
	System.out.println("id:"+ id);
	System.out.println("pw:"+ pw);
	
	
	DAO dao = new DAO();	 
	
	
	
	MemberVO info =dao.login(id,pw);
	
	
	
	if(info !=null) {
		System.out.println("로그인 성공");
		
		HttpSession session = request.getSession();
		session.setAttribute("info", info);
		
	}else {
		System.out.println("로그인 실패");
	}
	
	
	response.sendRedirect("join_succes.jsp");
	
}
}