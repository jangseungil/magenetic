<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">

	 $(document).ready(function() {
		 if('${loginResult}' == "success") {
			 window.location.href = "${pageContext.request.contextPath}/m/home/scoreDashBoard";
		 }else  if('${loginResult}' == "id") {
			 alert("id가 틀렸으무니다");
		 }else  if('${loginResult}' == "pass") {
			 alert("암호가 틀렸으무니다");
		 }else  if('${loginResult}' == "idpass") {
			 alert("둘다 틀렸으무니다");
		 }
	 });
	
	 function goLogin() {
		 if($("#id").val() == "") {
			 alert("id");
			 return;
		 }
		 if($("#passWord").val() == "") {
			 alert("passWord");
			 return;
		 }
		 
		 $("#login").submit();
		 
	 }
	 
	 function back() {
		 window.location.href = "${pageContext.request.contextPath}/m/home/scoreDashBoard";
	 }
</script>
</head>
<body>
	<h3>Login</h3>
	<form action="/m/login/goLogin" id="login" name="login" method="post">
		<div class="insertDiv">
			ID<input type="text" name="id" id="id" value="동북"/>
			PASS<input type="password" name="passWord" id="passWord"/>
			<input class="btnR" type="button" value="back" onclick="back();"/>
			<input class="btnR" type="button" value="login" onclick="goLogin();"/>
		</div>
	</form>
	
</body>
</html>