<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>
</head>
<body>
		<form action="/home/insert" method="post">
			<h1>방명록</h1>
			<table>
				<tr>
					<td>
						이름
					</td>
					<td>
						내용
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="name"/>
					</td>
					<td>
						<input type="text" name="content" size="40"/>
	
					</td>
					<td>
						<input class="btnR" type="submit" value="보내기"/>
					</td>
				</tr>
			</table>
		</form>


        
   	<table cellspacing="0" border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="10%">
		    <col width="70%">
		    <col width="20%">
	    </colgroup>
	    <thead>
		    <tr>
		    <th scope="col" class="td_type">이름</th>
		    <th scope="col" class="td_type">내용</th>
		    <th scope="col" class="td_type">날짜</th>
		    </tr>
	    </thead>
	 	<tbody>
	 		<c:set var="trClassNm" value=""/>
	 	    <c:forEach var="homeVo" items="${HomeVoList}" varStatus="status">
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
			    		<c:out value="${homeVo.name}"/>
				    </td>
			    	<td class="td_type">
							<c:out value="${homeVo.content}"/>
					</td>
					<td class="td_type">
						<fmt:formatDate value="${homeVo.date }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
			    </tr>
        	</c:forEach>
	    </tbody>
    </table>
</body>
</html>