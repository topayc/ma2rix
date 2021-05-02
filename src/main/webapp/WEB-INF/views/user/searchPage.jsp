<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>

<script type="text/javascript" src="../resources/common/js/login.js"></script>	

<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">${message.mainMessage}</h2>
		<div class="id_sh">
			<div class="searchId">
				<!-- <p class="mt30 mb10">* ${message.subMessage} *</p> -->
			 	<form id="id_sh" name="searchPage"  method="post">
					<span class="tit bulList">E-mail</span>
					<input type="text" name="email" id="email" class="w_300 plr_10" value="${mailSendRequest.email}" placeholder="가입하신 E-mail을 입력해주세요.">
					<p id="alert1" class="vb_hid ml_30 fc_red">E-mail을 입력해주세요.</p>
					<input type="text" class="dp_none"/>
					<input type="button" id="id_sh_box" value="확인">
				</form> 
			</div>
		</div>
		<%@ include file="../shared/member_function.jsp" %>
	</div>
</div>
	
<%@ include file="../include/bottom.jsp" %>

