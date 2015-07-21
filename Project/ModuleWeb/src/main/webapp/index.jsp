<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>WebModule</title>
<jsp:include page="header.jsp"></jsp:include>
</head>

<body>
	<h1>Project Web Module</h1>
<!-- 	<a href="secured/secured.jsp">Secured</a> -->
<%-- 	<a href="<c:url value="/logout"/>">Logout</a> --%>

	<c:import url="/secured/admin/NewTestScript.jsp"></c:import>

	<c:import url="/GetTestResultScript.jsp"></c:import>
	<c:import url="/GetAvgTestResultScript.jsp"></c:import>

	<table id="table" hidden="true">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>InitTime</th>
				<th>SortingTime</th>
				<th>FindItemTime</th>
				<th>DeleteItemsByRangeTime</th>
				<th>DuplicationClearTime</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

</body>
</html>