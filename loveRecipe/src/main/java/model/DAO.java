package model;

import java.sql.Connection;
import java.sql.Date;
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
	refivo refi = null;
	ingrivo ingri = null;
	String expired;
	menuvo menu = null;

	String[] temp_menu = new String[3];// 저장용

	public void DBconn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_e_3_0115";
			String dbpw = "smhrd3";
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

			String sql = "select * from t_member where mb_id = ? and mb_pw =?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String uid = rs.getString(1);
				String upw = rs.getString(2);
				String nickname = rs.getString(3);

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

			String sql = "insert into t_member(mb_id,mb_pw,mb_nick,admin_yn,mb_phone,mb_email) values(?, ? , ? , ? , ? ,?)";

			// sql -> DB에 전달
			psmt = conn.prepareStatement(sql);

			// ?에 값 넣어주기
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNickname());
			psmt.setString(4, "Y");
			psmt.setString(5, dto.getPhone());
			psmt.setString(6, dto.getEmail());

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

			String sql = "insert into web_board(writer,title,filename,content) values( ?, ?, ?, ? )";

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

			String sql = "insert into web_message(sendname,receiveemail,message) values(? ,? ,? )";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, sendName);
			psmt.setString(2, receiveEmail);
			psmt.setString(3, message);

			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// 회원정보변경 메소드
	public int update(MemberVO vo) {
		try {
			DBconn();
			String sql = "update t_member set mb_pw=?, mb_nick =?, mb_email=? where mb_id=? ";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getPw());
			psmt.setString(2, vo.getNickname());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());

			cnt = psmt.executeUpdate();

			if (cnt != 0) {
				System.out.print("수정성공 ");

			} else {
				System.out.println("수정실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// 피드백 업로드 메소드
	public int feedupload(feedDTO dto) {
		try {

			DBconn();

			String sql = "insert into feed_board(writer,content) values(?, ?)";

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

			String sql = "select mb_id,mb_pw,mb_nick from t_member";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

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

	// 그거 아세요? 조리 방법 카운트 메소드
	public int foodType() {
		int foodType = 0;
		try {

			DBconn();
			// SQL문 작성
			String sql = "SELECT count (DISTINCT how_to_cook) FROM t_recipe";

			// preparestatement 메소드 사용해서 sql문을 DB에 전달
			psmt = conn.prepareStatement(sql);

			// 실행
			// Update : select구문을 제외한 다른 구문, int형태로 변환
			// Query : select구문에서 사용, Resultset형태로 반환
			rs = psmt.executeQuery();

			if (rs.next()) {
				foodType = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return foodType;
	}

	// 그거 아세요? 총 회원 수 카운트 메소드
	public int memberCount() {
		int memberCount = 0;
		try {

			DBconn();
			String sql = "select count (*) from t_member";

			psmt = conn.prepareStatement(sql);

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
			String sql = "select count (*) from t_recipe";

			psmt = conn.prepareStatement(sql);

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

	// 냉장고에 재료입력
	public int insertrefi(int number1, String temp, String id, String ingre1) {

		try {
			DBconn();
			// 필요한정보 - 재료이름,재료양,유저아이디
			String sql = "insert into T_MY_INGREDIENT(ingre_amount,temperature_kind,mb_id,ingre_name) values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, number1); // 양
			psmt.setString(2, temp); // 온도
			psmt.setString(3, id); // 아이디
			psmt.setString(4, ingre1);// 재료명

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// 냉장고에 지금 보유한 재료 가져오기
	public ArrayList<refivo> selectrefi(String id) {
		ArrayList<refivo> refilist = new ArrayList<refivo>();
		try {
			DBconn();
			// 필요한 정보 - 재료명,갯수,현재보관장소
			String sql = "select ingre_amount, temperature_kind, ingre_name from T_MY_INGREDIENT where mb_id= ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int ingre_amount = rs.getInt(1);
				String ingre_temp = rs.getString(2);
				String ingre_name = rs.getString(3);

//            System.out.println(ingre_amount);
//            System.out.println(ingre_temp);
//            System.out.println(ingre_name);

				refi = new refivo(ingre_amount, ingre_temp, ingre_name);
				refilist.add(refi);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return refilist;
	}

	// 냉장고에 보유한 재료의 상세정보 가져오기
	public ArrayList<ingrivo> selectingri(String name) {
		ArrayList<ingrivo> ingrilist = new ArrayList<ingrivo>();
		try {
			DBconn();
			// 필요한정보 -재료명,재료타입,유통기한,제철,칼로리,권장보관장소
			String sql = "select * from t_ingredient where ingre_name=?";
			// String sql ="select * from test_ingredient where ingre_name=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String type = rs.getString(3);
				int expire = rs.getInt(4);
				String season = rs.getString(5);
				int carloy = (int) rs.getFloat(6);
				String tempt = rs.getString(7);

				System.out.println(type);
				System.out.println(expire);
				System.out.println(season);
				System.out.println(carloy);
				System.out.println(tempt);

				ingri = new ingrivo(type, season, tempt, expire, carloy);
				ingrilist.add(ingri);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return ingrilist;
	}

	public String expire(int num) {

		try {
			DBconn();
			String sql = "select to_char (sysdate+?) from dual";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				expired = rs.getString(1);
				System.out.println(expired);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return expired;
	}

	// 레시피 표기페이지 메인 사진 메소드(요리 순서 그림의 마지막 그림 가져올것)
	public ArrayList<viewrefVO> recMain() {
		ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
		viewrefVO vo1 = null;
		try {
			DBconn();
			String sql = "select main_photo from t_cooking";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String href = rs.getString(1);

				vo1 = new viewrefVO(href);
				list.add(vo1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return list;

	}

	// 레시피 정보 메소드(이름, 재료, 요리방식, 칼로리)
	public ArrayList<viewrefVO> recInfo() {
		ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
		viewrefVO vo1 = null;
		try {
			DBconn();
			String sql = "select recipe_name, ingre_name from t_cooking";
			// 칼로리랑 요리방식은 따로 긁ㅇ와
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String rname = rs.getString(1);
				String ingre = rs.getString(2);
				String type = returnType(ingre); // 반환용 함수 콜
				int calory = returnCalory(ingre); // 반환용 함수

				vo1 = new viewrefVO(rname, ingre, calory, type);
				list.add(vo1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return list;
	}

	// --------------------------------------------
	// 칼로리랑 type따로 반환하는
	public int returnCalory(String ingre) {
		int calory = 0;
		try {
			DBconn();
			String sql = "select recipe_calory from t_recipe";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				calory = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return calory;
	}

	public String returnType(String ingre) {
		String type = "";// =how_to_cook
		try {
			DBconn();
			String sql = "select how_to_cook  from t_recipe";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				type = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return type;
	}

	// --------------------------------------------

	// 레시피 순서 메소드
	public ArrayList<viewrefVO> recSequence() {
		ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
		viewrefVO vo1 = null;
		try {
			DBconn();
			String sql = "select cooking_seq, main_photo from t_cooking";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String sequence = rs.getString(1);
				String href = rs.getString(2);

				vo1 = new viewrefVO(sequence, href);
				list.add(vo1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return list;
	}

	// <-------------------------------------추가
	// 메뉴검색하는기능
	public ArrayList<menuvo> selectmenu(String food_type, String how_to_cook, String kcal) {
		ArrayList<menuvo> menulist = new ArrayList<menuvo>();
		try {
			DBconn();

			String sql = "select * from t_recipe where  how_to_cook =  ?  and food_type = ? and RECIPE_CALORY<? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, how_to_cook);
			psmt.setString(2, food_type);
			psmt.setString(3, kcal);

			rs = psmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString(2);
				String country = rs.getString(4);
				String foodtype = rs.getString(5);
				String calory = rs.getString(6);

				searchMenu(name);
				String ingre = temp_menu[0];// 쿠킹 ->레시피 이름넘겨주고 그에 해당하는 재료
				String method = temp_menu[1];// 쿠킹
				String image = temp_menu[2]; // 쿠킹

				System.out.println("실행");
				System.out.println(name);
				System.out.println(foodtype);
				System.out.println(country);
				System.out.println(calory);
				System.out.println(ingre);
				System.out.println(method);
				System.out.println(image);

				// 레시피이름, 조리방법, 분야, 칼로리, 재료, 조리방법, 이미지
				menu = new menuvo(name, foodtype, country, calory, ingre, method, image);
				// 여기서 오류발생
				menulist.add(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return menulist;

	}

	public void searchMenu(String name) {
		try {
			DBconn();

			String sql = "select ingre_name,cooking_method,main_photo from t_cooking where recipe_name=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery();
			if (rs.next()) {
				temp_menu[0] = rs.getString(1);
				temp_menu[1] = rs.getString(2);
				temp_menu[2] = rs.getString(3);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}

	}

} 
