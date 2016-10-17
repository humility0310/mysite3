package com.bit2016.mysite.dao.test;

import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.UserVo;

public class DaoTest {

	public static void main(String[] args) {
		// insertTest();
		// getListTest();
		modifyTest();

	}

	public static void modifyTest() {

		UserVo vo = new UserVo();
		vo.setNo(2L);
		vo.setName("44");
		vo.setPassword("44");
		vo.setGender("male");
	

		UserDao dao = new UserDao();
		dao.modify(vo);
	}

}
