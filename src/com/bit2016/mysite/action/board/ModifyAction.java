package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Long board_no = Long.parseLong(request.getParameter("no"));
		 String title = request.getParameter("title");
		 String content = request.getParameter("content");
		 BoardDao dao = new BoardDao();
		 BoardVo vo = new BoardVo();
		
//		 System.out.println("board_no:" + board_no);
//		 System.out.println("title" + title);
//		 System.out.println("content" + content);
//		System.out.println("hellomodify");
		 vo.setNo(board_no);
		 vo.setTitle(title);
		 vo.setContent(content);
		 dao.modify(vo);

		WebUtil.redirect(request, response, "/mysite3/board");

	}

}
