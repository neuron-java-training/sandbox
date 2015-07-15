<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Please login to CollectionTester</title>
<style type="text/css">
input[type=text], input[type=password] {
	display: block;
}

#container {
	position: absolute;
	top: 35%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<center>
		<div id="container">
			<h1>Please login</h1>

			<p>The information you provided was incorrect, please check the credentials and try again.</p>

			<form action="j_security_check" method="post" name="loginForm">
				<table>
					<tr>
						<td><label for="user">User name:</label></td>
						<td><input id="user" type="text" name="j_username" size="20"></td>
					</tr>
					<tr>
						<td><label for="password">Password </label></td>
						<td><input id="password" type="password" name="j_password" size="20"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input type="submit" value="Login"></td>
					</tr>
				</table>

			</form>

		</div>

	</center>
</body>
</html>