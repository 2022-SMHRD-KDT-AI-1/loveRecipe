package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.DAO;
import model.viewrefVO;

public class rseqService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAO dao = new DAO();
		ArrayList<viewrefVO> info = dao.recSequence();
		
		request.setAttribute("info", info);

		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String json = gson.toJson(info);
		System.out.println(json);
		out.print(json);
	}

}