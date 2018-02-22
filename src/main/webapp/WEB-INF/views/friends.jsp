
<html>
<head>
<title>Friends</title>

</head>
<body>
	<main class="friends">
	<%@include file="nav.jsp" %>

	<div class="friends_list">
		<div class="f_list_header">
			<span class="f_list_header_title">Friends</span>
		</div>
		<div class="f_list_main">
			<div class="f_main_list">
				<span class="f_list_main_title">My Profile</span>
			</div>	
			<a href="profile">
				<div class="f_main_user">
					<div class="f_main_user_image"><img src="resources/images/avartar.jpg">Jaewon</div>
					<div class="f_main_user_status">Status Message</div>
				</div>
			</a>
			
			<div class="f_main_list">
				<span class="f_list_main_title">Friends</span>
			</div>
			
			<a href="profile">
				<div class="f_main_user">
					<div class="f_main_user_image"><img src="resources/images/avartar.jpg">    Name</div>
					<div class="f_main_user_status">Status Message</div>
				</div>
			</a>
		</div>
	</div>
	</main>
</body>
</html>
