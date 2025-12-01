<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<header class="page-header wrapper">
	<h1><a href="ProductListPage.action">stationery shop</a></h1>
	<ul class="main-nav">
	<li ><a href="CartPage.action" class="cart"><img  src="img/cart.png" alt="カート"> ${!empty count ? count : 0} </a></li>
		<li><a href="Logout.action?path=product-table.jsp" id="logout">ログアウト</a></li>
	</ul>
</header>
<div class="page-title"><h1>カート</h1></div>
<div class="wrapper grid">

	<c:forEach var="product" items="">
		<div class="product">
			<a href="DetailPage.action?id=${product.id}"><img src="${product.image}" alt="${product.name}"></a>
		</div>
	</c:forEach>

</div>




</body>
</html>