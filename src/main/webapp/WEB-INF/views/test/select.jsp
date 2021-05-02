<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script type="text/javascript">
	   $(function(){ 
		   var addElv = '<div class = "item-container">'+ 
		   					'<input type = "text" size = "4"  class ="item"  name ="firstNames" />&nbsp;'+
		   					'<input type = "text" size = "10" class ="item"  name  ="lastNames" />&nbsp;'+
		   					'<button class ="del" type ="button">del</button>'+
		   				'</div>';
	       $("#add").click(function(){
	    	   $(addElv).insertAfter($(".container").last());
	       });
	       $("#all-delete").click(function(){
	    	   $(".item-container").remove();
	       });
	       $(document).on("click", ".del",function(e){
	   	   	$(this).parent().remove();
	  	   });
	       
	       $("#file").change(function(){
	    		this.select();
	    	  alert( document.selection.createRangeCollection()[0].text.toString());
	       });
	       alert("element count is " + " ${fn:length(testModel.firstNames)}");
	   });
	</script>
</head>
<body>
	<button type = "button" id ="add"> add item </button>
	<button type = "button" id ="all-delete"> remove all </button>
	<form method ="post" enctype="multipart/form-data">
		<div class = "container">
			<c:set var = "length" value = "${fn:length(testModel.firstNames)}"/>
			<c:forEach begin = "0" end ="${length-1}" var ="i" step = "1">
					<div class = "item-container">
						<input class = "item" type = "text" name  ="firstNames" size = "4"  
							value = "${testModel.firstNames[i]}"/>
						<input class = "item" type = "text" name  = "lastNames" size = "10" 
							value = "${testModel.lastNames[i]}"/>
						<button class ="del" type ="button">del</button>
					</div>
			</c:forEach>
		</div>
		<input type ="submit" value ="send"/>
		<input type ="reset" value ="reset"/>
	</form>
</body>
</html>

