package com.bit2016.mysite.action.board.test;

import java.util.List;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;

public class Test {

	public static void main(String[] args) {
		// getListTest();
		// pageCountTest();
		// viewTest();
		writeTest();
	}

	public static void writeTest() {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		// pstmt.setString(1, vo.getTitle());
		// pstmt.setString(2, vo.getContent());
		// pstmt.setLong(3, vo.getHit());
		// pstmt.setLong(4, vo.getGroup_no());
		// pstmt.setLong(5, vo.getDepth());
		// pstmt.setLong(6, vo.getUsers_no());
		vo.setTitle("타이틀");
		vo.setContent("내용");
		vo.setHit(0l);
		vo.setGroup_no(2l);
		vo.setDepth(0l);
		vo.setUsers_no(1l);

		dao.write(vo);
	}

	public static void viewTest() {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo = dao.getView(3L);
		System.out.println(vo);
	}

	public static void pageCountTest() {

		BoardDao dao = new BoardDao();
		System.out.println("count:" + dao.pageCount());
	}

	public static void getListTest() {

		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList(2l);

		for (BoardVo vo : list) {
			System.out.println(vo);
		}
	}
}
