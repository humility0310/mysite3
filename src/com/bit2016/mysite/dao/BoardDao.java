package com.bit2016.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.mysite.vo.BoardVo;

public class BoardDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		}
		return conn;
	}

	//
	public BoardVo getView(long board_no) {

		BoardVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "SELECT title, content, USERS_NO from BOARD WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, board_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String title = rs.getString(1);
				String content = rs.getString(2);
				Long USERS_NO = rs.getLong(3);

				vo = new BoardVo();
				vo.setNo(board_no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setUsers_no(USERS_NO);
			}

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				System.out.println("error2 :" + e2);
			}
		}
		return vo;
	}

	//
	// private void delete() {
	//
	// }
	//
	// private void modify() {
	//
	// }
	//

	public void write(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			String sql = "INSERT INTO BOARD VALUES(board_seq.NEXTVAL, ?, ?, sysdate, ?, ?, NVL ( (SELECT MAX (group_no) FROM BOARD), 0) + 1, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getHit());
			pstmt.setLong(4, vo.getGroup_no());
			pstmt.setLong(5, vo.getDepth());
			pstmt.setLong(6, vo.getUsers_no());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("error :" + e2);
			}
		}
	}

	public long pageCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long result = null;
		try {
			conn = getConnection();

			String sql = "SELECT COUNT (*) FROM BOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return result % 5 + 1;
	}

	public List<BoardVo> getList(long p) {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "  SELECT * " + "FROM (SELECT ROWNUM AS rn, no, title, hit, reg_date, name, depth, users_no "
					+ "FROM (  SELECT a.no, a.title, a.hit, TO_CHAR (a.reg_date, 'yyyy-mm-dd hh:mi:ss') AS reg_date, b.NAME, a.users_no, a.depth "
					+ "FROM BOARD a, USERS b WHERE a.USERS_NO = b.NO " + "ORDER BY a.GROUP_NO DESC, order_no ASC)) "
					+ "WHERE (? - 1) * 5 + 1 <= rn AND rn <= ? * 5";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, p);
			pstmt.setLong(2, p);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				Long no = rs.getLong(2);
				String title = rs.getString(3);
				Long hit = rs.getLong(4);
				String date = rs.getString(5);
				String name = rs.getString(6);
				Long depth = rs.getLong(7);
				Long users_no = rs.getLong(8);

				BoardVo vo = new BoardVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setHit(hit);
				vo.setReg_date(date);
				vo.setUser_name(name);
				vo.setDepth(depth);
				vo.setUsers_no(users_no);

				list.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				System.out.println("error2 :" + e2);
			}
		}
		return list;
	}
}
