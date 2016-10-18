package com.bit2016.mysite.action.geustbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class DeleteformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deleteform 요청 처리

		WebUtil.forword(request, response, "/WEB-INF/views/deleteform.jsp");

	}

}
