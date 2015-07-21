<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<button type="button" onclick="newTest()">New Test</button>

<script>
	function newTest() {
		$.ajax({
			method : "POST",
			url : 'NewTestServlet',
			dataType : "json",
			success : function(data) {
				if (data) {
					alert("New test success. Table will be reseted");
					$("#table").hide();
				} else {
					alert("Something wrong with the new test")
				}
			}
		});
	}
</script>
