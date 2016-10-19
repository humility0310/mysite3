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

public class BoardListAction implements Action {
	
//	checkIntParam()
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Long pagenum = Long.parseLong(request.getParameter("page"));
//		
//		if (pagenum == null) {
//			WebUtil.redirect(request, response, "/mysite3/user?a=&pagenum=1");
//			return;// 주의: redirect를 한 후 다음 코드가 실행되지 않도록 함수 종료
//		}
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList(1l);

//		request.setAttribute("pagecount", dao.pageCount());
//		request.setAttribute("pagecounter", 1l);
		request.setAttribute("list", list);

		// 리다이렉트
		WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
//		WebUtil.redirect(request, response, "/mysite3/board");
//		WebUtil.redirect(request, response, "/mysite3/board?pagenum=1");
	}
}
