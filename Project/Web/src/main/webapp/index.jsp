<%@page import="hu.neuron.java.project.core.TestResult"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<TestResult> testRun= (ArrayList<TestResult>)request.getAttribute("testRun");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>WebModule</title>
</head>
<body>
	<form name="MainServletForm" id="MainServletForm" action="MainServlet">
		<button type="submit" name="submitButton" value="newTest">New
			Test</button>
		<button type="submit" name="submitButton" value="result">Result</button>
		<br> <br>
		<%
			if(testRun != null && !testRun.isEmpty()) {
		%>
		<table border="1">
			<tr>
				<td>Average test times</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>InitTime</td>
				<td>SortingTime</td>
				<td>GetItemTime</td>
				<td>DeleteItemsByRangeTime</td>
				<td>DuplicationClearTime</td>
			</tr>
			<%
				for(TestResult row : testRun) {
			%>
			<tr>
				<td> <%=row.getName()%> </td>
				<td> <%=(double)row.getInitTime()/1_000_000%> ms </td>
				<td> <%=(double)row.getSortingTime()/1_000_000%> ms </td>
				<td> <%=(double)row.getGetItemTime()/1_000_000%> ms </td>
				<td> <%=(double)row.getDeleteItemsByRangeTime()/1_000_000%> ms </td>
				<td> <%=(double)row.getDuplicationClearTime()/1_000_000%> ms </td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</form>
</body>
</html>