<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">				
					<tr>
						<td>[${count-status.index }]</td>
						<c:choose>
						<c:when test="${vo.depth > 0 }">
						<td class="left" style="padding-left:${20*vo.depth}px">
						<img src="${pageContext.request.contextPath }/assets/images/reply.png">
						<a href="${pageContext.request.contextPath }/board?a=view&board_no=${vo.no }">${vo.title }</a></td>
						</c:when>
						<c:otherwise>
						<td class="left"><a href="${pageContext.request.contextPath }/board?a=view&board_no=${vo.no }">${vo.title }</a></td>
						</c:otherwise>
						</c:choose>
						<td>${vo.user_name }</td>
						<td>${vo.hit }</td>
						<td>${vo.reg_date }</td>
						<c:if test="${vo.users_no==authUser.no }"><td><a href="/mysite3/board?a=delete&no=${vo.no }" class="del">삭제</a></td></c:if>
						
					</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="/mysite3/board?page=1">1</a></li>
						<li><a href="/mysite3/board?page=2">2</a></li>
						<li class="/mysite3/board?page=3">3</li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>	
				<c:if test="${authUser.no != null }">		
				<div class="bottom">
					<a href="/mysite3/board?a=writeform" id="new-book">글쓰기</a>
				</div>		</c:if>			
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>