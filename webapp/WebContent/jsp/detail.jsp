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
<div class="page-title"><h1>商品詳細</h1></div>

<div class="container wrapper">
	<div class="product-img">
		<img src="${product.image}" id="img-main" alt="商品名">
		<pre class="description">${product.text}</pre>
	</div>
	<div class="product-text">
		<h2>${product.name }</h2>
		<p class="tprice">\ ${product.price} <span>(税込)</span></p>
		<p class="tstock">在庫数: ${product.stock}</p>

		<form action="Cart.action?id=${product.id}" method="post">

			<div class="selector">
    			<button type="button" class="s-btn" id="min">−</button>
    			<input type="number" name="quantity" id="quantity" value="1" min="1">
    			<button type="button" class="s-btn" id="plus">＋</button>
  			</div>
			<button type="submit" id="c-btn">カートに追加</button>
		</form>
	</div>
</div>
<div class="s">
<div class="u">
	<button id="upd" class="btn" onclick="location.href='UpdatePage.action?id=${product.id}'">更新</button>
	<button id="delete" class="btn"
	onclick="if(confirm('この商品を削除しますか?')) { location.href='Delete.action?id=${product.id}'; } return false;">
	削除
	</button>
</div>
</div>

<c:if test="${!empty msg}">
<script>
    alert("${msg}");
</script>
</c:if>
<script>
	document.getElementById('min').addEventListener("click", function (){
		const q = document.getElementById("quantity");
		const c = parseInt(q.value);
		if (c > 1) {
			q.value = c - 1;
		}
	});

	document.getElementById("plus").addEventListener("click", function (){
		const q = document.getElementById("quantity");
		q.value = parseInt(q.value) + 1;
	});

	const a = document.getElementById("c-btn")
		a.addEventListener("click", () => {
		alert("カートに追加しました。");
	});
</script>

</body>
</html>