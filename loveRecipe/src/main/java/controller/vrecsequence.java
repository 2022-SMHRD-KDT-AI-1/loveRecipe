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

public class vrecsequence extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		viewrefVO vo1 = new viewrefVO("adsf",
				"https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/direction/image_file/7851/org_resized__B9_E4_C7_C7_C0_DA3.jpg&convert=jpgmin&rt=600");
		viewrefVO vo2 = new viewrefVO("qrqrw",
				"https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/direction/image_file/7851/org_resized__B9_E4_C7_C7_C0_DA3.jpg&convert=jpgmin&rt=600");
		viewrefVO vo3 = new viewrefVO("ahkj",
				"https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/direction/image_file/7851/org_resized__B9_E4_C7_C7_C0_DA3.jpg&convert=jpgmin&rt=600");
		viewrefVO vo4 = new viewrefVO("ioasduou",
				"https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/direction/image_file/7851/org_resized__B9_E4_C7_C7_C0_DA3.jpg&convert=jpgmin&rt=600");

		ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();

		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);

		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		out.print(json);
	}

}