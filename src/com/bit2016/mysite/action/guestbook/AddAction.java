package com.bit2016.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestBookDao;
import com.bit2016.mysite.vo.GuestBookVo;
import com.bit2016.web.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// insert 요청 처리

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");

		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);

		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		// 리다이렉트
		response.sendRedirect("/mysite3/guestbook");

	}

}
