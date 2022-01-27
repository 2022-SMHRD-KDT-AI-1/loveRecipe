package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class newrecipedao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	newrecipedto dto = null;

	public void conn() { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void colse() {

		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//게시글 업로드 메소드
	public int upload(newrecipedto dto) {
		try {
			conn();
			
			String sql = "insert into web_board values(num_board.nextval,?,?,?,?,sysdate)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getWriter());
			psmt.setString(3, dto.getFilename());
			psmt.setString(4, dto.getContent());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			colse();
			
		} return cnt; }}
		

//		
//	public ArrayList<boarddto> showboard() {
//		ArrayList<boarddto>list = new ArrayList<boarddto>();
//		try {
//			conn();
//			String sql = "select * from web_board order by b_date desc";
//			
//			psmt = conn.prepareStatement(sql);
//			
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				int num = rs.getInt(1);
//				String title = rs.getString(2);
//				String writer = rs.getString(3);
//				String filename = rs.getString(4);
//				String content = rs.getString(5);
//				String b_date = rs.getString(6);
//				
//				boarddto dto = new boarddto(num, title, writer, filename, content, b_date);
//				list.add(dto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			colse();
//		} return list;
//	
//}	

//	// 게시글 상세 내용 메소드
//	   public boarddto selectOne(int choice) {
//
//		   boarddto dto = null;
//
//		   conn();
//
//	      String sql = "select * from web_board where num = ?";
//
//	      try {
//	         psmt = conn.prepareStatement(sql);
//	         psmt.setInt(1, choice);
//
//	         rs = psmt.executeQuery();
//	         if (rs.next()) {
//	            int num = rs.getInt(1);
//	            String title = rs.getString(2);
//	            String writer = rs.getString(3);
//	            String fileName = rs.getString(4);
//	            String content = rs.getString(5);
//	            String b_date = rs.getString(6);
//
//	            dto = new boarddto(num, title, writer, fileName, content, b_date);
//	         }
//
//	      } catch (Exception e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } finally {
//	    	  colse();
//	      }
//	      return dto;
//
//	   }
//}
//
//	
//































