<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title Here</title>
</head>
<%
    String name = (String) request.getAttribute("name");
%>
<body>

<%=name%>
</body>
</html>