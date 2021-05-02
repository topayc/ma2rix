
jQuery(function(){

	var overlap_bool2 = 0;
	var len_bool1 = 0;
	var len_bool2 = 0;
	var len_bool3 = 0;
	var len_bool4 = 0;
	
	var memberPlayCount = $("#memberPlaysSize").val() -1;
	var initailmemberPlayCount  =$("#memberPlaysSize").val() -1;
	
	//멤버 링크 리스트의 갯수 세팅
	//리스트는 0 인덱스부터 시작히기 때문에, 실제 갯수보다 1 마이너스 해준다
	var initialMemberLinkCount = $('table.link tbody tr').length -1;
	var  memberLinkCount = $('table.link tbody tr').length -1 ;
	
	//파일업로드 변수들
	var bar = $('.bar');
	var percent = $('.percent');
	var status = $('#status');
	
	

	
	//취소 버튼 눌렀을때 프로필메인 페이지로 가는 함수
	$("#bt_cancel").click(function(){
		location.replace("profile_main.html");
	});
	
	//닉네임 중복체크버튼을 눌렸을 때 중복체크 및 경고창 표시
	$("#overlap_chk1").click(function(){
		
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
						overlap_bool2 = 0;
						can_use_bool2 = 0;
					}
					else if(duplRequest.duplicate == false){
						alert(duplRequest.value + "는 사용 가능합니다");
						$("#allow2").show();
						$("alert3").hide();
						$("alert12").hide();
						overlap_bool2 = 1;
						can_use_bool2 = 1;
						check_overlap();
					}
				},
				error : function(){
					alert("error");
				}
			});
		}
	});
	
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
	
	//인풋창이 비어 있는지 체크하는 함수
	var check_input_empty = function(str) {
		var chk_str = 1;
		if(str=='')
			chk_str = 0;
			
		return chk_str;
	};

	//이미지 파일 업로드를 ajax로 동작하게 하는 함수
	$('#profile_image_upload').ajaxForm({
		dataType :'json',
		type : 'POST',
		beforeSend: function() {
			status.empty();
			var percentVal = '0%';
			bar.width(percentVal);
			percent.html(percentVal);
			$(".progress").show();
			
		},
		
		uploadProgress: function(event, position, total, percentComplete) {
			var percentVal = percentComplete + '%';
			bar.width(percentVal);
			percent.html(percentVal);
		},
		
		complete: function(req) {
			status.empty();
			var percentVal = '0%';
			bar.width(percentVal);
			percent.html(percentVal);
			$(".progress").hide();
			var  obj = eval("("+req.responseText+")");
			$("#profile_image").hide();
			$('#profile_image').attr("src",obj.profileImageWebPath);	    //전송이 완료된 후 프로필 이미지가 저장된 url을 받아 프로필 이미지 교체
			$("#profile_image").fadeIn(1600);
			
		}
	});
	
	$('#file_upload').change(function() {
		var fileName = $('#file_upload').val().split('/').pop().split('\\').pop();
		var fileExtension = fileName.slice(fileName.lastIndexOf(".")+1).toLowerCase();
		var file_bool = 0;
		/*alert(fileExtension);*/
		if(fileExtension=="png")
			file_bool = 1;
		if(fileExtension=="bmp")
			file_bool = 1;
		if(fileExtension=="gif")
			file_bool = 1;
		if(fileExtension=="jpg")
			file_bool = 1;
		if(!file_bool)
			alert("이미지 파일만 첨부가 가능합니다.");
		else
			$('#profile_image_upload').submit();
	});
	
	$('#UploadButton').click(function() {
		$('#file_upload').trigger('click');
	});
	
	//이메일 중복체크가 되어있는지 확인하는 함수
	var check_overlap = function() {
		if(overlap_bool2==0){
			$("#alert2").hide();
			$("#alert4").hide();
			$("#allow2").hide();
			$("#alert3").show();
		}
		else
			$("#alert3").hide();
		return overlap_bool2;
	};
	
	
	//저장 버튼 눌렸을때
	$('#bt_confirm').click(function() {
		var total_bool = 1;
		
		if(!check_act_area())
			total_bool = 0;
		if(!check_play_area())
			total_bool = 0;
		if(!check_Nick())
			total_bool = 0;
		else if(!check_overlap())
			total_bool = 0;
		if(!check_Name())
			total_bool = 0;
		
		
		if(total_bool)
			$('#profile_ch').submit();
	});
	
	//취소 버튼 눌렷을때
	$('#bt_cancel').click(function() {
		
	});
	
	//구글맵 연동 함수
	$("#geocomplete").geocomplete({
		map: ".map_canvas",
		details: "form",
		/*detailsAttribute: "data-geo",*/
		markerOptions: {
			draggable: true,
			
		},
		 mapOptions: {
			    zoom: 10
		 },
	});
	
	//selectbox 값이 바뀔 때마다 구글맵에서 위치 변화
	$('#SelectNation').change(function() {
		$("#geocomplete").val($(this).val());
		$('#SelectCity').val('');
		$("#geocomplete").trigger("geocode");
	});
	//거주 도시 값이 바뀔 때마다 구글맵에서 위치 변화
	$('#SelectCity').on('keyup', function(){
		$("#geocomplete").val($('#SelectCity').val()+' '+$('#SelectNation').val());
		$("#geocomplete").trigger("geocode");
	});
	
	
	//마이너스 버튼을 눌렀을 경우 연주 영역이 삭제되는 함수
	$(".minus").each(function(){
		$(this).click(function(){
			memberPlayCount--;
			$(this).parent().next().remove();
			$(this).parent().remove();
			
			if (memberPlayCount < 2){
				$(".minus").hide();
			}
			
		});
	});


	//더하기 버튼을 눌렀을 때 연주분야 추가 해주는 함수
	$("#plus1").click(function(){
		memberLinkCount++;
		initialMemberLinkCount++;
		/*alert(memberLinkCount);*/
		if (memberLinkCount > 0) {
			$('.minus1').show();
		}
	
		var addMemberLink  = "<tr>";
		addMemberLink      += "  <th> Web Site </th>";
		addMemberLink      += "  <td> <input type='text' name='memberLinks[" + initialMemberLinkCount + "].memberLink' class='w_400 plr_10 memberLink' placeholder='http://'></td>";
		addMemberLink      += "  <td> <input type='text' name='memberLinks[" + initialMemberLinkCount + "].linkComment' class='w_250 plr_10' placeholder='간단한 설명'> </td>";
		addMemberLink      += "  <td> <img class='minus1' src='../resources/images/ico_minus.png'></td>";
		addMemberLink      += "</tr>";
		
	/*	alert(addMemberLink);*/
		$("table.link tbody").append(addMemberLink);
	});
		
	$("#plus2").click(function(){
		initailmemberPlayCount++;
		var addSelect ="<div class='box add'>\n"; 
		addSelect += "<select name='memberPlays["+ initailmemberPlayCount+"].playFieldNo' class='memberPlay1'>\n";
		addSelect += $(".memberPlay1").eq(0).html();
		addSelect += "</select>";
		addSelect += "<input type='text'style = 'display:none;' name='memberPlays["+ initailmemberPlayCount+"].playFieldName' class='direct_input plr_10 ml_10'>";
		addSelect += " <img src='../resources/images/join/ico_minus.png' class='minus2 vertMid'></div>";
		var addItem = $(addSelect);
		$("option:selected", addItem).removeAttr("selected");
		$(".hide1 .box_wrap").append(addItem);
		bind_direct_area();
		
		memberPlayCount++;
		if (memberPlayCount >0) {
			$(".minus2").show();
			/*alert(memberPlayCount);*/
		}
	});
	
	//마이너스1(멤버링크 추가) 버튼을 눌렀을 경우 멤버 링크가 삭제되는 이벤트 
	// on 함수를 이용하여 live 이벤트를 생성한다.
	
	$(document).on("click", ".minus1",function(e){
		$(this).parent().parent().remove();
		--memberLinkCount;
	});
	
	
	//마이너스1(멤버링크 추가) 버튼을 눌렀을 경우 연주 영역이 삭제되는 이벤트
	// on 함수를 이용하여 live 이벤트를 생성한다.
	
	$(document).on("click", ".minus2",function(e){
		memberPlayCount--;
		$(this).parent().next().remove();
		$(this).parent().remove();
		if (memberPlayCount < 1) {
			$('.minus2').hide();
		}
	});
	
	//연주자 선택시 연주분야 영역 표시해주는 함수
  	$("input#chk_bt").click(function(){
  		if ($(this).is(":checked")){
  			$(".hide1").show();
			$("#chk").val("1");
			$('.minus2').hide();
			memberPlayCount = 0;
			bind_direct_area();
  		}else {
  			if ($(".hide1 .box").length> 0){
  				$(".hide1 .box:gt(0)").remove();
  			}
  			
  			$(".hide1 select option").attr("selected",false);
			$(".hide1 input").val("");
			$(".hide1 input").hide();
  			$(".hide1").hide();
			$("#chk").val("0");
			$(".add").removeClass("add");
			memberPlayCount = -1;
  		}
  	/*	
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
		}*/
	});
	
	//직접입력 선택시 보여주는 함수
	var bind_direct_area=function(){
		$(".memberPlay1").each(function(){
			$(this).change(function(){
				if($(this).val()=="1") {
					$(this).siblings("input").show();
					$(this).siblings("input").val("");
				}
				else {
					$(this).siblings("input").hide();
					$(this).siblings("input").val($("option:selected", this).text());
					
				}
			});
		});
	};
	
	
	//글자수 체크하는 함수
	var checkByte = function(element, minlen,maxlen) { 
		var onechar; 
		var checkByte_bool = 1;
		var tcount = 0;
		for (var k=0;k<$(element).val().length;k++) {
			onechar = $(element).val().charAt(k);
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
	}; 
	
	// 중복확인 이후 닉네임에 변화가 있을 경우 중복확인을 다시 하게 체크
	 $("#nickName").on('keyup', function(){
		overlap_bool2 = 0;
		check_Nick();
	 });
	 
	 var check_Nick = function() {
		if(!checkByte($("#nickName"),1,50)) {
			$("#alert3").hide();
			$("#alert4").hide();
			$("#allow2").hide();
			$("#alert2").show();
			len_bool1 = 0;
		}
		else {
			$("#alert2").hide();
			len_bool1 = 1;
		}
		
		return len_bool1;
	 };
	 
	 //유저 이름이 50byte 넘어가면 경고창 표시
	 $("#name").on('keyup', function(){
		check_Name();
	 });
	 
	 var check_Name = function() {
		if(!checkByte($("#name"),1,50)) {
			$("#alert1").show();
			len_bool2 = 0;
		}
		else {
			$("#alert1").hide();
			len_bool2 = 1;
		}
		return len_bool2;
	 };
	 
	 //활동분야가 제대로 기입되어 있는지 확인하고 경고창 표시
	 var check_act_area = function() {
		var act_count = 0;
		$(".playFields").each(function(){
			if($(this).is(":checked"))
				act_count++;
		});
		if(act_count==0){
			$("#alert5").show();
		}
		else {
			$("#alert5").hide();
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
			$("#alert6").show();
		}
		else{
			$("#alert6").hide();
		}
		return chk_play;
	};
	
/*	
	//닉네임중복체크버튼을 눌렸을 때 중복체크 및 경고창 표시
	$("#overlap_chk1").click(function(){
		var elem = $("#nickName");
		var nick = $("#nickName").val();
		var params = "nickName="+ nick;
		var bool=1;
		//중복성 체크 기능 검사를 위해 임시로 설정해 놓은 테스트 닉네임
		
		overlap_bool2 = 0;
		if(checkByte(elem,1,50))
		{
			//ajax로 닉네임 중복여부 체크
			$.ajax({
				url : "nickDuplicate.php",
				data : params,
				datatype : "json",
				success : function(data) {
					var jsonArray = $.parseJSON(data);
					bool = jsonArray["duplicated"];
				},
				complete : function() {
					if(bool==0){
						$("#alert4").show();
						$("#allow2").hide();
						$("#alert2").hide();
						$("#alert3").hide();
						overlap_bool2 = 0;
						can_use_bool2 = 0;
					}
					else if(bool==1){
						$("#allow2").show();
						$("#alert2").hide();
						$("#alert3").hide();
						$("#alert4").hide();
						overlap_bool2 = 1;
						can_use_bool2 = 1;
					}
				},
				error : function(){
					alert("error");
				}
			});

		}
	});*/
	
	var selectedPlayFields = new Array();
	
	 bind_direct_area();
	 $(".progress").hide();
	 $("#profile_image").hide().fadeIn(1600);
	 $('#SelectCity').trigger("keyup");
	 
	 //활동분야 히든 필드의 값을 읽어 자바 배열에 저장 
	 $(".fieldCount").each(function(){
		 selectedPlayFields.push($(this).val());
	 });
	 
	 //활동분야에 따라 해당 체크박스를 체크한다.
	 $(".playFields").each(function(i){
		 for (var i = 0; i < selectedPlayFields.length ; i++){
			 if ($(this).val() == selectedPlayFields[i]){
				 $(this).attr("checked", true);
				 break;
			 }
		 }
	 });
	 
	 //활동분야 히든 필드 제거 
	 $(".fieldCount").remove();
	 
	 if (memberPlayCount > 0) {
		 $(".minus2").show();
	 }else {
		 $(".minus2").hide();
	 }
	 
	 if (memberLinkCount < 1){
		 $(".minus1").hide();
	 }
		
	if ($("input#chk_bt").is(":checked")){
		$(".hide1").show();
		$("#chk").val("1");
		/*$('.minus2').hide();*/
		bind_direct_area();
	}else{
		$(".hide1 .box:gt(0)").remove();
		$(".hide1 select option").attr("selected",false);
		$(".hide1 input").val("");
		$(".hide1 input").hide();
		$(".hide1").hide();
		$("#chk").val("0");
		$(".add").remove();
		memberPlayCount = -1;
	}
	 /*alert("member play count :" + memberPlayCount);*/
	
});

