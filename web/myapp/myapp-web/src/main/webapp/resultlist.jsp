<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="Date-Revision-yyyymmdd" content="20150702" />
<meta http-equiv="Content-Language" content="en" />

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.css" />

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/plug-ins/9dcbecd42ad/integration/jqueryui/dataTables.jqueryui.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#roli').DataTable({
			paging : true,
			scrollY : 400,
		});
	});
</script>
<body>

	<h1>Test results</h1>

	<table id="roli" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>initTime</th>
				<th>className</th>

			</tr>
		</thead>

		<tfoot>
			<tr>
				<th>initTime</th>
				<th>className</th>

			</tr>
		</tfoot>

		<tbody>
			<c:forEach var="result" items="${sessionScope.resultlist}">
			<tr>
				<td>${result.initTime}</td>
				<td>${result.clazzName}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>