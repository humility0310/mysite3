package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long board_no = Long.parseLong(request.getParameter("no"));
		 BoardDao dao = new BoardDao();
		
		 System.out.println("board_no:" + board_no);
		 dao.delete(board_no);
//		
		WebUtil.redirect(request, response, "/mysite3/board");
	}

}
