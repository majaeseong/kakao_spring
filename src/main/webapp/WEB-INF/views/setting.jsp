
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
			<div class="setting_profile">
				<div class="setting_profile_image">
					<img src="resources/images/avartar.jpg">
					<div class="stting_profile_name">
						<div class="setting_name">Name</div>
						<input type="text" name="name" value="Jaewon" class="set_name">
					</div>
				</div>
				<div class="setting_profile_status">
					<div class="setting_profile_status_title">Status</div>
					<textarea rows="2" cols="35" class="setting_status">Hi</textarea>
				</div>
				<input type="button" value="Apply" class="setting_submit_button">
			</div>
		</div>
	</main>
</body>
</html>
