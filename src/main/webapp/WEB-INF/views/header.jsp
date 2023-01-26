<%--
  Created by IntelliJ IDEA.
  User: ingyu
  Date: 2023/01/26
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Header 영역</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-black">
		<div class="container-fluid">
			<button
					class="navbar-toggler"
					type="button"
					data-mdb-toggle="collapse"
					data-mdb-target="#navbarExample01"
					aria-controls="navbarExample01"
					aria-expanded="false"
					aria-label="Toggle navigation"
			>
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarExample01">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link text-white" href="#">상품</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="#">장바구니</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="#">로그인</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Navbar -->
</header>
</body>
</html>