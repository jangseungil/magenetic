<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
	<title>Home</title>
<script type="text/javascript" src="<c:url value="/dwr/engine.js"/>"></script>
<script type="text/javascript" src="<c:url value="/dwr/util.js"/>"></script>
<script type="text/javascript" src="<c:url value="/dwr/interface/MainController.js"/>"></script>
<script type="text/javascript">
	/*
		function send() {
			  $.ajax({
		            url: "/magnetic/send",
		            data: ({sendMsg:$("#sendMsg").val()}),
		            success: function(data) {
		                $("#sendMsg").val("");
		                $("#viewMsg").append("님의 말 : ");
		                $("#viewMsg").append("<br>");
		                $("#viewMsg").append("·"+ data);
		                $("#viewMsg").append("<br>");
		                $("#viewMsg").scrollTop(parseInt(document.body.scrollHeight));
		            }
		        });
		}
	*/
	
	$(document).ready(function() {
		//DWR Reverse Ajax 활성화
	    dwr.engine.setActiveReverseAjax(true);
		$("#sendMsg").focus();
	});
	
	function receive(mainVo) {
          $("#sendMsg").val("");
          $("#viewMsg").append(mainVo.name + "님의 말 : ");
          $("#viewMsg").append("\r\n");
          $("#viewMsg").append("· "+ mainVo.content);
          $("#viewMsg").append("\r\n");
          $("#viewMsg").scrollTop(parseInt(document.body.scrollHeight));
	}
	
	function send() {
		var str = $("#sendMsg").val();
		str = str.replace(/[\r|\n]/g, '');
		if(str == "") {
			 $("#sendMsg").val("");
			return;
		}
		MainController.sendMessage({content:str},
			function(data) {

		});
	}
	
	function logOut() {
		   $("#logoutForm").submit();
	}


</script>



<style>
ul{
   list-style:none;
   }
</style>
</head>
<body>
	<form id="logoutForm" action="/magnetic/logout">
	</form>
	<ul>
		<li>
			<textarea rows="20" cols="50" id="viewMsg" readonly="readonly"></textarea>
		</li>
		<li>
		
		<textarea rows="2" cols="50" id="sendMsg"  onKeypress="if(event.keyCode==13){send();}"></textarea>
			<input type="button" value="logout" onclick="logOut();"/>
		</li>
		
	</ul>
</body>
</html>
