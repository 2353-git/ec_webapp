<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css">
</head>
<body>


<header class="page-header wrapper">
	<h1><a href="login.jsp">stationery shop</a></h1>
</header>
<div class="page-title"><h1>ログイン</h1>
<p style="color:red;">${message}</p></div>

<div class="container2 wrapper">
	<form action="Login.action" method="post">
	<div class="form">

		<p style="color:red;">${umsg}</p>
		<input type="text" name="name" class="f" placeholder="ユーザー名を入力">

	</div>
	<div class="form">

	<p style="color:red;">${pmsg}</p>
		<input type="password" name="password" id="password" class="f" placeholder="パスワードを入力">

	</div>

	<button type="submit" id="l-btn">ログイン</button>

	</form>

</div>



</body>
</html>