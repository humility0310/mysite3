package com.bit2016.mysite.action.board.test;

import java.util.List;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;

public class Test {

	public static void main(String[] args) {
		// getListTest();
		// pageCountTest();
		viewTest();
	}
	
	public static void viewTest()
	{
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
