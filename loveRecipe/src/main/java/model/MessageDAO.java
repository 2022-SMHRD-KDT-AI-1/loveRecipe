package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class MessageDAO {

	// ���������� ����
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
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
	public void DBconn_team() {
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
	// DB Close �޼ҵ�
	public void DBclose() {
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

	
	
	public int insertMessage(String sendName, String receiveEmail, String message) {
		try {
			DBconn_team();

		
			String sql = "insert into web_message values(num_message.nextval, , , , sysdate)";
			
			psmt = conn.prepareStatement(sql);

			
	
			psmt.setString(1, message);
		

			
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}
}

