<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>
<script type="text/javascript" src="../resources/common/js/join_step2.js"></script>

<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">회원가입</h2>
		<ul class="wrap tab tab_bg1">
			<li class="step1 step "><span class="fc_white">약관동의</span></li>
			<li class="step2 step"><span>회원정보입력</span></li>
			<li class="step3 step"><span>가입완료</span></li>
		</ul>
		<div class="join">
			<div class="join_content">
				<form id="step2_form" name="step2_form"  method="post">
					<div class="clause_wrap">
						<p>이용약관</p>
						<div class="text_clause1" >내용입니다.</div>
						<input type="checkbox" name="agreePersonalProtect" id="agreePersonalProtect">
						<label for="agreePersonalProtect">위의 회원이용약관에 동의합니다.</label>
					</div>
					<div class="clause_wrap mt_50">
						<p>개인정보 수집 및 이용목적</p>
						<div class="text_clause1" readonly> 내용입니다.</div>
						<input type="checkbox" name="agreeUsePolicy" id="aggreeUsePolicy">
						<label for="aggreeUsePolicy">위의 개인정보 수집 및 이용목적에 동의합니다.</label>
					</div>
				</form>
			</div>
		 </div>
		 <div class="wrap mt_30">
			<input type="submit" id="submit" class="btn btn-red btn-ms f_right" value="다음">
		</div> 
	</div>
</div>

<%@ include file="../include/bottom.jsp" %>



