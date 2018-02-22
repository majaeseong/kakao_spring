<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Navigation</title>
	<link href="resources/style/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
</body>
</html>
<div class="nav_menu">
	<div class="nav_list">
		<a href="friends"><i class="fa fa-user <c:if test="${select_menu==1}">selected</c:if>"></i></a>
		<a href="chats"><i class="fa fa-comment <c:if test="${select_menu==2}">selected</c:if>"></i></a>
		<a href="more"><i class="fa fa-ellipsis-h <c:if test="${select_menu==3}">selected</c:if>"></i></a>
	</div>

	<div class="nav_list">
		<i class="fa fa-bell"></i>
		<a href="setting"><i class="fa fa-cog <c:if test="${select_menu==4}">selected</c:if>"></i></a>
	</div>
</div>

<!-- use c_if , change class :selected: -->