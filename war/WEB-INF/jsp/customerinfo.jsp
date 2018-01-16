<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="customer.heading" />
	</h1>
	<form:form method="post" modelAttribute="addCustomer">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td align="right" width="20%">First Name:</td>
				<td width="20%"><form:input path="firstName" /></td>
				<td width="60%"><form:errors path="firstName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Last Name:</td>
				<td width="20%"><form:input path="lastName" /></td>
				<td width="60%"><form:errors path="lastName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Email:</td>
				<td width="20%"><form:input path="email" /></td>
				<td width="60%"><form:errors path="email" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Phone Number:</td>
				<td width="20%"><form:input path="phoneNumber" /></td>
				<td width="60%"><form:errors path="phoneNumber" cssClass="error" />
				</td>
			</tr>
		</table>
		<input type="submit" align="center" value="Add">
	</form:form>
	<br>
	<a href="<c:url value="hello.htm"/>">Home</a>
	<br>
</body>
</html>