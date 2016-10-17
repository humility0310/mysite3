<%@ page import="com.bit2016.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserVo authUser = (UserVo) session.getAttribute("authUser");
%>
<div id="header">
	<h1>
		<a href="/mysite">MySite</a>
	</h1>
	<ul>
		<%
			if (authUser == null) {
		%>
		<li><a href="/mysite3/user?a=loginform">로그인</a>
		<li>
		<li><a href="/mysite3/user?a=joinform">회원가입</a>
		<li>
			<%
				} else {
			%>
		
		<li><a href="/mysite3/user?a=modifyform">회원정보수정</a>
		<li>
		<li><a href="/mysite3/user?a=logout">로그아웃</a>
		<li>
		<li>님 안녕하세요 ^^;</li>
		<%
			}
		%>
	</ul>
</div>