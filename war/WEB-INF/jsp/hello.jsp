<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
		<c:out value="${model.now}" />
	</p>
	<h3>Rooms</h3>
	<c:forEach items="${model.rooms}" var="room">
		<c:out value="${room.roomNumber}" />
		<i><c:out value="${room.type}" /></i>
		<i>$<c:out value="${room.price}" /></i>
		<i><c:out value="${room.booked}" /></i>
		<br>
		<br>
	</c:forEach>
	<br>
	<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
	<br>
	<br>
	<a href="<c:url value="bookroom.htm"/>">Book a Room</a>
	<br>
	<br>
	<a href="<c:url value="customerinfo.htm"/>">Customer Info</a>
</body>
</html>