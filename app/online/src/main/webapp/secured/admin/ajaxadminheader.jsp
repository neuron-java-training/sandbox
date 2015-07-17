<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Collection Tests</title>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css"
		type="text/css" media="screen" />
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/excite-bike/jquery-ui.css"
		type="text/css" media="screen" />
	<link rel="stylesheet" href="//cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css"
	type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" type="text/css" media="screen" />
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" 
	src="http://cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.js"></script>
	<script>
		$(document).ready(function() {
			$('#data').DataTable({
				"ajax": {
				    "url": "SQLDataServlet",
				    "type": "POST",
				    "dataType" : "json"
				  },
				"columns": [
				        { "data": "className" },
				        { "data": "n" },
				        { "data": "accessTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }},
				        { "data": "deletionTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }},
				        { "data": "duplicateTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }},
				        { "data": "fillTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }},
				        { "data": "initTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }},
				        { "data": "sortTime",
				        	"render": function ( data, type, full, meta ) {
				        	      return parseFloat(parseFloat(data).toFixed(4)).toString();
				        	    }}
				 ]
			});
		});
	</script>
</head>
<body>