<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="table" class="hu.neuron.java.project.core.TableBean"
	scope="session">
</jsp:useBean>

<%@ include file="header.jsp"%>
<h2>Average Test Results</h2>
<c:choose>
	<c:when test="${table.tableData == null }">
		<form action="TestData" method="post">
			<input type="submit" name="load" value="Load results" id="load">
		</form>
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
			<tbody>
				${table.tableData}
			</tbody>
		</table>
		<form action="TestData" method="post">
			<label for="run">Run a new test:</label>
			<input type="submit" name="test" value="Go" id="run">
		</form>
	</c:otherwise>
</c:choose>
<%@ include file="footer.jsp"%>
