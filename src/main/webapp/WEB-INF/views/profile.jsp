<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Profile</title>
	<link href="resources/style/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<main class="profile">
		<div class="profile_background">
			
		</div>
		<div class="profile_menu">
			<div class="profile_bottom">
				<div class="profile_name">${profile_member.name }</div>
				<div class="profile_menu_options">
					<div class="profile_menu_option">
						<c:if test="${profile_member.id!= login_member.id}">
							<a href="chat?id=${profile_member.id }">
								<i class="fa fa-comment"></i>
							</a>
							<div class="profile_menu_option_name">Chtting</div>
						</c:if>
						<c:if test="${profile_member.id== login_member.id}">
							<a href="setting?id=${login_member.id }">
								<i class="fa fa-edit"></i>
							</a>
							<div class="profile_menu_option_name">Edit Profile</div>
						</c:if>
					</div>
						<div class="profile_menu_option">
							<c:if test="${profile_member.id!= login_member.id}">
								<i class="fa fa-ban"></i>
								<div class="profile_menu_option_name">Block</div>
							</c:if>
						</div>
					
					<!-- if your own, options will be changed profile setting(fa-edit) -->
				</div>
			</div>
		</div>
		<div class="profile_image">
			<img src="resources/images/avartar.jpg">
		</div>
	</main>
	
	<%@include file="screensaver.jsp" %>
</body>
</html>