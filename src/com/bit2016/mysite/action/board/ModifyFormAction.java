package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		Long board_no = Long.parseLong(request.getParameter("no"));
//		vo.setNo(Long.parseLong(board_no));
//		vo.setTitle(title);
//		vo.setContent(content);

		BoardDao dao = new BoardDao();
		vo = dao.getView(board_no);
		request.setAttribute("vo", vo);
		
		
		WebUtil.forword(request, response, "/WEB-INF/views/board/modify.jsp");

	}

}
