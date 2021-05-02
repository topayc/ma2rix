<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />

	<link href="../resources/common/css/default.css" rel="stylesheet" type="text/css" />		    	 
	<link  href="../resources/common/css/skin/pink.flag/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
	
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/common/js/jquery.i18n.properties.js"></script>	
	<!-- <script type="text/javascript" src="../resources/common/js/i18n.js"></script> -->
	<!-- <script type="text/javascript" src="../resources/common/js/jquery-1.11.1.min.js"></script> -->
	<script type="text/javascript" src="../resources/common/js/dropit.js"></script>
	<script type="text/javascript" src="../resources/common/js/jquery-filestyle.js"></script>
	<script type="text/javascript" src="../resources/common/js/jquery.easydropdown.js"></script>
	<script type="text/javascript" src="../resources/common/js/jquery.jplayer.min.js"></script>	
	<script type="text/javascript" src="../resources/common/js/ma2rixplayer.js"></script>
	<script type="text/javascript" src="../resources/common/js/j_progress.js"></script>		
	<script type="text/javascript" src="../resources/common/js/ui.js"></script>	
	
	<script type="text/javascript" >
		$(document).ready(function(){
			loadBundles("${locale}");
		});
		
		/**
		 * 인자로 전달된 로케일에 대항하는 메시지 파일을 읽어서  자바 스크립트 객체를 생성
		 * @param en, ko 등의 언어 문자열
		 */
		function loadBundles(lang) {
		        jQuery.i18n.properties({
		            name:'message', 
		            path:'/music/locale/properties/', 
		            mode:'both',
		            language:lang, 
		            callback: function() {}
		    });
		}	

		/**
		 * 메시지를 읽어온다. 프레임 중첩등의 경우도 발생할 수 있기 때문에 
		 * 자신이 부모 프레임이 아닐 경우 부모 프레임의 함수를 재 호출한다.
		 * @param msg
		 * @returns
		 */
		function i18n(msg) {
		    var args = "\""+ msg + "\"";
		    for (var i = 1; i < arguments.length; i++) {
		           args += ", \"" + arguments[i] + "\"";
		    }
		    if (parent != this) {
		           return eval("parent.i18n(" + args + ")");
		    }
		    return eval("jQuery.i18n.prop(" + args + ")");
		}
	</script>			
</head>
<body>
	<div class="mrWrap">
		<!-- header -->
		<div class="mrHeader">
			<div class="headerArea">`
	            <h1><a href="/music/arrange/arrangeList?listType=2"><img src="../resources/images/arrage/logo.gif" alt="ma2rix" /></a></h1>	            	            
	            <div class="gnbWrap">
		            <ul>
		            	<li><a href="#none"><spring:message code ="title.workspace"/></a></li>
		                <li><a href="/music/compose/composeList?listType=1"><spring:message code ="title.composition.list"/></a></li>
		                <li><a href="/music/arrange/arrangeList?listType=2"><spring:message code ="title.being.arrangement.list"/></a></li>
		                <li><a href="/music/arrange/arrangeList?listType=3"><spring:message code ="title.complete.arrangement.list"/></a></li>
		                <li><a href="#none"><spring:message code ="title.vocal.list"/></a></li>
		            </ul>
		        </div>
		        <div class="lnbWrap">
	                <span class="mChart"><a class="btn ylw" href="#none"><span>Ma2rix Chart</span></a></span>
	                <a class="bulInfo" title="알림" href="#none"><i class="fa fa-bell"></i></a>
	                <a class="bulMail" title="메시지" href="#none"><i class="fa fa-envelope"></i></a>
	                <a class="bulMail" title="다국어" href="#none"><i class="fa fa-globe"></i></a>
               		<ul class="dropType1 dropStyle1">
	                    <li>
	                        <c:choose> 
	                        	<c:when test ="${userSession == '1'}">
		                        <a class="btn tㄱopayc" href="#none">
			                        <span>${userName}</span>
			                        <img src="../resources/images/arrage/arrow01.png" alt="">
		                        </a>
		                        <ul>
		                            <li><a href="/music/user/profile">My Profile</a></li>
		                            <li><a href="#none">My Playlist</a></li>
		                            <li class="div"><a href="#none">My Fans</a></li>
		                            <li><a href="#none">Workspace</a></li>
		                            <li><a href="#none">My Message</a></li>
		                            <li class="div"><a href="#none">My Income</a></li>
		                            <li><a href="/music/user/logout">Logout</a></li>
		                        </ul>
		                        </c:when>
		                        <c:when test ="${userSession == '0'}">
		                          <a class="btn topayc" href="/music/user/login">
		                     	     <span>Login </span>
		                       		 <img src="../resources/images/arrage/arrow01.png" alt="">
		                         </a>
		                        </c:when>
	                        </c:choose>
	                    </li>
               		</ul>
		    	</div>
	    	</div>
		</div>
		<!-- //header -->
		<!-- contents -->
		<div class="mrContainer">
			<!-- 오디오 컨트롤러 셋 -->
			<div class="audioSetWrap">
				<div id="audioSet"></div>
				<div id="jp_container_1" class="jp-audio">
				   <div class="jp-type-single">
				     <div class="jp-gui jp-interface">
				       <ul class="jp-controls">
				         <li><a href="javascript:;" class="jp-before" tabindex="1">play</a></li>
				         <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
				         <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
				         <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
				         <li><a href="javascript:;" class="jp-next" tabindex="1">next</a></li>
				       </ul>
				     </div>
				     <div class="jp-details">
				       <ul>
				         <li><marquee scrolldelay="210" ><span class="jp-title"></span></marquee></li>
				       </ul>
				     </div>
				     <div class="jp-no-solution">
				       <span>Update Required</span>
				       To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
				     </div>
				   </div>
				</div>
			</div>
			<!-- //오디오 컨트롤러 셋 -->

