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

@WebServlet("/deleteingri")
public class deleteingri extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("[deleteingri]");
      
     
      request.setCharacterEncoding("UTF-8");
      
      
      String name = request.getParameter("delete");
      
      System.out.println("삭제할 재료 : "+name);
   

      
  
//      DAO dao = new DAO();
//      int cnt = dao.update(info);
//      
//
//    
//      if(cnt >0) {
//         System.out.println("재료 삭제 성공");
//         
//        
//         session.setAttribute("info", info);
//      }else {
//         System.out.println("재료 삭제 실패");
//      }
//      
      response.sendRedirect("refigator.jsp");
      
      
      
      
      
      
      
   }

}
