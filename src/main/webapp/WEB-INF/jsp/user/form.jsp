<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
	
	<spring:url value="/user/save" var="saveURL"></spring:url>
	<form:form action="${saveURL}" modelAttribute="userForm" method="POST">
		<form:hidden path="id"/>
		<label>Name</label>
		<form:input path="name"/><br/>
		<button type="submit">Save</button>
	</form:form>
	
</body>
</html>