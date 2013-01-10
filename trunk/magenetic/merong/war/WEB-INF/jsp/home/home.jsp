<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>
<script type="text/javascript">
	function goBookMark() {
		window.location.href = "/home/bookMark";
	}
	
	function goHtml5() {
		window.location.href = "/home/html5";
	}
</script>
</head>
<body>
	<form action="/home/insert" method="post">
		<div class="maintitle"><h1 class="maintitle">whatthehellareudoing</h1></div>
		
		<div class="subtitle1" onclick="goBookMark();"><div class="alignCenter">BookMark</div></div>
	
		<div class="subtitle2" onclick="goHtml5();"><div class="alignCenter">html5</div></div>
		
	</form>
</body>
</html>