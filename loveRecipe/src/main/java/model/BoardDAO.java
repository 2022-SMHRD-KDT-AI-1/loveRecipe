package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement psmt =null;
	ResultSet rs= null;
	int cnt=0;
	
	public void DBconn() {
		// 1.. jar���� ����ְ�, Class �����ε�
		try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					// 2. Connection ��ü ����
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String dbid = "hr"; // ���Ⱑ ����־ ���̵����� �����ϱ� ���� �Ұ����̿���! hr hr ä���ֽø� �˴ϴٳ�,,
					String dbpw = "hr"; // ���غ����
					conn = DriverManager.getConnection(url, dbid, dbpw);
				
					} catch (Exception e) {
					e.printStackTrace();
					}
	}
	//DB Close �޼ҵ�
	public void DBclose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
	       } catch (Exception e) {
	            e.printStackTrace();
	         }
	}
	
	// �Խñ� ���ε� �޼ҵ�
	   public int upload(BoardDTO dto) {
	      try {
	         DBconn();
	         
	         String sql = "insert into web_board values(num_board.nextval, ?, ?, ?, ?, sysdate)";
	         
	         psmt = conn.prepareStatement(sql);
	         
	         psmt.setString(1, dto.getTitle());
	         psmt.setString(2, dto.getWriter());
	         psmt.setString(3, dto.getFileName());
	         psmt.setString(4, dto.getContent());
	         
	         cnt = psmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBclose();
	      } return cnt;
	   }
	   
	// ��ü �Խñ� �����ִ� �޼ҵ�
	   public ArrayList<BoardDTO> showBoard() {
		   ArrayList<BoardDTO> list =new ArrayList<BoardDTO>();
		   try {
			DBconn();
			
			String sql="select*from web_board order by b_date desc";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int num =rs.getInt(1);
				String title =rs.getString(2);
				String writer = rs.getString(3);
				String fileName = rs.getString(4);
				String content =rs.getString(5);
				String b_date =rs.getString(6);
			
			
			BoardDTO dto =new BoardDTO(num, title, writer, fileName, content, b_date);
			list.add(dto);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBclose();
		} return list;
			
		}
	// �Խñ� �� ���� �޼ҵ�
	   public BoardDTO selectOne(int choice) {

	      BoardDTO dto = null;

	      DBconn();

	      String sql = "select * from web_board where num = ?";

	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, choice);

	         rs = psmt.executeQuery();
	         if (rs.next()) {
	            int num = rs.getInt(1);
	            String title = rs.getString(2);
	            String writer = rs.getString(3);
	            String fileName = rs.getString(4);
	            String content = rs.getString(5);
	            String b_date = rs.getString(6);

	            dto = new BoardDTO(num, title, writer, fileName, content, b_date);
	         }

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         DBclose();
	      }
	      return dto;
	   }
	   }