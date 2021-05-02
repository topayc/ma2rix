<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>		

<script type="text/javascript" src="../resources/common/js/login.js"></script>	

<div class="contents">
	<div class="m_com">	
		<div class="join">
			<div class="joinSuccess">
				<strong>${message.mainMessage}</strong>
				<p>${message.subMessage}</p>
			</div>
		 </div>
		 <div class="wrap mt_30 t_center mt_50">
			<a href="index" class="btn btn-red fc_white btn-ms ml_30">Ma2rix Home</a>
			<c:set var ="type" value = "${message.messageType}" />
			<c:choose>
				<c:when test = "${type == 1 || type == 5 || type == 7 || type == 12}">
					<a href="login" class="btn btn-red fc_white btn-ms ml_20" >로그인</a>
				</c:when>
				
				<c:when test = "${type == 8}">
					<a href="login" class="btn btn-red fc_white btn-ms ml_20" >인증메일 재 발송 요청</a>
				</c:when>
				
				<c:when test = "${type == 13}">
					<a href="login" class="btn btn-red fc_white btn-ms ml_20" >로그아웃 다시 시도하기</a>
				</c:when>
			
				<c:when test = "${type == 17 }">
					<a href= "${message.link}" class="btn btn-red fc_white btn-ms ml_20" >편곡 업데이트 정보 확인</a>
				</c:when>
				<c:otherwise>
					<a href="profile" class="btn btn-red fc_white btn-ms ml_20" > 프로필 정보 </a>
				</c:otherwise>
			</c:choose>
		</div> 
	</div>
</div>

<%@ include file="../include/bottom.jsp" %>