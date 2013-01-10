<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height" />
<title>Insert title here</title>

<script type="text/javascript">
	function insertScore() {
		$("#insertForm").submit();
	}
</script>
</head>
<body>
	<form action="/home/html5/insert" id="insertForm" method="post">
		<div class="insertDiv">
			<input type="radio" name="gubun" value="gubun1" checked> 
			<select name="paramName">
				<option>u1</option>
				<option>u2</option>
				<option>u3</option>
			</select>
			<input class="textScore" name="score" type="text" maxlength="2">
			vs
			<select name="paramName">
				<option>u1</option>
				<option>u2</option>
				<option>u3</option>
			</select>
			<input class="textScore" name="score" type="text" maxlength="2">
			<input type="radio" name="gubun" value="gubun2">
			<div class="btn1" onclick="insertScore()">send</div>
		</div>
	</form>
			
	<table cellspacing="0" border="1" class="tb_lstsrch">
	    <colgroup>
		    <col width="76">
		    <col width="153">
		    <col width="149">
		    <col width="126">
		    <col width="127">
		    <col width="89">
	    </colgroup>
	    <thead>
		    <tr>
		    <th scope="col" class="td_type">ra</th>
		    <th scope="col" class="td_type">w</th>
		    <th scope="col" class="td_type">d</th>
		    <th scope="col" class="td_type">te</th>
		    <th scope="col" class="td_type">te</th>
		    <th scope="col" class="td_type">te</th>
		    </tr>
	    </thead>
	 	<tbody>
			<tr class="frst">
		    	<td class="td_type">
			    	1
			    </td>
		    	<td class="td_type">
						
				</td>
				<td class="td_type">
						
				</td>
				<td class="td_type">
					<span>0</span>
				</td>
				<td class="td_type">
					<span>150</span>
				</td>
				<td class="td_type duedate">
					<span>2014.10.15</span>
				</td>
		    </tr>
	    </tbody>
    </table>
	
</body>
</html>