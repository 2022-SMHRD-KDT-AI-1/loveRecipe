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

import model.boarddao;
import model.boarddto;


@WebServlet("/newrecipeservice")
public class newrecipeservice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[boardservice]");
		
		request.setCharacterEncoding("utf-8");
		
		//이미지파일을 저장하는  파일생성후 경로 찾기
		String savepath = request.getServletContext().getRealPath("file_img");
		System.out.println(savepath);
		
		int maxsize = 10*1024*1024;
		
		String encoding = "utf-8";
		
		DefaultFileRenamePolicy norepeat = new DefaultFileRenamePolicy();
		
//		MultipartRequest (request, 저장할경로, 사이즈, 인코딩방식, 파일명 중복제거)
		MultipartRequest multi = new MultipartRequest(request,savepath,maxsize ,encoding ,norepeat);
		
		//DB에 저장하기 위해서  multi객체에서 꺼내오기
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		//파일은 getFilesystemName사용할것
		//이미지채그 경로 작성시 한글은 깨진다 -> 인코딩한상태로 db에 넣기
		String filename = URLEncoder.encode(multi.getFilesystemName("filename"),"utf-8");
		
		System.out.println("title: "+title);
		System.out.println("writer: "+writer);
		System.out.println("content: "+content);
		System.out.println("filename: "+filename);
		
		boarddao dao = new boarddao();
		boarddto dto = new boarddto(title, writer, filename, content);
		int cnt = dao.upload(dto);
		if(cnt>0) {
			System.out.println("게시물 업로드 성공");
		}else {
			System.out.println("이미지 업로드 실패");
		}
		response.sendRedirect("boardmain.jsp");

		
	
	}

}
