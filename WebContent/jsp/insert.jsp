<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品新規登録</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<header class="page-header wrapper">
	<h1><a href="ProductListPage.action">stationery shop</a></h1>
	<ul class="main-nav">

		<li><a href="Logout.action?path=product-list.jsp" id="logout">ログアウト</a></li>
	</ul>
</header>
<div class="page-title"><h1>商品新規登録</h1>${message}</div>

<div class="container2 wrapper">
	<form action="Insert.action" method="post">
	<div class="form">
		<label>商品画像 (必須)</label>
		<p style="color:red;">${imgmsg}</p>
		<input type="file" name="image" class="f" accept=".jpg, .jpeg, .png">
	</div>
	<div class="form">
		<label>商品名 (必須)</label>
		<p style="color:red;">${namemsg1}</p>
		<p style="color:red;">${namemsg2}</p>
		<input type="text" name="name" class="f" placeholder="商品名を入力" value="${name}">
	</div>
	<div class="form">
		<label>価格 (必須)</label>
		<p style="color:red;">${pricemsg}</p>
		<input type="number" name="price" class="f" placeholder="価格を入力" value="${price}">
	</div>
	<div class="form">
		<label>在庫数 (必須)</label>
		<p style="color:red;">${stockmsg}</p>
		<input type="number" name="stock" class="f" placeholder="在庫数を入力" value="${stock}">
	</div>
	<div class="form">
		<label>商品説明</label>
		<p style="color:red;">${textmsg}</p>
		<textarea name="text" class="f" id="rta" placeholder="商品説明を入力" >${text}</textarea>
	</div>
	<button type="submit" id="n-submit" class="r-btn">　登録　</button>
	</form>
</div>

</body>
</html>