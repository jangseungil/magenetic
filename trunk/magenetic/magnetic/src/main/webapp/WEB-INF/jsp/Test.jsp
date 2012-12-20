<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
	<title>Home</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
	});
	
	
	
	function XMLCreate() {
	 var xmlDoc=new ActiveXObject("microsoft.XMLDOM");
	 
	 //1. 선언문 <?xml version='1.0' encoding='euc-kr'?>
	 var PInode=xmlDoc.createProcessingInstruction("xml", "version='1.0' encoding='euc-kr'");
	 
	 //2. 루트엘리먼트 <compactdiscs></compactdiscs>
	 var rootNode=xmlDoc.createElement("contents");

	 //4. 텍스트 노드
	 var titleTextNode=xmlDoc.createTextNode("연애시대OST");
	 
	 //5. 구조화(트리구조)
	 xmlDoc.appendChild(PInode);
	 xmlDoc.appendChild(rootNode);
	 
	 rootNode.appendChild(titleTextNode);
	 rootNode.appendChild(titleTextNode);
	 
	 //출력
	 document.all.txtResult.value=xmlDoc.xml;
	 
		
		var fso=new ActiveXObject("Scripting.FileSystemObject"); 
	    var filename="C:\\text.txt"; 
	    function savefile() { 
	        if (!fso.FileExists(filename)) { 
	            fso.CreateTextFile(filename,true); 
	        } 
	        var f=fso.OpenTextFile(filename,2,true); 
	        f.Write(myarea.innerHTML); 
	        f.Close(); 
	    } 
	    
	    function loadfile() { 
	        if (!fso.FileExists(filename)) { 
	            fso.CreateTextFile(filename,true); 
	        } 
	        var f=fso.OpenTextFile(filename,1); 
	        r=f.ReadAll(); 
	        f.Close(); 
	        myarea.innerHTML=r; 
	    } 
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
	
	
	  <h3>XML 만들기</h3>
	  <button onclick="XMLCreate()">만들기</button>
	  <br/>
	  <textarea cols="80" rows="20" name="txtResult"></textarea>
	  
	  
	  
</body>
</html>
