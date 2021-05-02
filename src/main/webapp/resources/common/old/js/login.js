jQuery(function(){
	//로그인 버튼 눌렸을때
	$("#login_box").click(function(){
		if(check_info())
			$("#login").submit();
	});
	//패스워드 찾기 버튼 눌렸을때
  	$("#pw_box").click(function(){
		if(check_info())
			$("#pw").submit();
	});
	//아이디 찾기 버튼 룰렷을때
	$("#id_sh_box").click(function(){
		if(check_info())
			$("#id_sh").submit();
	});
	
	//email 입력창에서 엔터키 입력받았을때
	$("#email").keyup(function(e) {
		if (e.keyCode == 13) {
			if($("#login_box").length>0) //login_box돔 엘리먼트가 존재하면 login_box click
				$("#login_box").trigger('click');
			if($("#pw_box").length>0)	//pw_box돔 엘리먼트가 존재하면 login_box click
				$("#pw_box").trigger('click');
			if($("#id_sh_box").length>0)	//id_sh_box돔 엘리먼트가 존재하면 login_box click
				$("#id_sh_box").trigger('click');
		}   
	});
	//password 입력창에서 엔터키 입력받았을때
	$("#password").keyup(function(e) {
		if (e.keyCode == 13) {
			$("#login_box").trigger('click');
		}   
	});
   

	//입력된 정보들 확인 하는 함수
	var check_info = function() {
		var email = $("#email").val();
		var password = "";
		var login_bool=1;
		var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		if(email=='') {
			$("#alert1").css("visibility","visible");
			login_bool = 0;
		}
		else if(regex.test(email)==''){
			$("#alert1").css("visibility","visible");
			login_bool = 0;
		}
		else {
			$("#alert1").css("visibility","hidden");
		}
		//
		if($("#password").length>0){
			password = $("#password").val();
			if(password=='') {
				$("#alert2").css("visibility","visible");
				login_bool = 0;
			}
			else {
				$("#alert2").css("visibility","hidden");
			}
		}
		return login_bool;
	}
});