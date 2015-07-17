<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ajaxadminheader.jsp"%>
<%@ include file="/public/menu.jsp"%>
<h2>Average Test Results</h2>
<c:if test="${show == null }">
	<c:set var="show" scope="session" value="yes"/>
</c:if>
<c:choose>
	<c:when test="${show == \"yes\"}">
			<form action="/online/SQLDataServlet" method="post">
				<input type="submit" name="load" value="Load results" id="load">
			</form>
			<c:set var="show" scope="session" value="no"/>
	</c:when>
	<c:otherwise>
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
		</table>
		<form action="/online/SQLDataServlet" method="post">
			<label for="run">Run a new test:</label>
			<input type="submit" name="test" value="Go" id="run">
		</form>
	</c:otherwise>
</c:choose>
<%@ include file="/footer.jsp"%>
