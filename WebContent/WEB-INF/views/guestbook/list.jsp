<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite3/guestbook" method="post">
					<input type="hidden" name="a" value="add">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li><c:set var="count" value="${fn:length(list) }" /> <c:forEach
							items="${list }" var="vo" varStatus="status">
							<table width="510" border="1">
								<tr>
									<td>[${count-status.index }]</td>
									<td>${vo.name }</td>
									<td>${vo.reg_day }</td>
									<td><a href="/guestbook3/gb?a=deleteform&no=${vo.no }">삭제</a></td>
								</tr>
								<tr>
									<td colspan="4">${fn:replace(vo.content, newLine, "<br>") }</td>
								</tr>
							</table>
						</c:forEach> <br></li>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/nevigation.jsp">
			<c:param name="menu" value="guestbook" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>