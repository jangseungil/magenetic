<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">
	$(document).ready(function() {
		var UserAgent = navigator.userAgent;
		if (UserAgent.match(/iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson/i) != null || UserAgent.match(/LG|SAMSUNG|Samsung/) != null) {
		  //location.href = "/m/home";
		} else {
		}
	});
	
	function goBookMark() {
		window.location.href = "/home/bookMark";
	}
	
	function goScoreDashBoard() {
		window.location.href = "/home/scoreDashBoard";
	}
	
	
</script>
</head>
<body>
	<!-- top -->
	<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
	<!-- //top -->	
	
	<!-- container -->
	<div class="container">
		<div class="blankContainer">
		
		</div>
	</div>
	<!-- //container -->	
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
	<!-- //footer -->	
</body>
</html>