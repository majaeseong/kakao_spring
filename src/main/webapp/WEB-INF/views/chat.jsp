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
		<a href="chats">
			<div class="back_arrow">
				<i class="fa fa-arrow-left"></i>
			</div>
		</a>
		<div class="contact_person">
			<img src="resources/images/avartar.jpg">
			<div class="contact_person_main">
				<div class="contact_person_name">${contact_member.name }</div>
					<input type="hidden" id="contact_member_name" value="${contact_member.name }">
				<div class="contact_person_status">${contact_member.statusmsg }</div>
			</div>
		</div>
		<div class="contact_person_setting">
			<i class="fa fa-bars"></i>
		</div>
	</div>

	<div class="chat_main">
		<div class="chat_scroll" id="chat_scroll">

			<%-- <c:forEach var="l" items="${chatList }">
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
			</c:forEach> --%>

		</div>
	</div>
	<form method="post" action="addChatText">
		<div class="chat_input">
			<input type="hidden" name="send_id" id="send_id" value="${login_member.id }">
			<input type="hidden" name="res_id" id="res_id" value="${contact_member.id }">
			<textarea rows="4" cols="100" class="chat_input_text" name="content" id="content"></textarea>
			<input type="submit" value="Send" class="chat_input_button">
		</div>
	</form>
		<input type="hidden" id="last_chat_id">
	</main>

	<%@include file="screensaver.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			// Handler for .ready() called.
			getAllChat();
			document.getElementById("content").focus();
			getLastChat();
		});
		
		 function getLastChat(){
			var send_id=document.getElementById('send_id').value; //login id
			var res_id=document.getElementById('res_id').value;
			var contact_member_name = document.getElementById('contact_member_name').value;
			setInterval(function(){
				
				var last_id_url="last_chat?id_1="+send_id+"&id_2="+res_id;
				
				$.get(last_id_url, function(data,status){
					if(status!=='success'){
				 		return;
				 	}
					var current_id=document.getElementById('last_chat_id').value;
					if(data!=current_id){
						getAllChat();
						
					}
					
				});
				
				
			},1000);
		}
		 function getAllChat(){
			 var send_id=document.getElementById('send_id').value; //login id
			 var res_id=document.getElementById('res_id').value;
			 var url="chatlist?id_1="+send_id+"&id_2="+res_id;
				
				$.get(url, function(data,status){
				 	if(status!=='success'){
				 		return;
				 	}
				 	var last_id=0;
				 	var tx="";
				 	data.forEach(function(obj){
				 		if(obj.send_id!=send_id){
				 			tx+="<div class='contact_person'>"
				 			+"<img src='resources/images/avartar.jpg'>"
				 			+"<div class='contact_person_main'>"
				 			+"<div class='contact_person_name'>"+contact_member_name.value+"</div>"
				 			+"<div class='contact_person_msg'>"+obj.content+"</div>"
				 			+"</div>"
				 			+"<div class='contact_msg_time'>"+new Date(obj.r_time).toUTCString()+"</div>"
				 			+"</div>";
				 			last_id=obj.id;
				 			console.log(new Date(obj.r_time).toUTCString());
				 		}
				 		else {
				 			tx+="<div class='send_person'>"
				 			+"<div class='send_msg_time'>"+new Date(obj.r_time).toUTCString()+"</div>"
				 			+"<div class='send_person'>"
				 			+"<div class='send_person_main'>"
				 			+"<div class='send_person_msg'>"+obj.content+"</div>"
				 			+"</div>"
				 			+"</div>"
				 			+"</div>";
				 			last_id=obj.id;
				 		}
				 	});
				 	
				 	$('#chat_scroll').append(tx);
					document.getElementById('last_chat_id').value=last_id;
					
					$('html, body').animate({
						scrollTop : $('#chat_scroll')[0].scrollHeight
					}, 100); 
				});
		 }
	</script>
</body>
</html>