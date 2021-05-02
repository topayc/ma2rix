<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>

<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">${message.mainMessage} </h2>
		<div class="pw">
			<div class="t_center">
				<h2 class="mt_20">${message.mainMessage}</h2>
				<h3 class="mt_20">${message.subMessage}</h3>	
			</div>
		 </div>
	<%@ include file="../shared/member_function.jsp" %>
	</div>
</div>
	
<%@ include file="../include/bottom.jsp" %>		

