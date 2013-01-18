<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang=ko>
<head>
<c:import url="/WEB-INF/jsp/common/common.jsp"/>
<meta charset=utf-8>
<title></title>
<script src=http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js></script>
<style>
*{margin:0; padding:0;}

/*wrapdiv*/
div#wrapdiv{ position: absolute; top: 50px; left: 50px; width: 320px; overflow: hidden; }

/*wrapdiv - headnav*/
div#wrapdiv ul#headnav{ height: 30px; background: #DBDBDB; text-align: right; padding-right: 5px; border-radius: 7px 7px 0 0; }
ul#headnav li{ position: relative; top: 5px; display: inline-block; }
ul#headnav li{ margin: 0 3px; width: 20px; height: 10px; background: gray; list-style: none; cursor: pointer; }

/*wrapdiv - imgs*/
div#wrapdiv ul#imgs{ width: 1280px; }
ul#imgs li{ width: 320px; height: 230px; list-style: none; float: left; border-radius: 0 0 7px 7px; }
ul#imgs li{ font-family: arial; font-size: 13em; text-align: center; }
ul#imgs li.red{ background: #ED8E93; } ul#imgs li.orange{ background: #EDB68E; } 
ul#imgs li.yellow{ background: #EDDC8E; } ul#imgs li.green{ background: #D3ED8E; }

</style>
</head>
<body>
	<div id=wrapdiv>
		<ul id=headnav>
			<li class=img1></li>
			<li class=img2></li>
			<li class=img3></li>
			<li class=img4></li>
		</ul>
		<ul id=imgs>
			<li class=red>A</li>
			<li class=orange>B</li>
			<li class=yellow>C</li>
			<li class=green>D</li>
		</ul>
	</div>

<script>
$(function(){

	var imgnum= 1; $('.img1').css({ background: "red" });
	
	$('.img1').click(function(){ imgnum=0; $('#headnav li').css({ background: "gray" }); $(this).css({ background: "red" }); $('#imgs').animate({ marginLeft: 0 },500);  });
	$('.img2').click(function(){ imgnum=1; $('#headnav li').css({ background: "gray" }); $(this).css({ background: "red" }); $('#imgs').animate({ marginLeft: -320 },500); });
	
	$('.img3').click(function(){ 
		imgnum=2; $('#headnav li').css({ background: "gray" });
		$(this).css({ background: "red" }); 
		$('#imgs').animate({ marginLeft: -640 },500);
	});
	
	$('.img4').click(function(){ 
		imgnum=3; $('#headnav li').css({ background: "gray" }); 
		$(this).css({ background: "red" }); 
		$('#imgs').animate({ marginLeft: -960 },500); 
	});
	
	/*
	var autoimg= function(){
		var leftnum= 320*imgnum;	
		var varnav= ".img"+String(imgnum+1);
		$('#imgs').animate({ marginLeft: '-'+leftnum },500);
		$('#headnav li').css({ background: "gray" }); $(varnav).css({ background: "red" });
		++imgnum; if(leftnum==960) imgnum=0;
	}
	setInterval(autoimg, 2500);
	*/
});
</script>
</body>
</html>


	