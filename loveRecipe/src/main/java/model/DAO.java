package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberVO vo = null;

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

	// 로그인!
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

				String uid = rs.getString(2);
				String upw = rs.getString(3);
				String nickname = rs.getString(4);

				vo = new MemberVO(uid, upw, nickname);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return vo;
	}

	// 회원가입!
	public int join(MemberVO dto) {

		try {
			DBconn();

			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			System.out.println(dto.getNickname());
			System.out.println(dto.getEmail());
			System.out.println(dto.getPhone());

			String sql = "insert into test_member values(test_seq.nextval, ? , ? , ? , ? , ? ,sysdate)";

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
		}
		return cnt;
	}

	// 게시물 업로드 메소드
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
		}
		return cnt;
	}

	// 메세지 보내기 관련
	public int insertMessage(String sendName, String receiveEmail, String message) {
		try {
			DBconn();

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

<<<<<<< HEAD
	 public int update(MemberVO vo) {
		 try {
			 	DBconn();
				String sql = "update test_member set pw=?, nickname =?, email=? where id=? ";

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, vo.getPw());
				psmt.setString(2, vo.getNickname());
				psmt.setString(3, vo.getEmail());
				psmt.setString(4, vo.getId());

				cnt= psmt.executeUpdate();

				if (cnt!=0) {
					System.out.print("수정성공 ");
					
				}else {
					System.out.println("수정실패");
				}

				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();
	 } return cnt;
=======
	// 피드백 업로드 메소드
	public int feedupload(feedDTO dto) {
		try {
			DBconn();
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git

			String sql = "insert into feed_board values(feed_seq.nextval, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getmessage());

			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// 회원정보 확인 메소드
	public ArrayList<MemberVO> showmember() {

		// dto을 담을수 있는 Arraylist
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			DBconn();

<<<<<<< HEAD
}}
=======
			String sql = "select id,pw,nickname from test_member";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git

			while (rs.next()) {

				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nickname = rs.getString(3);

				vo = new MemberVO(id, pw, nickname);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return list;

	}

	// 그거 아세요? 총 회원 수 카운트 메소드
	public int memberCount() {
		int memberCount = 0;
		try {

			DBconn();
			// 5. SQL문 작성
			String sql = "select count (*) from test_member";

			// 6. preparestatement 메소드 사용해서 sql문을 DB에 전달
			psmt = conn.prepareStatement(sql);

			// 8. 실행
			// Update : select구문을 제외한 다른 구문, int형태로 변환
			// Query : select구문에서 사용, Resultset형태로 반환
			rs = psmt.executeQuery();

			if (rs.next()) {
				memberCount = rs.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return memberCount;
	}

	// 그거 아세요? 레시피 수 카운트 메소드
	public int recipeCount() {
		int recipeCount = 0;
		try {

			DBconn();
			// 5. SQL문 작성
			String sql = "select count (*) from recipe";

			// 6. preparestatement 메소드 사용해서 sql문을 DB에 전달
			psmt = conn.prepareStatement(sql);

			// 8. 실행
			// Update : select구문을 제외한 다른 구문, int형태로 변환
			// Query : select구문에서 사용, Resultset형태로 반환
			rs = psmt.executeQuery();

			if (rs.next()) {
				recipeCount = rs.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return recipeCount;
	}

}