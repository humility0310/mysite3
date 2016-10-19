package com.bit2016.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestBookDao;
import com.bit2016.mysite.vo.GuestBookVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// delete 요청 처리

		String no = request.getParameter("no");
		String password = request.getParameter("password");

		GuestBookDao dao = new GuestBookDao();

		GuestBookVo vo = new GuestBookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		dao.delete(vo);

		// 리다이렉트
		WebUtil.redirect(request, response, "/mysite3/guestbook");

	}

}
