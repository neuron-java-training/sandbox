<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/menu.css" 
type="text/css" media="screen" />	
<ul>
	<li><a href="<%=request.getContextPath()%>/secured/ajaxuser.jsp">User</a></li>
	<li><a href="<%=request.getContextPath()%>/secured/admin/ajaxadmin.jsp">Admin</a></li>
	<li><a href="/online/LogOutServlet">LogOut</a></li>
</ul>
