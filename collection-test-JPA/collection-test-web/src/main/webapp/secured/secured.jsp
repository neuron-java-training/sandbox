<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="<c:url value="/logout"/>">Logout</a>

	<sec:authorize access="hasRole('ADMIN')">
		<h1>ADMIN</h1>
	</sec:authorize>
	<sec:authorize access="hasAuthority('ROLE_USER')">
		<h1>hasAuthority('ROLE_USER')</h1>
	</sec:authorize>
	<sec:authorize access="hasRole('USER')">
		<h1>hasRole('USER')</h1>
	</sec:authorize>

	<sec:authorize access="isRememberMe()">
		<h1>isRememberMe()</h1>
	</sec:authorize>
	<sec:authorize access="!isRememberMe()">
		<h1>no isRememberMe()</h1>
	</sec:authorize>

	UserName:
	<sec:authentication property="principal.username" />
	<br /> Password:
	<sec:authentication property="credentials" />
	<br /> Role:
	<sec:authentication property="authorities" />
	<br />

</body>
</html>