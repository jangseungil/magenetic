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
		  location.href = "/m/home";
		} else {
		}
		
		$('#pageFrameBookMark').load(function() {
			$('#pageFrameBookMark').contents().find("#bookMarkBack").bind('click', function(e) {
				$("#bookMarkBack").pageslide({ direction: "left", modal: true, speed:1000 });
				
			});
		});
		
		$('#pageFrameDashBoard').load(function() {
			$('#pageFrameDashBoard').contents().find("#dashBoardBack").bind('click', function(e) {
				$('#frames').animate({ marginTop:  0 }, 1500); 
				$('#pageFrameBookMark').hide(1300);
				$('#pageFrameDashBoard').hide(1000);
				//$('#pageFrameBookMark').animate({ opacity:'0' }, 800); 
				
			});
		});
	    $(".first").pageslide({ direction: "right", speed:500 });
	    $(".second").pageslide({ direction: "left", speed:500 });
		
	});
	
	function goBookMark() {
		window.location.href = "/home/bookMark";
	}
	
	function goScoreDashBoard() {
		window.location.href = "/home/scoreDashBoard";
	}
	
	function catchMeIfYouCan() {
		if($("#catchMe").attr("class") == 'subtitle3') {
			$("#catchMe").removeClass("subtitle3").addClass("whatthe");
		} else {
			$("#catchMe").removeClass("whatthe").addClass("subtitle3");
		}
		
		$("#homeBody").addClass("whatthe");
		$("#gongjun").removeClass("hide").addClass("unhide");
	}
	
	
	$(function(){
		$('#menu1').click(function(){ 
			$('#frames').animate({ marginTop: -1000 }, 500); 
			$('#pageFrameBookMark').show(500);
		});
		
		$('#menu2').click(function(){ 
			$('#frames').animate({ marginTop: -2605 },1000); 
			$('#pageFrameBookMark').show(1000);
			$('#pageFrameDashBoard').show(1000);
		});

	});
	
</script>
</head>
<body id="homeBody" class="mainBody">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pageslide.min.js"></script>
	<div class="headerBar">
	<div class="underBar"></div>
		<div class="mainDiv">
			<a href="javascript:$.pageslide.close()"><button type="button" class="css3button">Home</button></a>
			<button type="button" class="css3button" onclick="goScoreDashBoard();">Score History</button>
			<a href="/home/bookMark" class="first"><button type="button" class="css3button">(test)</button></a>
			<a href="/home/scoreDashBoard" class="second"><button type="button" class="css3button">(test)</button></a>
		</div>
	</div>	
	
	<div>
</body>
</html>