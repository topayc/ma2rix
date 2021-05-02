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
	<meta property="og:title" content="" />
	<meta property="og:description" content="" />
	<meta property="og:url" content="" />
	<meta property="og:type" content="article" />
	<meta property="og:site_name" content="" />
	
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>
<body>
	<h3> - Array Parameter Result - </h3>
	<div class = "container">
		<c:set var = "length" value = "${fn:length(testModel.firstNames)}" />
		<c:if test = "${length > 1}">
		
		<c:forEach begin = "0" end ="${length-1}" var ="i" step = "1">
				<div class = "item-container">
					${testModel.firstNames[i]} : ${testModel.lastNames[i]}
				</div>
		</c:forEach>
		</c:if>
		</div>
</body>
</html>