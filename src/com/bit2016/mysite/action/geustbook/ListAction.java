package com.bit2016.mysite.action.geustbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.GuestBookDao;
import com.bit2016.mysite.vo.GuestBookVo;
import com.bit2016.web.Action;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// defult action 처리 (리스트 처리)
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();

		// request범위에 model data 저장
		request.setAttribute("list", list);

		// forwarding (request연장, request Dispath)
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
		rd.forward(request, response);

	}

}
