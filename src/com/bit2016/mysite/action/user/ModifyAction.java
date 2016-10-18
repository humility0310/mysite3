package com.bit2016.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		System.out.println("no : "+no);
		System.out.println("name : "+name);
		System.out.println("password : "+password);
		System.out.println("gender : "+gender);

		UserVo vo = new UserVo();
		vo.setNo(Long.parseLong(no));
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);

		UserDao dao = new UserDao();
		dao.modify(vo);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", vo);
		WebUtil.redirect(request, response, "/mysite3/user?a=modifysuccess");
	}

}
