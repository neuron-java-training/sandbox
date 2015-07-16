<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
<script src="//code.jquery.com/jquery-1.10.2.js">
	
</script>
<script
	src="http://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js">
	
</script>

<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {

		var dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			buttons : {
				"Add data" : addData,
				Cancel : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				
			
			}
		});

		$('#addButton').click(function() {
			dialog.dialog("open");
		});
		function addData() {
			$.ajax({
				url : '<c:url value="/DataServlet"/>',
				data : {
					op : 'add',
					data1 : $('#data1').val(),
					data2 : $('#data2').val(),
					data3 : $('#data3').val(),
				},
				success : function(data) {
					$("#dialog-form").dialog("close");

				},
				dataType : "html"
			});
		}

		$('#example').dataTable({
			"ajax" : '<c:url value="/DataServlet?op=get"/>',
			"columns" : [ { 
				"data" : "data1"
			}, {
				"data" : "data2"
			}, {
				"data" : "data3"
			} ]
		});

	});
</script>
</head>

<body>

	<table>
		<tr>
			<td>
				<table id="example">
					<tr>
						<th>Data 1</th>
						<th>Data 2</th>
						<th>Data 3</th>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td><button id="addButton">Add</button></td>
			<td><c:if test="${pageContext.request.isUserInRole('admin')}">
					<button id="deleteButton">Delete</button>
			
				</c:if>
					</td>
		</tr>
	</table>

	<div id="dialog-form" title="Create new Data">
		<p class="validateTips">All form fields are required.</p>

		<form>
			<fieldset>
			<input type="hidden" name="id" id="id">
				<label for="data1">Data1</label> <input type="text" name="data1"
					id="data1" class="text ui-widget-content ui-corner-all"> <label
					for="data2">Data1</label> <input type="text" name="data2"
					id="data2" class="text ui-widget-content ui-corner-all"> <label
					for="data3">Data3</label> <input type="text" name="data3"
					id="data3" class="text ui-widget-content ui-corner-all"> <input
					type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
</body>
</html>