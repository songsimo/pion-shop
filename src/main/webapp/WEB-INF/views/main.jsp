<%--
  Created by IntelliJ IDEA.
  User: ingyu
  Date: 2023/01/26
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Root 템플릿</title>
	<%
		String content = request.getParameter("content");

		if (content == null || "".equals(content)) {
			content = "product/productList.jsp";
		}
	%>
</head>
<body>
<%--static way--%>
	<%@include file="header.jsp"%>
	<jsp:include page="<%= content %>"/>
	<%@include file="footer.jsp"%>
</body>
</html>