<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<script src="resources/datatable/js/jquery.dataTables.js"></script>
<link href="resources/datatable/css/jquery.dataTables_themeroller.css" rel="stylesheet">
</head>

<style>
.modal {
	display: none;
	position: fixed;
	z-index: 1000;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
	background: rgba(255, 255, 255, .8)
		url('resources/images/ajax-loader.gif') 50% 50% no-repeat;
}

body.loading {
	overflow: hidden;
}

body.loading .modal {
	display: block;
}

#tableContainer {
	position: absolute;
	width: 70%;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>

<script>
	function showLoading() {
		$("body").addClass("loading");
	}

	function hideLoading() {
		$("body").removeClass("loading");
	}

	function create() {
		console.log("Create");
		$('#table').dataTable({
			"bJQueryUI" : true,
			"ajax" : '<c:url value="/CollectionTestServlet?op=get" />',

			"aoColumns" : [ {
				"data" : "name"
			}, {
				"data" : "initTime"
			}, {
				"data" : "accessTime"
			}, {
				"data" : "deleteTime"
			}, {
				"data" : "sortTime"
			} ]
		});
	}

	$(document).ready(function() {
		console.log("ready");
		create();

		$("#button").click(function(event) {
			console.log("onclick");
			$("#button").attr("disabled", true);
			showLoading();

			$.ajax({
				url : '<c:url value="/CollectionTestServlet" />',
				data : {
					op : 'run',
					initSize : $('#initSize').val(),
					testSize : $('#testSize').val()
				},
				success : function(data) {
					console.log(data);
					$('#table').dataTable().fnDestroy();
					create();
					$("button").attr("disabled", false);
					hideLoading();
				},
				dataType : "html"
			});

		});

	});
</script>

</head>
<body>
	<div>
		<form name="inputForm" action='<c:url value="/CollectionTestServlet" />' method="post">
			<a href="<c:url value="/logout"/>">Logout</a>
			<sec:authorize access="hasRole('ADMIN')">
				<table>
					<tr>
						<td>Init size:</td>
						<td><input id="initSize" type="text" name="initSize"></td>
					</tr>
					<tr>
						<td>Test size:</td>
						<td><input id="testSize" type="text" name="testSize"></td>
					</tr>
					<tr>
						<td colspan="2">
							<button id="button" value="run" type="button" name="operator">Run test</button>
						</td>
					</tr>
				</table>
			</sec:authorize>

			<div id="tableContainer">
				<table id="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Init</th>
							<th>Access</th>
							<th>Delete</th>
							<th>Sort</th>
						</tr>
					</thead>

				</table>
			</div>

		</form>
	</div>
	<div class="modal"></div>
</body>

</html>