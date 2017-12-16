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
		<br>
		<br>
	</c:forEach>
	<form:form method="post" modelAttribute="bookRoom">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">Room Number:</td>
				<td width="20%"><form:input path="roomNumber" /></td>
				<td width="60%"><form:errors path="roomNumber" cssClass="error" />
				</td>
				</td>
			</tr>
		</table>
		<input type="submit" align="center" value="Book">
	</form:form>
	<br>
	<a href="<c:url value="hello.htm"/>">Home</a>
	<br>
</body>
</html>