
<html>
<head>
	<title>Login</title>
	<link href="resources/style/styles.css" rel="stylesheet" type="text/css">
</head>
<body onload="pop_msg()">
	<main class="login">
		<div class="login_column">
			<img src="resources/images/kakao.png">
		</div>
		<div class="login_column">
			<form method="post" action="login">
				<input type="text" name="userid" id="userid" placeholder="Kakao Account(E-mail)"><br>
				<input type="password" name="password" id="password" placeholder="Password"><br>
				<input type="submit" value="Login" onclick="return pop_check()">
			</form>
		</div>
		<div class="login_column">
			<button type="button" class="find_pass">did you forget your password?</button>
		</div>
	</main>
	<input type="hidden" id="msg" value="${msg }">
	
	<script type="text/javascript">
		function pop_msg(){
			var str = document.getElementById('msg').value;
			if(str.length>0){
				alert(str);
			}
		}
		
		function pop_check(){
			var userid = document.getElementById('userid').value;
			var password = document.getElementById('password').value;
			
			if(userid.length<=0){
				alert("please input your id in idbox");
				return false;
			}else if(password.length<=0){
				alert("please input your password in passwordbox");
				return false;
			}
			return true;
			
		}
	</script>
	
	
	<%@include file="screensaver.jsp" %>
</body>
</html>
