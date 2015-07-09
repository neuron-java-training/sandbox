<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body bgcolor="#ffffff">
	<form method="POST" action="j_security_check">
		<c:if test="${param.error}">
		<font color="red">Hibás felhasználónév vagy jelszó!</font>
		</c:if>
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password"></td>
			</tr>
		</table>
		<input type="submit" value="Login!">
	
	</form>
</body>
</html>