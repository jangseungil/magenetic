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
	
	function goScoreDashBoard() {
		$('#frames').animate({ marginTop: -910 },500); 
		$('.pageFrame').css({ display: "inline" });
		//window.location.href = "/home/scoreDashBoard";
	}
	
	function catchMeIfYouCan() {
		if($("#catchMe").attr("class") == 'subtitle3') {
			$("#catchMe").removeClass("subtitle3").addClass("whatthe");
		} else {
			$("#catchMe").removeClass("whatthe").addClass("subtitle3");
		}
		
		$("#homeBody").addClass("whatthe");
		//$(".mainDiv").removeClass("mainDiv").addClass("hide");
		$("#gongjun").removeClass("hide").addClass("unhide");
	}
</script>
</head>
	<body id="homeBody" class="mainBody">
		<form action="/home/insert" method="post">
			<div class="mainDiv">
				<div class="maintitle"><div></div></div>
				<div class="subtitle2" onclick="goBookMark();"><div class="alignCenter">BookMark</div></div>
				<div class="subtitle2" onclick="goScoreDashBoard();"><div class="alignCenter">Score History</div></div>
				<div id="catchMe" class="subtitle3" onclick="catchMeIfYouCan();"><div class="alignCenter">클릭 금지</div></div>
			</div>
		</form>
	</body>
</html>