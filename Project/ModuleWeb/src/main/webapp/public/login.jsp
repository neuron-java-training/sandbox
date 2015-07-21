<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload="document.loginForm.username.focus();">



	<div id="login-box">

		<h3>Login</h3>

		<c:if test="${not empty param.error}">
			<div class="error">Wrong password</div>
		</c:if>

		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="post">

			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Remember Me:</td>
					<td><input type="checkbox" name="remember-me" /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="Login" /></td>
					<td><a href="<c:url value="/public/registration.jsp"/>">Registration</a></td>
				</tr>
				
			</table>
		</form>
	</div>

</body>
</html>