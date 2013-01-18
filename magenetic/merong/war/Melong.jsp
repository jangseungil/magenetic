<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="java.text.SimpleDateFormat" %>
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

<%
	String guestbookName = request.getParameter("guestbookName");
	if (guestbookName == null) {
	    guestbookName = "default";
	}
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
    Query query = new Query("TN_BOOKMARK").addSort("date", Query.SortDirection.DESCENDING);
    //
     List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(30));

%>
        
       		<table border="1" cellpadding="2" cellspacing="0">
       			<tr>
       				<td>이름</td>
       				<td>내용</td>
       				<td>날짜</td>
       			</tr>
       	<%
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Entity greeting : greetings) {
        	System.out.println(greeting.getProperty("name"));
       	%>	
    			<tr>
					<td width="10%">
						<%=greeting.getProperty("name")%>
					<td width="70%">
						<%=greeting.getProperty("content")%>
					</td>
					<td width="20%">
						<%=sdf1.format(greeting.getProperty("date"))%>
					</td>
				</tr>
				
        <%
        }
    	%>
       		</table>

		
</body>
</html>