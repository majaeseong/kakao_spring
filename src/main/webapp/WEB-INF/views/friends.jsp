
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
			<a href="profile?id=${login_member.id }">
				<div class="f_main_user">
					<div class="f_main_user_image"><img src="resources/images/avartar.jpg">${login_member.name }</div>
					<div class="f_main_user_status">${login_member.statusmsg }</div>
				</div>
			</a>
			
			<div class="f_main_list">
				<span class="f_list_main_title">Friends</span>
			</div>
			
			<c:forEach var="l" items="${friends_list }">
				<a href="profile?id=${l.id }">
					<div class="f_main_user">
						<div class="f_main_user_image"><img src="resources/images/avartar.jpg"> ${l.name }</div>
						<div class="f_main_user_status">${l.statusmsg }</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
	</main>
	
	<%@include file="screensaver.jsp" %>
</body>
</html>
