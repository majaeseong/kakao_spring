<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Login</title>
	<link href="resources/style/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<main class="login">
		<div class="login_column">
			<img src="resources/images/kakao.png">
		</div>
		<div class="login_column">
			<form method="post" action="">
				<input type="text" name="id" placeholder="Kakao Account(E-mail)"><br>
				<input type="password" name="password" placeholder="Password"><br>
				<input type="submit" value="Login">
			</form>
		</div>
		<div class="login_column">
			<button type="button" class="find_pass">did you forget your password?</button>
		</div>
	</main>
</body>
</html>
