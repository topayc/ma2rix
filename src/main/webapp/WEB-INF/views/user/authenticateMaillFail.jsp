<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	<link href="../resources/_common/css/common.css" rel="stylesheet" type="text/css" />
	<link href="../resources/_common/css/login.css" rel="stylesheet" type="text/css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/js/header.js"></script>
	<script type="text/javascript" src="../resources/js/login.js"></script>
</head>
<body>
<div id="wrap">
    <!---------- header------------->
    <div id="header">
    	<div class="m_main">
	     	<div id="gnb">
	    		<h1 id="logo"><a href="#"><img src="../resources/_images/logo.png" /></a></h1>
	    		<form action="#"name="find_ma2rix" id="find_ma2rix" method="post" class="find">
	    			<input type="text" placeholder="온라인 음악제작사이트 Ma2rix" />
	    			<span class="tooltip"></span>
	    		</form>
	    		<ul id="nav">
	    			<li><a href="compose.html"><img src="../resources/_images/header/compose_off_.png" /><br /><span>작곡</span></a></li>
	    			<li><a href="arrange.html"><img src="../resources/_images/header/ing_arrange_off_.png" /><br /><span>진행중인 편곡</span></a></li>
	    			<li><a href="comp_arr.html"><img src="../resources/_images/header/complete_arrange_off_.png" /><br /><span>왼료된 편곡</span></a></li>
	    			<li><a href="songlist.html"><img src="../resources/_images/header/song_list_off_.png" /><br /><span>곡 리스트</span></a></li>
	    		</ul>
	    		<ul class="f_right">
	    			<li><a href="login.html">로그인</a></li>
	    			<li><a href="join_step1.html">회원가입</a></li>
	    		</ul>
	    		
	    		
	    	   <!--	 로그인 후  <ul class="f_right" 
	    			<li><a href="#"><img src="_images/top_ico1.png" /></a></li>
	    			<li><a href="#"><img src="_images/top_ico2.png" /></a></li>
	    			<li><a href="#"><img src="_images/top_ico3.png" /></a></li>
	    		 </ul> -->
	    		 
	    		 
	    	</div>
    	</div>
    </div><!-- header -->
    <!---------- container------------->
    <div id="container">
		<div id="content">
			<div class="m_com">
				<h3 class="tit wrap">${message.mainMessage}  </h3>
				<div class="pw">
					<div class="t_center">
						<h2 class="mt_20"> ${message.subMessage}   </h2>
					</div>
				 </div>
				<%@ include file="../shared/member_function.jsp" %>
			</div>
		</div><!--content-->
		<div id="footer">온라인 음원 제작 사이트 MA2RIX <br>Copyrightⓒ. 2014. MA2RIX. All Rights Reserved. </div>
	</div><!--container-->
</div>
</html>

