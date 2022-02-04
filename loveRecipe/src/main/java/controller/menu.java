package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class menu extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 public ArrayList<menu> getBoardList(HashMap<String, Object> listOpt)
		    {
		        ArrayList<menu> list = new ArrayList<menu>();
		        
		        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
		        String condition = (String)listOpt.get("condition"); // 검색내용
		        int start = (Integer)listOpt.get("start"); // 현재 페이지번호
		        
		        try {
		            conn = DBConnection.getConnection();
		            StringBuffer sql = new StringBuffer();
		            
		            // 글목록 전체를 보여줄 때
		            if(opt == null)
		            {
		                // BOARD_RE_REF(그룹번호)의 내림차순 정렬 후 동일한 그룹번호일 때는
		                // BOARD_RE_SEQ(답변글 순서)의 오름차순으로 정렬 한 후에
		                // 10개의 글을 한 화면에 보여주는(start번째 부터 start+9까지) 쿼리
		                // desc : 내림차순, asc : 오름차순 ( 생략 가능 )
		                sql.append("select * from ");
		                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
		                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_COUNT, BOARD_RE_REF");
		                sql.append(", BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_DATE ");
		                sql.append("FROM");
		                sql.append(" (select * from MEMBER_BOARD order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
		                sql.append("where rnum>=? and rnum<=?");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setInt(1, start);
		                pstmt.setInt(2, start+9);
		                
		                // StringBuffer를 비운다.
		                sql.delete(0, sql.toString().length());
		            }
		            else if(opt.equals("0")) // 제목으로 검색
		            {
		                sql.append("select * from ");
		                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
		                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
		                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
		                sql.append("FROM ");
		                sql.append("(select * from MEMBER_BOARD where BOARD_SUBJECT like ? ");
		                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
		                sql.append("where rnum>=? and rnum<=?");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setInt(2, start);
		                pstmt.setInt(3, start+9);
		                
		                sql.delete(0, sql.toString().length());
		            }
		            else if(opt.equals("1")) // 내용으로 검색
		            {
		                sql.append("select * from ");
		                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
		                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
		                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
		                sql.append("FROM ");
		                sql.append("(select * from MEMBER_BOARD where BOARD_CONTENT like ? ");
		                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
		                sql.append("where rnum>=? and rnum<=?");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setInt(2, start);
		                pstmt.setInt(3, start+9);
		                
		                sql.delete(0, sql.toString().length());
		            }
		            else if(opt.equals("2")) // 제목+내용으로 검색
		            {
		                sql.append("select * from ");
		                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
		                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
		                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
		                sql.append("FROM ");
		                sql.append("(select * from MEMBER_BOARD where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? ");
		                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
		                sql.append("where rnum>=? and rnum<=?");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setString(2, "%"+condition+"%");
		                pstmt.setInt(3, start);
		                pstmt.setInt(4, start+9);
		                
		                sql.delete(0, sql.toString().length());
		            }
		            else if(opt.equals("3")) // 글쓴이로 검색
		            {
		                sql.append("select * from ");
		                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
		                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
		                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
		                sql.append("FROM ");
		                sql.append("(select * from MEMBER_BOARD where BOARD_ID like ? ");
		                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
		                sql.append("where rnum>=? and rnum<=?");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setInt(2, start);
		                pstmt.setInt(3, start+9);
		                
		                sql.delete(0, sql.toString().length());
		            }
		            
		            rs = pstmt.executeQuery();
		            while(rs.next())
		            {
		                BoardBean board = new BoardBean();
		                board.setBoard_num(rs.getInt("BOARD_NUM"));
		                board.setBoard_id(rs.getString("BOARD_ID"));
		                board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
		                board.setBoard_content(rs.getString("BOARD_CONTENT"));
		                board.setBoard_file(rs.getString("BOARD_FILE"));
		                board.setBoard_count(rs.getInt("BOARD_COUNT"));
		                board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
		                board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
		                board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
		                board.setBoard_date(rs.getDate("BOARD_DATE"));
		                list.add(board);
		            }
		            
		        } catch (Exception e) {
		            throw new RuntimeException(e.getMessage());
		        }
		        
		        close();
		        return list;


		출처: https://all-record.tistory.com/129 [세상의 모든 기록]