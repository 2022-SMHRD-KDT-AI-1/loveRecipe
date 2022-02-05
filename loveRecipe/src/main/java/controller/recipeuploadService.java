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

import model.DAO;
import model.BoardDTO;

@WebServlet("/recipeuploadService")
public class recipeuploadService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("recipeuploadService");

		request.setCharacterEncoding("UTF-8");

		String savePath = request.getServletContext().getRealPath("file_img");
		System.out.println(savePath);

		int maxsize = 10 * 1024 * 1024; // 10MB

		String encoding = "UTF-8";

		DefaultFileRenamePolicy norepeat = new DefaultFileRenamePolicy();

		MultipartRequest multi = new MultipartRequest(request, savePath, maxsize, encoding, norepeat);
		// multi = new MultipartRequest(request, savePath, maxsize, encoding, norepeat);

		String object = multi.getParameter("object");
		String type = multi.getParameter("type");
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		String kcal = multi.getParameter("kcal");
		// String fileName = multi.getFilesystemName("filename");
		String fileName = URLEncoder.encode(multi.getFilesystemName("filename"), "UTF-8");

//    //request parameter에서 null값이 넘어 올 수 있다.
//    String command = request.getParameter("fileName");
//    System.out.println("BoardServlet에서 요청을 받음을 확인 : " + command);
//    메롱
//
//    //따라서 아래와 같이 null처리를 해주면 된다.
//    if(command == null) command = "";

		System.out.println("title :" + title);
		System.out.println("writer :" + writer);
		System.out.println("content :" + content);
		System.out.println("object :" + object);
		System.out.println("type :" + type);
		System.out.println("content :" + content);
		System.out.println("kcal :" + kcal);

		DAO dao = new DAO();
		BoardDTO dto = new BoardDTO(title, writer, fileName, content);
		int cnt = dao.upload(dto);

		if (cnt > 0) {
			System.out.println("게시물업로드완료");
		} else {
			System.out.println("게시물업로드 실패");
		}
		response.sendRedirect("newrecipe.jsp");

	}

}