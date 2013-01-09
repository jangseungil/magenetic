<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/bookMark" method="get">
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
				</tr>
			</table>
			<input type="submit" value="보내기"/>
		</form>


        
        
      	<table border="1" cellpadding="2" cellspacing="0">
      		<tr>
      			<td>이름</td>
      			<td>내용</td>
      			<td>날짜</td>
      		</tr>
			
        <c:forEach var="homeVo" items="${HomeVoList}">
   			<tr>
				<td width="10%">
					<c:out value="${homeVo.name}"/>
				</td>
				<td width="70%">
					<c:out value="${homeVo.content}"/>
				</td>
				<td width="20%">
					<c:out value="${homeVo.date}"/>
				</td>
			</tr>
		</c:forEach>
   		</table>
</body>
</html>