<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css">
<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.js"></script>

<script>
	$(document).ready(function() {
		// DataTable
		var table = $('#table').DataTable();
	});

	function setDisable(btn) {
		//$("#button").attr("disabled", true);
		btn.form.submit();
		btn.disabled = true;
	}
</script>

</head>
<body>
	<div style="width: 40%">
		<form action="CollectionTestServlet" method="post">

			<table>
				<tr>
					<td>Init size:</td>
					<td><input type="text" name="initSize"></td>
				</tr>
				<tr>
					<td>Test size:</td>
					<td><input type="text" name="testSize"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="button" value="run" type="submit" name="operator" onclick="setDisable(this);">Run test</button>
					</td>
				</tr>
			</table>
			
			<table id="table">
				<thead>
					<tr>
						<th>Test</th>
						<th>Init</th>
						<th>Access</th>
						<th>Delete</th>
						<th>Sort</th>
					</tr>
				</thead>
				<c:forEach items="${sessionScope.resultSession}" var="result">
					<tr>
						<td><c:out value="${result.testName}"></c:out></td>

						<td><c:out value="${result.initTime}"></c:out></td>

						<td><c:out value="${result.accessTime}"></c:out></td>

						<td><c:out value="${result.deleteTime}"></c:out></td>

						<td><c:out value="${result.sortTime}"></c:out></td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>

</body>
</html>