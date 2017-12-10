<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="bookroom.heading" />
	</h1>
	<h3>Available Rooms</h3>
	<c:forEach items="${model.availableRooms}" var="room">
		<c:out value="${room.roomNumber}" />
		<i><c:out value="${room.type}" /></i>
		<i>$<c:out value="${room.price}" /></i>
		<i><c:out value="${room.booked}" /></i>
		<input type="submit" align="center" value="Book">
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="hello.htm"/>">Home</a>
	<br>
</body>
</html>