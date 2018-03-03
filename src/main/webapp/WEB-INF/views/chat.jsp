<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Chat</title>
	<link href="resources/style/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<main class="chat">
		<div class="chat_header">
			<div class="contact_person">
				<img src="resources/images/avartar.jpg">
				<div class="contact_person_main">
					<div class="contact_person_name">${contact_member.name }</div>
					<div class="contact_person_status">${contact_member.statusmsg }</div>
				</div>
			</div>
			<div class="contact_person_setting">
				<i class="fa fa-bars"></i>
			</div>
		</div>
		
		<div class="chat_main">
			<div class="chat_scroll">
			
				<c:forEach var="l" items="${chatList }">
					<c:choose>
						<c:when test="${login_member.id!=l.send_id }">
							<div class="contact_person">
								<img src="resources/images/avartar.jpg">
								<div class="contact_person_main">
									<div class="contact_person_name">${contact_member.name }</div>
									<div class="contact_person_msg">${l.content }</div>
								</div>
								<div class="contact_msg_time">${l.r_time }</div>
							</div>
						</c:when>
						
						<c:otherwise>
							<div class="send_person">
								<div class="send_msg_time">${l.r_time }</div>
								<div class="send_person">
									<div class="send_person_main">
										<div class="send_person_msg">${l.content }</div>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
			</div>
		</div>
		
		<div class="chat_input">
			<textarea rows="4" cols="100" class="chat_input_text"></textarea>
			<input type="button" value="Send" class="chat_input_button">
		</div>
	</main>
	
	<%@include file="screensaver.jsp" %>
</body>
</html>