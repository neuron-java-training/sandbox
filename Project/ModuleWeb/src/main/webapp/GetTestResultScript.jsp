<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<button type="button" onclick="getTestResult()">Tests Result</button>

<script>
	function getTestResult() {
		$.ajax({
			method : "POST",
			url : 'GetTestResultServlet',
			dataType : "json",
			success : function(data) {
				$("#table").show();
				$('#table').DataTable().clear();
				var id = 1;
				$.each(data, function(index) {
					$('#table').DataTable().row.add(
							[ id, data[index].name, data[index].initTime,
									data[index].sortingTime,
									data[index].findItemTime,
									data[index].deleteItemsByRangeTime,
									data[index].duplicationClearTime ]).draw();
					id++;
				});
			}
		});
	}
</script>