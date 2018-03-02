<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Chats</title>
</head>
<body>
	<main class="chats">
		<%@include file="nav.jsp" %>
	
		<div class="chats_list">
			<div class="chats_header">
				<div class="chats_header_title">Chatting</div>
				<div class="chats_header_plus">
					<i class="fa fa-comment"></i>
				</div>
			</div>
			<div class="chats_scroll">
				<div class="chats_main">
				
					<c:forEach var="l" items="${chats_list }">
					<a href="chat?id=${l.id }">
						<div class="chats_chat">
							<div class="chats_user_image">
								<img src="resources/images/avartar.jpg">
								<div class="chats_user_name_content">
									<div class="chats_user_name">
										${l.name}
									</div>
									<div class="chats_user_content">
										${l.content }
									</div>
								</div>
							</div>
							<div class="chats_user_time">
								${l.r_time }
							</div>
						</div>
					</a>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</main>
</body>
</html>
