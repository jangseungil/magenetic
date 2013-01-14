<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">
	function onlyNumberInput() { 
		var code = window.event.keyCode; 
		if ((code > 34 && code < 41) || (code > 47 && code < 58) || (code > 95 && code < 106) || code == 8 || code == 9 || code == 13 || code == 46) { 
			window.event.returnValue = true; 
			return; 
	    } 
		window.event.returnValue = false; 
	}
	
	function userAdd() {
		window.location.href = "/home/user";
	}
	
	function back() {
		window.location.href ="/home";
	}
	
	function send() {
		
		if($("#paramName1").val() == $("#paramName2").val()) {
			alert("사람이같스무니다");
			return;
		}
		
		if($("#score1").val() == "") {
			alert("점수써");
			return;
		}
		
		if($("#score2").val() == "") {
			alert("점수써");
			return;
		}
		
		if($("#score2").val() == $("#score1").val()) {
			alert("내 사전에 동점이란 없다.");
			return;
		}
		
		$("#insertForm").submit();
	}
	
	function addScore1() {
		var score1 = $("#score1").val();
		score1 *= 1;
		if(score1 >= 99) {
			return;
		}
		score1 += 1;
		$("#score1").val(score1);
	}
	
	function addScore2() {
		var score2 = $("#score2").val();
		score2 *= 1;
		if(score2 >= 99) {
			return;
		}
		score2 += 1;
		$("#score2").val(score2);
	}
</script>
</head>
<body>
	<form action="/home/scoreDashBoard/insert" id="insertForm" method="post">
		<div class="insertDiv">
			<select name="paramName" id="paramName1">
				<c:forEach var="userVo" items="${userVoList}" varStatus="status">
					<option>${userVo.name}</option>
				</c:forEach>
			</select>
			<input class="textScore" name="score1" id="score1" value="0" type="text" maxlength="2" style='IME-MODE: disabled' onKeyDown = "javascript:onlyNumberInput()">
			<input class="plusImg" type="image" src="${pageContext.request.contextPath}/images/plusbtn1.jpg" onclick="javascript:addScore1(); return false;"/>
			vs
			<select name="paramName" id="paramName2">
				<c:forEach var="userVo" items="${userVoList}" varStatus="status">
					<option>${userVo.name}</option>
				</c:forEach>
			</select>
			<input class="textScore" name="score2" id="score2" value="0" type="text" maxlength="2" style='IME-MODE: disabled' onKeyDown = "javascript:onlyNumberInput()">
			<input class="plusImg" type="image" src="${pageContext.request.contextPath}/images/plusbtn1.jpg" onclick="javascript:addScore2(); return false;"/>
		</div>
			<input class="submitBtn" type="button" value="send" onclick="send();"/>
			<input class="btnR" type="button" value="back" onclick="back();"/>
			<input class="btnR" type="button" value="userAdd" onclick="userAdd()"/>
	</form>
	
	<h3>ranking</h3>

	<table cellspacing="0" border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="33">
		    <col width="33">
		    <col width="35">
		    <col width="40">
	    </colgroup>
	    <thead>
		    <tr>
		    <th scope="col" class="td_type">rank</th>
		    <th scope="col" class="td_type">name</th>
		    <th scope="col" class="td_type">win</th>
		    <th scope="col" class="td_type">defeat</th>
		    </tr>
	    </thead>
	 	<tbody>
	 	<c:forEach var="rankingInfo" items="${rankingInfoList}" varStatus="status">
	 	
	 	
			<tr class="${trClassNm}">
		    	<td class="td_type">
		    		${rankingInfo.rank }
			    </td>
		    	<td class="td_type">
					${rankingInfo.name }
				</td>
				<td class="td_type">
					${rankingInfo.winCnt }
				</td>
				<td class="td_type">
					${rankingInfo.defeatCnt }
				</td>
		    </tr>
	 	</c:forEach>
	    </tbody>
    </table>
    
    
	<h3>history</h3>

	<table cellspacing="0" border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="33">
		    <col width="33">
		    <col width="35">
		    <col width="40">
	    </colgroup>
	    <thead>
		    <tr>
		    <th scope="col" class="td_type">winner</th>
		    <th scope="col" class="td_type">looser</th>
		    <th scope="col" class="td_type">score</th>
		    <th scope="col" class="td_type">date</th>
		    </tr>
	    </thead>
	 	<tbody>
	 		<c:set var="trClassNm" value=""/>
			<c:forEach var="scoreVo" items="${scoreVoList}" varStatus="status">
				<c:choose>
					<c:when test="${status.index == 0}">
						<c:set var="trClassNm" value="frst"/>
					</c:when>
					<c:otherwise>
						<c:set var="trClassNm" value=""/>
					</c:otherwise>
				</c:choose>

				<tr class="${trClassNm}">
				    	<td class="td_type">
				    		${scoreVo.winner }
					    </td>
				    	<td class="td_type">
							${scoreVo.looser }
						</td>
						<td class="td_type">
							${scoreVo.winnerScore } : ${scoreVo.looserScore }
						</td>
						<td class="td_type">
							<fmt:formatDate value="${scoreVo.date }" pattern="yyyy-MM-dd hh:mm:ss"/>
						</td>
			    </tr>
			</c:forEach>
	    </tbody>
    </table>
	
</body>
</html>