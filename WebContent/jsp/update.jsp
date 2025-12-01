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

		<li><a href="Logout.action" id="logout">ログアウト</a></li>
	</ul>
</header>
<div class="page-title"><h1>商品更新</h1></div>

<div class="wrapper">
	<form action="Update.action" id="update-form" method="post">
		<table class="update-table">
		<tr>
			<th class="label">項目</th>
			<th class="before">変更前</th>
			<th class="after">変更後</th>
		</tr>
		<tr>
			<td class="lbl">商品画像</td>
			<td class="col" id="curr"><img src="${product.image}" id="current-img" alt="現在の商品画像" class="preview"></td>
			<td class="col">
				<input type="file" name="image" class="f" id="inimg" accept=".jpg, .jpeg, .png">

				<img src="img/haikei.png" alt="プレビュー画像" id="pvimg" class="preview">


			</td>
		</tr>
		<tr>
			<td class="lbl">商品名</td>
			<td class="col">${product.name}</td>
			<td class="col"><input type="text" name="name" class="ft" placeholder="商品名を入力" value="${product.name}">
			<p style="color:red;">${namemsg1}</p><p style="color:red;">${namemsg2}</p></td>
		</tr>
		<tr>
			<td class="lbl">価格</td>
			<td class="col">¥ ${product.price}</td>
			<td class="col"><input type="number" name="price" class="ft" placeholder="価格を入力" value="${product.price}">
			<p style="color:red;">${pricemsg}</p>
			<p style="color:red;">${pricemsg2}</p></td>
		</tr>
		<tr>
			<td class="lbl">在庫</td>
			<td class="col">${product.stock}</td>
			<td class="col"><input type="number" name="stock" class="ft" placeholder="在庫数を入力" value="${product.stock}">
			<p style="color:red;">${stockmsg}</p>
			<p style="color:red;">${stockmsg2}</p></td>
		</tr>
		<tr>
		<td class="lbl">商品説明</td>
			<td class="col"><pre class="ttext">${product.text}</pre></td>
			<td class="col"><textarea name="text" class="ft" placeholder="商品説明を入力">${product.text}</textarea>
			<p style="color:red;">${textmsg}</p></td>
		</tr>

		</table>
		<input type="hidden" name="id" value="${product.id}">

		<div class="u">
			<button type="submit" id="u-submit" class="btn">更新</button>
			<button class="btn" formaction="DetailPage.action?id=${product.id}">戻る</button>
		</div>
	</form>
</div>

<script>
document.addEventListener("DOMContentLoaded", function () {
	const inputimg = document.getElementById("inimg");
	const preview = document.getElementById("pvimg");

	inputimg.addEventListener("change", function () {
    	const file = this.files[0];
  		if (!file) {
    		return;
    	}

	const reader = new FileReader();
 	reader.onload = function (e) {
    	preview.src = e.target.result;
    };
    reader.readAsDataURL(file);
	});
});
</script>


</body>
</html>