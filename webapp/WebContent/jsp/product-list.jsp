<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>商品一覧</title>
<link rel="stylesheet" href="style.css">

</head>
<body>

<header class="page-header wrapper">
	<h1><a href="ProductListPage.action">stationery shop</a></h1>
	<ul class="main-nav">
		<li><a href="ProductTablePage.action">リスト</a></li>
		<li><a href="InsertPage.action">商品新規登録</a></li>
		<li><a href="Logout.action" id="logout">ログアウト</a></li>
	</ul>
</header>

<div class="page-title"><h1>商品一覧</h1><p style="color:red;">${emsg}</p></div>

<div class="wrapper grid">

	<c:forEach var="product" items="${list}">
		<div class="product">
			<a href="DetailPage.action?id=${product.id}"><img src="${product.image}" alt="${product.name}"></a>
		</div>
	</c:forEach>

</div>

<c:if test="${!empty msg}">
<script>
    alert("${msg}");
</script>
</c:if>


</body>
</html>