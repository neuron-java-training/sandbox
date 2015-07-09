<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="table" class="hu.neuron.java.project.core.TableBean" scope="session">
</jsp:useBean>

<%@ include file="userheader.jsp"%>
<%@ include file="/public/menu.jsp"%>
<h2>Average Test Results</h2>
<c:choose>
	<c:when test="${table.tableData == null }">
			<form action="/online/TestData" method="post">
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
		<p>You must be logged in as admin to run new tests</p>
	</c:otherwise>
</c:choose>
<%@ include file="/footer.jsp"%>
