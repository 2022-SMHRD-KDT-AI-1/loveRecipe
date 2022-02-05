package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.viewrefVO;

public class viewrecService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		viewrefVO vo1 = new viewrefVO("가","나", 12, "다");
		
		ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
		
		list.add(vo1);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		out.print(json); 
		
		
	}

}
