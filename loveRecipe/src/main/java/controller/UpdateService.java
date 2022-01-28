package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
   protected void service(HttpServletRequest phone, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("[UpdateService]");
      
     
      request.setCharacterEncoding("UTF-8");
      
      
      String pw = request.getParameter("pw");
      String nickname = request.getParameter("nickname");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      
      System.out.println("pw : "+pw);
      System.out.println("nickname : "+nickname);
      System.out.println("email : "+email);
      System.out.println("address : "+phone);
    
      HttpSession session = request.getSession();
      MemberVO info = (MemberVO)session.getAttribute("info");
      
  
      String id = info.getId();
      
   
      info = new MemberVO(id, pw, nickname, email, phone);
      
  
      DAO dao = new DAO();
      int cnt = vo.update(info);
      

    
      if(cnt >0) {
         System.out.println("회원정보수정 성공");
         
        
         session.setAttribute("info", info);
      }else {
         System.out.println("회원정보수정 실패");
      }
      
      response.sendRedirect("main.jsp");
      
      
      
      
      
      
      
   }

}
