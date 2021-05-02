jQuery(function(){
	
	var overlap_bool = 0;
	var overlap_bool2 = 0;
	var len_bool1 = 0;
	var len_bool2 = 0;
	var len_bool3 = 0;
	var len_bool4 = 0;
	
	

	
	//글자수 체크하는 함수
	var checkByte = function(element, minlen,maxlen) { 
		var onechar; 
		var checkByte_bool = 1;
		var tcount = 0;
		for (k=0;k<element.value.length;k++) { 
			onechar = element.value.charAt(k);
			if (escape(onechar).length > 4) 
				tcount += 2; 
			else if (onechar!='\r') 
				tcount++; 
		}
		if(tcount<minlen) {
			checkByte_bool = 0;
		}
		if(tcount>maxlen) {
			checkByte_bool = 0;
		}
		
		return checkByte_bool;
	} 

	// 중복확인 이후 email에 변화가 있을 경우 중복확인을 다시 하게 체크
	$("#email").on('keyup', function(){
		overlap_bool = 0;
	 });
	 // 중복확인 이후 닉네임에 변화가 있을 경우 중복확인을 다시 하게 체크
	 $("#nickName").on('keyup', function(){
		overlap_bool2 = 0;
		
		if(!checkByte(this,0,50)) {
			$("#alert5").hide();
			$("#alert12").hide();
			$("#alert13").hide();
			$("#allow2").hide();
			$("#alert17").show();
			len_bool1 = 0;
		}
		else {
			$("#alert17").hide();
			len_bool1 = 1;
		}
	 });
	 //유저 이름이 50byte 넘어가면 경고창 표시
	 $("#name").on('keyup', function(){
		if(!checkByte(this,0,50)) {
			$("#alert4").hide();
			$("#alert18").show();
			len_bool2 = 0;
		}
		else {
			$("#alert18").hide();
			len_bool2 = 1;
		}
	 });
	 //비밀번호가 4~10 이내가 아닐 경우 경고창 표시
	 $("#password").on('keyup', function(){
		if(!checkByte(this,6,10)) {
			$("#alert2").hide();
			$("#alert8").hide();
			$("#alert15").show();
			len_bool3 = 0;
		}
		else {
			$("#alert15").hide();
			len_bool3 = 1;
		}
	 });
	 //비밀번호2가 4~10 이내가 아닐 경우 경고창 표시
	 $("#passwordconfirm").on('keyup', function(){
		if(!checkByte(this,6,10)) {
			$("#alert3").hide();
			$("#alert9").hide();
			$("#alert16").show();
			len_bool4 = 0;
		}
		else {
			$("#alert16").hide();
			len_bool4 = 1;
		}
	 });
	//email중복확인이 되어있는지 확인하는 함수
	var check_overlap1 = function() {
		if(overlap_bool==0)
			$("#alert11").show();
		else
			$("#alert11").hide();
		return overlap_bool;
	};
	//닉네임중복확인이 되어있는지 확인하는 함수
	var check_overlap2 = function() {
		if(overlap_bool2==0)
			$("#alert13").show();
		else
			$("#alert13").hide();
		return overlap_bool2;
	};
	//인풋창이 비어 있는지 체크하는 함수
	var check_input_empty = function(str) {
		var chk_str = 1;
		if(str=='')
			chk_str = 0;
			
		return chk_str;
	};
	//비밀번호가 일치하는지 체크, 비밀번호창이 비어있는지 체크하고 경고창 표시
	var check_equal_password = function() {
		var chk_pass = 1;
		var password = $("#password").val();
		var password2 = $("#passwordconfirm").val();
		if(!check_input_empty(password)) {
			$("#alert15").hide();
			$("#alert2").show();
			chk_pass = 0;
		}
		else {
			$("#alert2").hide();
		}
		if(!check_input_empty(password2)) {
			$("#alert16").hide();
			$("#alert3").show();
			chk_pass = 0;
		}
		else {
			$("#alert3").hide();
		}	
		if((password!=password2)&&chk_pass==1){
			$("#alert2").hide();
			$("#alert3").hide();
			$("#alert15").hide();
			$("#alert16").hide();
			$("#alert8").show();
			$("#alert9").show();
			chk_pass = 0;
		}
		else{
			if(len_bool3==1)
				$("#alert8").hide();
			if(len_bool4==1)
				$("#alert9").hide();
		}
		return chk_pass;
	};
	//이메일 유효성 검사, 이메일창이 비어있는지 확인하고 경고창 표시
	var check_email = function() {
		var chk_email = 1;
		var email = $("#email").val();
		var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		$("#alert1").hide();
		$("#alert10").hide();
		$("#alert11").hide();
		$("#alert14").hide();
		if(!overlap_bool)
			$("#allow1").hide();
			
		if(check_input_empty(email)==0) {
			$("#alert1").show();
			chk_email = 0;
		}
		else {
			$("#alert1").hide();
			if(regex.test(email)==''){
				$("#alert14").show();
				chk_email = 0;
			}
			else{
				$("#alert14").hide();
			}
		}
		
		return chk_email;
	};
	//닉네임칸이 비어 있는지 확인하고 경고창 표시
	var check_nick = function() {
		var chk_nick = 1;
		var nick = $("#nickName").val();
		chk_nick = check_input_empty(nick);
		$("#alert5").hide();
		$("#alert12").hide();
		$("#alert13").hide();
		$("#alert17").hide();
		if(!overlap_bool2)
			$("#allow2").hide();
		if(chk_nick==0){
			$("#alert5").show();
			$("#alert12").hide();
			$("#alert13").hide();
		}
		else{
			$("#alert5").hide();

		}
		return chk_nick;
	};
	// 이름칸이 비어있는지 확인하고 경고창 표시
	var check_name = function() {
		var chk_name = 1;
		var name = $("#name").val();
		
		chk_name = check_input_empty(name);
		if(chk_name==0){
			$("#alert4").show();
			chk_name=0;
		}
		else{
			$("#alert4").hide();
		}

		return chk_name;
	};
	//활동분야가 체크되어있는지 확인하고 경고창 표시
	var check_act_area = function() {
		var act_count = 0;
		$(".playFields").each(function(){
			if($(this).is(":checked"))
				act_count++;

		});
		if(act_count==0){
			$("#alert6").show();
		}
		else {
			$("#alert6").hide();
		}
		return act_count;
	};
	//연주분야가 제대로 기입되어 있는지 확인하고 경고창 표시
	var check_play_area = function() {
		var chk_play = 1;
		if($("#chk").val()=="1") {
			$(".memberPlay1").each(function(){
				if($(this).val()=="") {
					chk_play = 0;
				}
				else if($(this).val()=="direct"){
					if($(this).next().val()==""){
						chk_play = 0;
					}
				}
			});
		}
		if(chk_play==0){
			$("#alert7").show();
		}
		else{
			$("#alert7").hide();
		}
		return chk_play;
	};
	//연주자 선택시 연주분야 영역 표시해주는 함수
  	$("input#chk_bt").click(function(){
		var val = $("#chk").val();
		if (val == 0 ){
			$(".hide1").show();
			$("#chk").val("1");
			bind_direct_area();
		} else {
			$(".hide1").hide();
			$("#chk").val("0");
			$(".hide1 select option").attr("selected",false);
			$(".hide1 input").val("");
			$(".add").remove();
		}
	});
	//email중복체크버튼을 눌렸을 때 중복체크 및 경고창 표시
	$("#overlap_chk1").click(function(){
		var email = $("#email").val();
		var params = "email="+ email;
		var duplRequest ={};
		var bool=1;
		//중복성 체크 기능 검사를 위해 임시로 설정해 놓은 테스트 이메일
		overlap_bool = 0;
		
		if(check_email())
		{
			//ajax로 email 중복여부 체크
			$.ajax({
				url : "emailDuplicate",
				data : params,
				datatype : "json",
				success : function(data) {
					duplRequest = data;
				},
				complete : function() {
					if(duplRequest.duplicate == true){
						alert(duplRequest.value + "는 이미 등록된 이메일이 있습니다");
						$("#alert10").show();
						$("#allow1").hide();
						$("#alert1").hide();
						$("#alert11").hide();
						overlap_bool = 0;
					}
					else if(duplRequest.duplicate == false){
						alert(duplRequest.value + "는 사용 가능합니다.");
						$("#allow1").show();
						$("alert10").hide();
						overlap_bool = 1;
					}
				},
				error : function(){
					alert("error");
				}
			});
		}
	});
	//닉네임 중복체크버튼을 눌렸을 때 중복체크 및 경고창 표시
	$("#overlap_chk2").click(function(){
		var nick = $("#nickName").val();
		var duplRequest ={};
		//중복성 체크 기능 검사를 위해 임시로 설정해 놓은 테스트 닉네임
		var params = "nickName="+ nick;
		overlap_bool2 = 0;
		
		if(check_nick()) {
			//ajax로 닉네임 중복여부 체크
			$.ajax({
				url : "nickDuplicate",
				data : params,
				datatype : "json",
				success : function(data) {
					duplRequest = data;
				},
				complete : function() {
					if(duplRequest.duplicate == true){
						alert(duplRequest.value + "는 이미 등록된 닉네임이 있습니다");
						$("#alert12").show();
						$("#allow2").hide();
						$("#alert13").hide();
						$("#alert5").hide();
						overlap_bool2 = 0;
						can_use_bool2 = 0;
					}
					else if(duplRequest.duplicate == false){
						alert(duplRequest.value + "는 사용 가능합니다");
						$("#allow2").show();
						$("alert12").hide();
						overlap_bool2 = 1;
						can_use_bool2 = 1;
					}
				},
				error : function(){
					alert("error");
				}
			});
		}
	});
	//더하기 버튼을 눌렀을 때 연주분야 추가 해주는 함수
	$(".plus").click(function(){
		var addSelect ="<div class='box add'>\n"; 
		addSelect += "<select name='memberPlay1' class='memberPlay1'>\n";
		addSelect += $(".memberPlay1").eq(0).html();
		addSelect += "</select>";
		addSelect += "<input type='text' name='memberPlay2' class='direct_input plr_10'/>";
		addSelect += "<img src='../resources/_images/join/ico_minus.png' class='minus'/></div><div class='clear'></div>";
		$(".hide1 .box_wrap").append(addSelect);

		bind_direct_area();
		//마이너스 버튼을 눌렀을 경우 연주 영역이 삭제되는 함수
		$(".minus").each(function(){
			$(this).click(function(){
				$(this).parent().next().remove();
				$(this).parent().remove();
				
			});
		});
	});
	
/*	var bind_direct_area = function(){
		$(".memberPlay1").each(function(){
			$(this).live("change",function(){
				if($(this).val()=="1") {
					$(this).siblings("input").show();
				}
				else {
					$(this).siblings("input").hide();
				}
			});
		});
		
	};*/
	
	//연주분야선택에서 직접입력을 선택했을시 직접 입력창을 표시해주는 함수
	var bind_direct_area=function(){
		$(".memberPlay1").each(function(){
			$(this).change(function(){
				$(this).siblings("input").val("");
				if($(this).val()=="1") {
					$(this).siblings("input").show();
				}
				else {
					$(this).siblings("input").hide();
				}
			});
		});
	};
	
	//다음 버튼을 눌렀을때 최종적으로 기입폼을 체크 및 submit 하는 함수
	$("#submit").click(function(){
		var result_bool=1;
		/*
		$("#alert1").hide();
		$("#alert10").hide();
		$("#alert11").hide();
		$("#alert14").hide();
		if(!overlap_bool)
			$("#allow1").hide();
		if(!check_email())
			result_bool = 0;
		else if(!check_overlap1())
			result_bool = 0;
		if(!check_equal_password())
			result_bool = 0;
		$("#alert5").hide();
		$("#alert12").hide();
		$("#alert13").hide();
		$("#alert17").hide();
		if(!overlap_bool2)
			$("#allow2").hide();
		if(!check_nick())
			result_bool = 0;
		else if(!check_overlap2())
			result_bool = 0;
		if(!check_name())
			result_bool = 0;
		if(!check_act_area())
			result_bool = 0;
		if(!check_play_area())
			result_bool = 0;
		if(len_bool1==0)
			result_bool = 0;
		if(len_bool2==0)
			result_bool = 0;
		if(len_bool3==0)
			result_bool = 0;
		if(len_bool4==0)
			result_bool = 0;
		*/
		
			
		if(result_bool==1)
			$("#step3_form").submit();
	});
});