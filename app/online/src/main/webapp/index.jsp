<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
	<h2>Average Test Results</h2>
	<table id="data">
		<thead>
			<tr>
				<td>Class name</td>
				<td>Runs</td>
				<td>Access Time</td>
				<td>Deletion Time</td>
				<td>Unduplicate</td>
				<td>Fill Time</td>
				<td>Init Time</td>
				<td>Sort Time</td>
			</tr>
		</thead>
		<tbody>
			<jsp:include page="/cache/cache.html"></jsp:include>
		</tbody>
	</table>
	<form action="TestData" method="post">
		<label for="run">Run a new test:</label>
		<input type="submit" name="test" value="Go" id="run">
	</form>

<%@ include file="footer.jsp"%>
