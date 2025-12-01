<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品更新</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<header class="page-header wrapper">
	<h1><a href="ProductListPage.action">stationery shop</a></h1>
	<ul class="main-nav">
		<li><a href="InsertPage.action">商品新規登録</a></li>
		<li><a href="Logout.action" id="logout">ログアウト</a></li>
	</ul>
</header>
<div class="page-title"><h1>商品一覧表</h1></div>

<div class="wrapper">
	<table class="product-table">
	<tr>
		<th>No</th>
        <th>商品名</th>
        <th>価格(\)</th>
        <th>在庫数</th>
        <th >商品説明</th>
	</tr>
	<c:forEach var="product" items="${list}">
	<tr>
        <td align="center">${product.id }</td>
        <td align="left" ><a href="DetailPage.action?id=${product.id}">${product.name }</a></td>
        <td align="right" class="pc">${product.price }</td>
        <td align="right" class="sc">${product.stock }</td>
        <td align="left" class="tt" style="white-space: pre-wrap;">${product.text }</td>
	</tr>
	</c:forEach>

</table>
</div>

</body>
</html>


