<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function login() {
		if($("#name").val() == "") {
			alert("아이디를 입력해라디오");
			return;
		} else {
			$("#loginform").submit();
		}
		
	}
</script>

</head>
<body>
	<form id="loginform" name="loginform" action="/magnetic/login" method="post">
		<input type="text"	id="name" name="name"/>
		<input type="button" value="login" onclick="login();"/>
	</form>
</body>
</html>