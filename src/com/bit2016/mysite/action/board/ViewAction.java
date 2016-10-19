package com.bit2016.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long board_no = Long.parseLong(request.getParameter("board_no"));

		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo = dao.getView(board_no);
		request.setAttribute("BoardVo", vo);

		WebUtil.forword(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
