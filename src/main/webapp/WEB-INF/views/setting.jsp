
<html>
<head>
<title>Setting</title>
</head>
<body>
	<main class="setting">
		<%@include file="nav.jsp" %>
	
		<div class="setting_main">
			<div class="setting_header">
				<div class="setting_header_title">Set your profile</div>
			</div>
			<form method="post" action="edit_profile">
				<div class="setting_profile">
					<div class="setting_profile_image">
						<img src="resources/images/avartar.jpg">
						<div class="stting_profile_name">
							<div class="setting_name">Name</div>
							<input type="text" name="name" value="${login_member.name }" class="set_name">
						</div>
					</div>
					<div class="setting_profile_status">
						<div class="setting_profile_status_title">Status</div>
						<textarea rows="2" cols="35" class="setting_status" name="statusmsg">${login_member.statusmsg }</textarea>
					</div>
					<input type="hidden" name="id" value="${login_member.id }">
					<input type="submit" value="Apply" class="setting_submit_button">
					<input type="button" value="LogOut" class="setting_submit_button"
						onclick="return logOut()">
				</div>
			</form>
		</div>
	</main>
	
	<%@include file="screensaver.jsp" %>
	
	<script>
		function logOut(){
			{
	            msg = "do you really wanna Logout..?TT";
	            if (confirm(msg)!=0) {
	            		location.href="logout";
	            } else {
	                return false;
	}
	        }
			
		}
	</script>
</body>
</html>
