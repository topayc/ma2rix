jQuery(function(){
  	$("#submit").click(function(){
		if(!$("#agreePersonalProtect").is(":checked"))
			alert("회원 이용약관에 동의해주세요!");
		else if(!$("#aggreeUsePolicy").is(":checked"))
			alert("개인정보 수집에 동의해주세요!");
		else
			$("#step2_form").submit();
	})
});