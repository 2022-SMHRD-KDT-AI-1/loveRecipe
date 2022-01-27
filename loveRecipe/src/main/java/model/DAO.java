package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt =null;
	ResultSet rs= null;
	int cnt = 0;

	public void DBconn() {
		
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
	public MemberVO login(String id, String pw) {
		MemberVO vo = null;
		
		try {
			
			DBconn();
		
			String sql = "select * from test_member where id = ? and pw =?";

			
			psmt = conn.prepareStatement(sql);

		
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
		
			rs = psmt.executeQuery();

			
			
			
			if (rs.next()) {
		
				String uid = rs.getString(1);
				String upw = rs.getString(2);
				String nickname = rs.getString(3);
			

				
				vo = new MemberVO(uid, upw , nickname);

			}
	
		} catch (Exception e) { 
			e.printStackTrace();
		}finally {
			DBclose();
		}
		return vo;
	}

	public int join(MemberDTO dto) {
		
		try {
			DBconn();
			
			String sql = "insert into test_member values(?,?,?,?,?)";
			
			// sql -> DB에 전달
			psmt = conn.prepareStatement(sql);
			
			// ?에 값 넣어주기
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNickname());
			psmt.setString(4, dto.getEmail());
			psmt.setString(5, dto.getPhone());
			// 실행
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		} return cnt;
	}

}
