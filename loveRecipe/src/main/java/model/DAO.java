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
<<<<<<< HEAD
	String expired ;
	viewrefVO vo1 = null;
	menuvo menu = null;
=======
	String expired;
	menuvo menu = null;
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git

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

	// 회원정보변경 메소드
	public int update(MemberVO vo) {
		try {
			DBconn();
			String sql = "update test_member set pw=?, nickname =?, email=? where id=? ";

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

			String sql = "select id,pw,nickname from test_member";

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
			String sql = "SELECT count (DISTINCT food_type) FROM recipe";

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
			String sql = "select count (*) from test_member";

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
			String sql = "select count (*) from recipe";

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
			String sql = "insert into test_refi values(refi_seq.nextval, " + "refi_seq2.nextval, ?,?, sysdate ,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, number1);
			psmt.setString(2, temp);
			psmt.setString(3, id);
			psmt.setString(4, ingre1);

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
			String sql = "select * from test_refi where mb_id= ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {

				int ingre_amount = rs.getInt(3);
				String ingre_temp = rs.getString(4);
<<<<<<< HEAD
				String ingre_name = rs.getString(7);				
				//가져온 데이터 값 vo에넣고 Arraylisy화 하여 리턴하기
=======
				String ingre_name = rs.getString(7);

//				System.out.println(ingre_amount);
//				System.out.println(ingre_temp);
//				System.out.println(ingre_name);

>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
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
<<<<<<< HEAD
	
	//냉장고에 보유한 재료의 상세정보 가져오기
=======

	// 냉장고에 보유한 재료의 상세정보 가져오기
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
	public ArrayList<ingrivo> selectingri(String name) {
		ArrayList<ingrivo> ingrilist = new ArrayList<ingrivo>();
		try {
			DBconn();
			// 필요한정보 -재료명,재료타입,유통기한,제철,칼로리,권장보관장소
			String sql = "select * from test_ingredient where ingre_name=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				String type = rs.getString(3);
				int expire = rs.getInt(4);
				String season = rs.getString(5);
				int carloy = rs.getInt(6);
				String tempt = rs.getString(7);
<<<<<<< HEAD
				
				//가져온 데이터 값 vo에넣고 Arraylisy화 하여 리턴하기
=======

				System.out.println(type);
				System.out.println(expire);
				System.out.println(season);
				System.out.println(carloy);
				System.out.println(tempt);

>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
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
<<<<<<< HEAD
	
	//냉장고에잇는 재료 유통기한 표시
=======

>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
	public String expire(int num) {

		try {
			DBconn();
			String sql = "select to_char (sysdate+?) from dual";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				expired = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return expired;
	}
<<<<<<< HEAD
	
	
	public int deleteingri(String id, String ingri ) {
		try {
			DBconn();
			String sql = "delete from test_refi where mb_id = ? and ingre_name=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,id);
			psmt.setString(2,ingri);
			
			cnt = psmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		} return cnt;
	}
	
	//레시피 표기페이지 메인 사진 메소드(요리 순서 그림의 마지막 그림 가져올것)
	public ArrayList<viewrefVO> recMain() {
	      ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
	      try {
	         DBconn();
	         String sql = "select href from t_cooking";

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
	   

	   //레시피 정보 메소드(이름, 재료, 요리방식, 칼로리)
	   public ArrayList<viewrefVO> recInfo() {
	      ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
	      try {
	         DBconn();
	         String sql = "select rname, ingre, calory, type from t_cooking";

	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();

	         while (rs.next()) {

	            String rname = rs.getString(1);
	            String ingre = rs.getString(2);
	            String type = rs.getString(3);
	            int calory = rs.getInt(4);

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

	
	   //레시피 순서 메소드
	   public ArrayList<viewrefVO> recSequence() {
	      ArrayList<viewrefVO> list = new ArrayList<viewrefVO>();
	      try {
	         DBconn();
	         String sql = "select sequence, href from t_cooking";

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
	
	
	
	//메뉴검색하는기능
    public ArrayList<menuvo> selectmenu( String contry, String type, String kcal) {
    	ArrayList<menuvo> menulist = new ArrayList<menuvo>(); 
	         try {
	            DBconn();
	            
	            String sql = "select * from recipe where  FOOD_TYPE =  ?  and RECIPE_COUNTRY = ? and RECIPE_CALORY<? ";
	            //가져온값 sql문에 입력     
	            psmt = conn.prepareStatement(sql);
	            psmt.setString(1, type);
	            psmt.setString(2, contry);
	            psmt.setString(3, kcal);	            
	            
	            //sql문에서 나온 값 getString으로 가져오기
	            rs = psmt.executeQuery();      
	            while(rs.next()) {
	            
	               String name =rs.getString(2);
	               String foodtype =rs.getString(3);
	               String country =rs.getString(4);
	               String calory = rs.getString(5);
	               String ingre = rs.getString(6);
	               String method = rs.getString(7);
	               String image = rs.getString(8);
	               
	            //가져온값 설정한 MenuVO에 넣어주기
	               menu = new menuvo(name, foodtype, country , calory , ingre ,method ,image);
	            //가져온값 설정한 MenuVO를 ArrayList<menuvo> menulist로 넣어주기
	               menulist.add(menu);
	            }
	            
	            
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            DBclose();
	         }
	         //menulist값 리턴
	         return menulist;

	      }
    
    
	}

=======

	public int deleteingri(String id, String ingri) {
		try {
			DBconn();
			String sql = "delete from test_refi where mb_id = ? and ingre_name=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, ingri);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return cnt;
	}

	// 메뉴검색하는기능
	public ArrayList<menuvo> selectmenu(String contry, String type, String kcal) {
		ArrayList<menuvo> menulist = new ArrayList<menuvo>();
		try {
			DBconn();

			String sql = "select * from recipe where  FOOD_TYPE =  ?  and RECIPE_COUNTRY = ? and RECIPE_CALORY<? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, type);
			psmt.setString(2, contry);
			psmt.setString(3, kcal);

			rs = psmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString(2);
				String foodtype = rs.getString(3);
				String country = rs.getString(4);
				String calory = rs.getString(5);
				String ingre = rs.getString(6);
				String method = rs.getString(7);
				String image = rs.getString(8);

				System.out.println("실행");
				System.out.println("name= " + name);
				System.out.println("foodtype= " + foodtype);
				System.out.println("country= " + country);
				System.out.println("calory= " + calory);
				System.out.println("ingre= " + ingre);
				System.out.println("method= " + method);
				System.out.println("image= " + image);
				menu = new menuvo(name, foodtype, country, calory, ingre, method, image);
				menulist.add(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return menulist;

	}

}
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-1/loveRecipe.git
