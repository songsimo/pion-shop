<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Root 템플릿</title>
<%
	String content = request.getParameter("content");

	if(content == null || "".equals(content)){
		content = "product/productList.jsp";
	}
%>
</head>
<body>
	<%@ include file="header.jsp" %>
	<jsp:include page="<%= content %>"></jsp:include>
	<%@ include file="footer.jsp" %>
</body>
</html>