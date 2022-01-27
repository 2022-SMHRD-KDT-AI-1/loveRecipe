package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BoardDAO;
import model.BoardDTO;





@WebServlet("/BoardService")
public class BoardService extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("[BoardService]");

    request.setCharacterEncoding("UTF-8");
    
 
    String savePath = request.getServletContext().getRealPath("file_img");
    System.out.println(savePath);
    
    int maxsize = 10*1024*1024; // 10MB
   
    String encoding = "UTF-8";
    
  
    DefaultFileRenamePolicy norepeat = new DefaultFileRenamePolicy();
    
    
    MultipartRequest multi = null;
    multi = new MultipartRequest(request, savePath, maxsize, encoding, norepeat);
    
   
    String title = multi.getParameter("title");
    String writer = multi.getParameter("writer");
    String content = multi.getParameter("content");
   
    String fileName = URLEncoder.encode(multi.getFilesystemName("fileName"), "UTF-8");
    
    System.out.println("title :"+ title);
    System.out.println("writer :"+ writer);
    System.out.println("content :"+ content);
    System.out.println("fileName :"+ fileName);
    
    BoardDAO dao = new BoardDAO();
    BoardDTO dto = new BoardDTO(title , writer,fileName, content);
    int cnt = dao.upload(dto);
    
    if(cnt>0) {
    	System.out.println("�̹��� ���ε� ����");
    }else {
    	System.out.println("�̹��� ���ε� ����");
    }
    response.sendRedirect("newrecipe.jsp");
    
	}

}
