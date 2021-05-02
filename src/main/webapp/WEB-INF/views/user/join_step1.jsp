<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>

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
				<!-- <p class="textC">* 회원가입 방식을 선택해주세요. *</p> -->
				<div class="join_type_button_wrap">
					<div class="join_type_button">
						<div class="type_ma2rix">
							<h3>Ma2rix</h3>
							<div>
								<form method="get" name="GotoJoin_step21" class="GotoJoin_step2" action="join_step2">
								  <input type="submit" value="가입하기"/>
								</form>
							</div>
						</div>
					</div>
					<div class="join_type_button">
						<div class="facebookLogin">
							<h3>Facebook</h3>
							<div id="button">
							  <form method="get" name="GotoTeikrl" class="GotoTeikrl" action="join_step2">
								  <input type="submit" value="가입하기"/>
							  </form>
							</div>
						</div>
					</div>
					<div class="join_type_button">
						<div class="googleLogin">
							<h3>Goolgle<span class="pointColor">+</span></h3>
							<div id="button">
							  <form method="get" name="GotoTeikrl" class="GotoTeikrl" action="join_step2">
								  <input type="submit" value="가입하기"/>
							  </form>
							</div>
						</div>
					</div>
				 </div>
			 </div>
		 </div>
	</div>
</div>

<%@ include file="../include/bottom.jsp" %>	
