package com.bit2016.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2016.mysite.dao.BoardDao;
import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.BoardVo;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 세션받아오기
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		UserVo userVo = new UserDao().get(authUser.getNo());
		// ---
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setHit(0l);
		if (!"nothing".equals(request.getParameter("board_no"))) {
			Long getno = Long.parseLong(request.getParameter("board_no"));
			System.out.println("파마미터 받음");
			
			BoardDao dao2 = new BoardDao();
			BoardVo vo2 = new BoardVo();
			vo2 = dao2.getView(getno);
			vo.setGroup_no(vo2.getGroup_no()-1);
			vo.setOrder_no(vo2.getOrder_no()+1L);
			vo.setDepth(vo2.getDepth()+1L);

		} else {
			System.out.println("파마미터 안받음");
			vo.setOrder_no(0l);
			vo.setDepth(0l);
		}
		vo.setUsers_no(userVo.getNo());

		BoardDao dao = new BoardDao();
		dao.write(vo);
		WebUtil.redirect(request, response, "/mysite3/board");
		// WebUtil.forword(request, response, "/WEB-INF/views/board/write.jsp");
	}

}
