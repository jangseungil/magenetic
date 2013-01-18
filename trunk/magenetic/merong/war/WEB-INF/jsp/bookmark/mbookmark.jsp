<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<form action="/m/home/insert" method="post">
		<div class="insertDiv">
			name<input type="text" name="name"/>
			content<input type="text" name="content" size="25"/>
		</div>
		<input class="btnL" type="submit" value="보내기"/>
	</form>
        
   	<table border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="20%">
		    <col width="60%">
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
			    	<td class="mtd_type">
			    		<c:out value="${homeVo.name}"/>
				    </td>
			    	<td class="mtd_type">
							<c:out value="${homeVo.content}"/>
					</td>
					<td class="mtd_type">
						<fmt:formatDate value="${homeVo.date }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
			    </tr>
        	</c:forEach>
	    </tbody>
    </table>
</body>
</html>