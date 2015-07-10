<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Please login to CollectionTester</title>
    <style type="text/css">
        input[type=text], input[type=password] {
            display: block;
        } 
    </style>
</head>
<body>
<h1>Please login</h1>

<p>The page you have selected requires that you login to proceed.</p>

<form action="j_security_check" method="post" name="loginForm">
    <label for="user">User name:</label>
    <input id="user" type="text" name="j_username" size="20">

    <label for="password">Password </label>
    <input id="password" type="password" name="j_password" size="20">

    <input type="submit" value="Login">
</form>
</body>
</html>