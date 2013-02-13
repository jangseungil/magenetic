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
		
		
		Morris.Bar({
			  element: 'winCntChartBar',
			  data: [
						{ y: '다승', 
							<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
									'${rankingInfo.name }': '${rankingInfo.winCnt}'	
									<c:if test="${status.index != fn:length(rankingInfoList)}">
									  ,
					        		</c:if>
							</c:forEach>
						}
			  ],
			  xkey: 'y',
			  ykeys: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
						
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			          ],
			  
			  labels: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
							
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			           ]
		});
		
		/*
		Morris.Area({
			  element: 'winCntChartArea',
			  data: [
			         
				<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
					{label: '${rankingInfo.name}', value: ${rankingInfo.totalGoalCnt}}
					
					<fmt:formatDate value="${scoreVo.date }" pattern="yyyy-MM-dd hh:mm:ss"/>
					
					
					{ y: '2006', a: 100, b: 90 }
					<c:if test="${status.index != fn:length(rankingInfoList)}">
					  ,
					</c:if>
				</c:forEach>

			    { y: '2006', a: 100, b: 90 },
			    { y: '2007', a: 75,  b: 65 },
			    { y: '2008', a: 50,  b: 40 },
			    { y: '2009', a: 75,  b: 65 },
			    { y: '2010', a: 50,  b: 40 },
			    { y: '2011', a: 75,  b: 65 },
			    { y: '2012', a: 100, b: 90 }
			  ],
			  xkey: 'y',
			  ykeys: ['a', 'b'],
			  labels: ['Series A', 'Series B']
		});
		*/
		
		
		Morris.Bar({
			  element: 'scoreChartBar',
			  data: [
						{ y: '다득점', 
							<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
									'${rankingInfo.name }': '${rankingInfo.totalGoalCnt }'	
									<c:if test="${status.index != fn:length(rankingInfoList)}">
									  ,
					        		</c:if>
							</c:forEach>
						}
			  ],
			  xkey: 'y',
			  ykeys: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
						
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			          ],
			  
			  labels: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
							
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			           ]
		});
		
		
		Morris.Donut({
			element: 'scoreChartDonut',
			data: [
				<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
						{label: '${rankingInfo.name}', value: ${rankingInfo.totalGoalCnt}}
						<c:if test="${status.index != fn:length(rankingInfoList)}">
						  ,
		        		</c:if>
				</c:forEach>
			]
		});

		
		Morris.Bar({
			  element: 'lostScoreChartBar',
			  data: [
						{ y: '다실점', 
							<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
									'${rankingInfo.name }': '${rankingInfo.lostGoalCnt }'	
									<c:if test="${status.index != fn:length(rankingInfoList)}">
									  ,
					        		</c:if>
							</c:forEach>
						}
			  ],
			  xkey: 'y',
			  ykeys: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
						
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			          ],
			  
			  labels: [
						<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
							'${rankingInfo.name }'
							
							<c:if test="${status.index != fn:length(rankingInfoList)}">
							  ,
							</c:if>
						</c:forEach>
			           ]
		});
		
		
		$("#scoreChartBar").hide();     
		$("#scoreChartDonut").hide();    
		$("#lostScoreChartBar").hide();    
		
		
	});
	
	function goBookMark() {
		window.location.href = "/home/bookMark";
	}
	
	function goManyVictory() {
		$("#scoreChartBar").hide();     
		$("#scoreChartDonut").hide();     
		$("#lostScoreChartBar").hide();   
		$("#winCntChartBar").show();     
	}
	
	function goManyGoal() {
		$("#winCntChartBar").hide();     
		$("#scoreChartBar").show();     
		$("#lostScoreChartBar").hide();   
		$("#scoreChartDonut").show();     
	}
	
	function goManyLostGoal() {
		$("#winCntChartBar").hide();     
		$("#scoreChartBar").hide();     
		$("#scoreChartDonut").hide();     
		$("#lostScoreChartBar").show();     
	}
	
</script>
</head>
<body>
	<!-- top -->
	<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
	<!-- //top -->	
	
	<!-- container -->
	<div class="container">
		<a href="#" class="second" onclick="goManyVictory();"><button type="button" class="css3button">다승</button></a>
		<a href="#" class="second" onclick="goManyGoal();"><button type="button" class="css3button">다득점</button></a>
		<a href="#" class="second" onclick="goManyLostGoal();"><button type="button" class="css3button">다실점</button></a>
		<div id="winCntChartBar" class="chart" style="color: white">
		</div>
		
		<div id="winCntChartArea" class="chart" style="color: white">
		</div>
		
		<div id="scoreChartBar" class="chart" style="color: white">
		</div>
		
		<div id="scoreChartDonut" class="chart" style="color: white">
		</div>
		
		<div id="lostScoreChartBar" class="chart" style="color: white">
		</div>
	</div>
	<!-- //container -->	
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
	<!-- //footer -->	
</body>
</html>