<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>상품 목록</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="btn btn-primary float-end"
            	onclick="location.href='/product/addProductForm'" 
	             type="button">
                상품 등록
            </button>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>상품명</th>
                <th>가격</th>
            </tr>
            </thead>
            <tbody>
            	<tr>
		            <td>
		                1
		            </td>
		            <td>
		                <a href="/product/detail/1">상품 A</a>
		            </td>
		            <td>
		                2,000
		            </td>
		        </tr>
		        <tr>
		            <td>
		                2
		            </td>
		            <td>
		                <a href="/product/detail/2">상품 B</a>
		            </td>
		            <td>
		                4,000
		            </td>
		        </tr>
            </tbody>
        </table>
    </div>
</div> 
</body>
</html>
   