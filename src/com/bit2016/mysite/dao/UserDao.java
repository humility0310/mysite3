package com.bit2016.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit2016.mysite.vo.UserVo;

public class UserDao {
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

	// 로그인 인증용
	public UserVo get(String email, String password) {
		UserVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "SELECT no, name FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);

			}

		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return vo;

	}

	// 회원정보 수정시 사용

	public UserVo get(Long no) {
		UserVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "SELECT no, name, email, gender FROM USERS WHERE no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				String email = rs.getString(3);
				String gender = rs.getString(4);

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);

			}

		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return vo;
	}

	public void modify(UserVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();
			String sql = "UPDATE USERS SET NAME=? , PASSWORD=?, GENDER=? WHERE NO=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setLong(4, vo.getNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		System.out.println("완료");
	}

	public void insert(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = getConnection();
			String sql = "INSERT INTO USERS VALUES (user_seq.NEXTVAL, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
	}
}
