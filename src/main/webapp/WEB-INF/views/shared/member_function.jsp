<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   	 <div class="login_bottom wrap textC mt30">
		<div class="b_inline">
			<form method="get" name="find_id" id="find_id" action="searchPage">
				<!-- <img src="../resources/images/login/arrow.png">
				<span class="ml_5"> 아이디를 잊으셨나요? </span> -->
				<input type="hidden" name ="type" value="1">  
				<input type="submit" class="btn-ms2"  value="아이디 찾기">  
		    </form>
		</div>
		<div class="b_inline">
			<form method="get" name="find_pass" id="find_pass" action="searchPage">
				<!-- <img src="../resources/images/login/arrow.png">
				<span class="ml_5"> 비밀번호를 잊으셨나요?</span> -->
				<input type="hidden" name = "type" value="2">  
				<input type="submit" class="btn-ms2"  value="비밀번호 찾기">  
			</form>
		</div>
		<div class="b_inline">
			<form method="get" name="GotoJoin" id="GotoJoin" action="join_step1">
				<!-- <img src="../resources/images/login/arrow.png">
				<span class="ml_5"> ma2rix회원이 아니신가요? </span> -->
				<input type="submit" class="btn-ms2"  value="회원가입">  
			</form>
		</div>	
	</div>