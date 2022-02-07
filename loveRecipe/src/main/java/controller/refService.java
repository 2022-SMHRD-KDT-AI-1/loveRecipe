package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;

import model.DAO;
import model.MemberVO;

@WebServlet("/refService")
public class refService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberVO info = (MemberVO) session.getAttribute("info");
		DAO dao  = new DAO();

		// 파라미터 수집
		if (request.getParameter("ingre1") != null && request.getParameter("number1") != null) {
			String ingre1 = request.getParameter("ingre1");
			int number1 = Integer.parseInt(request.getParameter("number1"));

			String id = info.getId();
			String temp = "냉동";



			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			
			int result = dao.insertrefi(number1, temp, id, ingre1);
			if (result>0) {
				System.out.println("재료입력성공");
			} else {
				System.out.println("재료입력실패");
			}



			out.print(number1);

			
			System.out.println(info.getId());
			System.out.println(ingre1);
			

		} else if (request.getParameter("ingre2") != null && request.getParameter("number2") != null) {
			String ingre2 = request.getParameter("ingre2");
			int number2 = Integer.parseInt(request.getParameter("number2"));

			String id = info.getId();
			String temp = "냉장";



			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			int result = dao.insertrefi(number2, temp, id, ingre2);
			if (result>0) {
				System.out.println("재료입력성공");
			} else {
				System.out.println("재료입력실패");
			}
			
			out.print(number2);

			System.out.println(info.getId());
			System.out.println(ingre2);
			


		} else if (request.getParameter("ingre3") != null && request.getParameter("number3") != null) {

			String ingre3 = request.getParameter("ingre3");
			int number3 = Integer.parseInt(request.getParameter("number3"));

			String id = info.getId();
			String temp = "상온";


			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			
			int result = dao.insertrefi(number3, temp, id, ingre3);
			if (result>0) {
				System.out.println("재료입력성공");
			} else {
				System.out.println("재료입력실패");
			}
			
			out.print(number3);
			System.out.println(info.getId());
			System.out.println(ingre3);
		}

	
	}
	
}