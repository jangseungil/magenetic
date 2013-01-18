<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">
	function goBookMark() {
		window.location.href = "/m/home/bookMark";
	}
	
	function goScoreDashBoard() {
		window.location.href = "/m/home/scoreDashBoard";
	}
</script>
</head>
<body id="homeBody" class="mainBody">
	<div class="headerBar">
	<div class="underBar"></div>
		<div class="mainDiv">
			<button type="button" class="css3button" onclick="goBookMark();">Book Mark</button>
			<button type="button" class="css3button" onclick="goScoreDashBoard();">Score History</button>
		</div>
	</div>	
</body>
</html>