<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">
	function back() {
		window.location.href ="/home/html5";
	}
</script>
</head>
<body>
	<form action="/home/user/insert" id="insertForm" method="post">
		<div class="insertDiv">
			<strong>name</strong>
			<input class="textUserName" name="name" type="text" maxlength="8">
			<input class="submitBtn" type="submit" value="add"/>
			<input class="btnR" type="button" value="back" onclick="back();"/>
		</div>
	</form>
	
	<h3>user</h3>

	<table cellspacing="0" border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="33">
		    <col width="33">
	    </colgroup>
	    <thead>
		    <tr>
		    <th scope="col" class="td_type">name</th>
		    <th scope="col" class="td_type">date</th>
		    </tr>
	    </thead>
	 	<tbody>
	 	<c:set var="trClassNm" value=""/>
	 	<c:forEach var="userVo" items="${userVoList}" varStatus="status">
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
		    		<a href="/home/user/delete/${userVo.name}">${userVo.name }</a>
			    </td>
		    	<td class="td_type">
					<fmt:formatDate value="${userVo.date }" pattern="yyyy-MM-dd hh:mm:ss"/>
				</td>
		    </tr>
	 	</c:forEach>
	    </tbody>
    </table>
    
    

</body>
</html>