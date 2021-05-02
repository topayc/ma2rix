/**
 * Created by on 2014-09-03.
 */



String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/gi, "");
}

function addRowType1() {
    $(".arrList").append(
            "<li class='secType1 oh'>" +
            "<div class='coverArt'>" +
            "<a href='#none'><img src='../resources/images/arrage/holderType3.gif' alt='' style='width: 110px; height: 110px;'></a>" +
            "</div>" +
            "<div class='soundArea'>" +
            "<div class='soundHeader'>" +
            "<a class='bulPlay' href='#none' data-sound-url=''><i class='fa fa-play-circle fa-2x'></i></a> " +
            "<span class='songTitle'><a href='#none'>You raise up me</a></span> " +
            "<span class='songSinger'><a href='#none'>ma2rix</a></span>" +
            "<a class='btn small btnPoint ctgView' href='#none'><span>rock</span></a>" +
            "</div>" +
            "<div class='soundBody'>" +
            "<div class='pajaImg'><img src='../resources/images/arrage/holderType2.gif' class='mb20' alt='' style='width: 100%;'></div>" +
            "<div class='soundBar'></div>" +
            "</div>" +
            "<div class='soundFooter'>" +

            "<a class='btn large btnType1' href='#none'><span>Fan</span></a> " +
            "<a class='btn large btnType2' href='#none' data-showing='0'><span>Comment</span></a> " +
            "<a class='btn large btnType3' href='#none'><span>연주자 현황</span></a> " +
            "<a class='btn large btnPoint btnType4' href='#none'><span>참여하기</span></a> " +
            "<a class='btn large btnType5' href='#none'><span>Play list</span></a> " +
            "<a class='btn large btnType6' href='#none'><span>맵보기</span></a> " +
            "<a class='btn large btnPoint btnType7' href='#none'><span>구매</span></a> " +
            "<a class='btn large floatR btnType8' href='#none'><span>악보</span></a> " +

            "</div>" +
            "<div class='commentWrap' style='display: none;'>" +
            "<span class='commetText'>comment</span> " +
            "<input type='text' style='width: 700px;' placeholder='글을 입력 하세요'>" +
            "</div>" +
            "</div>" +
            "</li>"
    );

    if (buttonSetType === "01") {
        $(".btnType3, .btnType4, .btnType5").remove()
    } else if (buttonSetType === "02") {
        $(".btnType5, .btnType6, .btnType7").remove()
    } else if (buttonSetType === "03") {
        $(".btnType3, .btnType4").remove()
    }

}

$(function () {
    //dropType1
    $('.dropType1').dropit();
    //sound list append

//ajax list add test
    $(".testBtn").on("click", function () {
        addRowType1();
    });


    function addRowType2() {
        $(".arrList2").append(
                "<li>" +
                "<div class='soundSource'>" +
                "<p class='musician'>기타</p>" +
                "<div class='soundArea'>" +
                "<div class='soundHeader'>" +
                "<a href='#none' class='bulPlay' data-sound-url=''><i class='fa fa-play-circle fa-2x'></i></a> " +
                "<span class='songTitle'><input type='text' placeholder='선택한 연주자 이름'></span>" +
                "</div>" +
                "<div class='soundBody'>" +
                "<div class='soundBar'></div>" +
                "<div class='pajaImg'><img src='../../images/holderType2.gif' class='mb20' alt='' style='width: 100%;'></div>" +
                "</div>" +
                "</div>" +
                "<div class='soundState'>연주중</div>" +
                "</div>" +
                "</li>"
        );
    }

    addRowType2();

    //play button toggle type1
    //attr data-source-url 을 읽어와 알맞게 재생하도록 소스 변경( 안영철)
    //호출시 노래 제목도 인자로 호출
    var ma2 = new Ma2rixInit('#audioSet');
    $(document).on("click", ".bulPlay", function () {
        ma2.stopAudio();
        
        var source = $(this).attr('data-sound-url');
        var sourceTitle = $(this).attr('data-sound-title');
        if (source == null || source ==''){
    		alert('업로드된 음원 파일이 없습니다. 업로드를 한 후 플레이 해주세요');
    		return;
    	} 
        
        var currentPlay = $(document).find(".bulPlay").index(this);
        $(document).find(".bulPlay i").not(':eq(' + currentPlay + ')').removeClass("fa-stop").addClass("fa-play-circle");
//        $(this).find("i").toggleClass("fa-play-circle fa-stop");
        if ($(this).find("i").hasClass("fa-play-circle")) {
            $(this).find("i").removeClass("fa-play-circle").addClass("fa-stop");
            /*ma2.startAuidoSource(sourceTitle,source);*/
            ma2.startAuidoPlaySelector($(this));
        } else if ($(this).find("i").hasClass("fa-stop")) {
            $(this).find("i").removeClass("fa-stop").addClass("fa-play-circle");
            ma2.stopAudio();
        }
    });

    //commet show
    $(".commentWrap").hide();
    $(".arrList").on("click", ".btnType2", function () {
        if ($(this).attr('data-showing') == "0") {
            $(this).parents(".secType1").find(".commentWrap").css("opacity", 0.0).slideDown(300, function () {
                $(this).stop().animate({
                    "opacity": 1.0
                }, "slow");
            });
            $(this).attr('data-showing', '1');
        }
    });

    //tabType1
    $(".tabWrapType1").each(function () {
        $(this).find(".tabCont").hide().eq(0).show();
        $(this).find(".tabBtnSet1 a").eq(0).addClass("active");
    });
    $(".tabBtnSet1 a").click(function () {
        var getBtnIndex = $(this).parent().index();
        $(this).parents(".tabWrapType1").find(".tabCont").hide().eq(getBtnIndex).show();
        $(this).parents(".tabWrapType1").find(".tabBtnSet1 a").removeClass("active").eq(getBtnIndex).addClass("active");

    });

    //fileStyleType1
    /*$('.fileStyleType1').jfilestyle({'icon': false, 'buttonText': '가이드 음원 업로드', 'buttonBefore': true});
    $('.fileStyleType2').jfilestyle({'icon': false, 'buttonText': '악보 업로드', 'buttonBefore': true});
    $('.fileStyleType3').jfilestyle({'icon': false, 'buttonText': '추가파일 업로드', 'buttonBefore': true});
    $('.fileStyleType4').jfilestyle({'icon': false, 'buttonText': '업로드 image', 'buttonBefore': true});
    $('.fileStyleType5').jfilestyle({'icon': false, 'buttonText': '오디오 업로드', 'buttonBefore': true});
    $('.fileStyleType6').jfilestyle({'icon': false, 'buttonText': '파일 선택', 'buttonBefore': true});*/

    //checkType1
    //$(".hiddenBoxType1").hide();
    $("#openVocal, #closedVocal").click(function () {
        if($(this).parents(".arrInfoWrap").find("#closedVocal").is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
        	var addVocalCount = 0;
        	$(this).parents('.arrInfoWrap').find('tr').each(function(){
        		if ( $(this).find('.selectedMemberBox').val() != ''){
        			addVocalCount +=1;
        		}
        	});
        	
        	if (addVocalCount > 0 ){
        		if (confirm("공개로 전환하시면 추가된 " + addVocalCount + " 명의 보컬 리스트가 초기화 됩니다. \n진행하시겠습니까") == true){
        			$(this).parents('.arrInfoWrap').find('tr').remove();
        			$(".hiddenBoxType1").hide();
        		}else {
        			return;
        		}
        	}else {
        		$(this).parents('.arrInfoWrap').find('tr').remove();
        		$(".hiddenBoxType1").hide();
        	}
        }
    });
    
    //checkType1
    //$(".hiddenBoxType1").hide();
    $("#openArrange, #closedArrange").click(function () {
        if($(this).parents(".arrInfoWrap").find("#closedArrange").is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
        	var addVocalCount = 0;
        	$(this).parents('.arrInfoWrap').find('tr').each(function(){
        		if ( $(this).find('.selectedMemberBox').val() != ''){
        			addVocalCount +=1;
        		}
        	});
        	
        	if (addVocalCount > 0 ){
        		if (confirm("공개로 전환하시면 추가된 " + addVocalCount + " 명의 리스트가 초기화 됩니다. \n진행하시겠습니까") == true){
        			$(this).parents('.arrInfoWrap').find('tr').remove();
        			$(".hiddenBoxType1").hide();
        		}else {
        			return;
        		}
        	}else {
        		$(this).parents('.arrInfoWrap').find('tr').remove();
        		$(".hiddenBoxType1").hide();
        	}
        }
    }); 
/*
    $(".hiddenBoxType1").hide();
    $(".checkType1").click(function () {
        if ($(this).is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
            $(".hiddenBoxType1").hide();
        }
    });
*/

    //addLineType1
    //보컬 추가 버튼 이벤트 핸들러 
    //클래스 변경(안영철)
    $(".addLineType1").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            $(this).parents(".vocalAddContainer").find(".addTrType1").append(
                    "<tr>" +
                    "<td><a href='#none' class='layerPopType3'><i class='fa fa-user'></i></a></td>" +
                    "<td>" +
                    	"<input type = 'hidden' name = 'arrangeVocalCommands[" + vocalCount + "].updateType' class ='updateType' value ='4' >" +
                    	"<input type = 'hidden' name = 'arrangeVocalCommands[" + vocalCount + "].isMessageSend' value = 'n' class ='isMessageSend'/>" +
                    	"<input type = 'hidden' name = 'arrangeVocalCommands[" + vocalCount + "].messageContent' value = '' class ='message'/>" +
                    	"<input type = 'hidden' name = 'arrangeVocalCommands[" + vocalCount + "].messageType' value = '' class ='messageType'/>" +
                    	"<input type = 'hidden' name = 'arrangeVocalCommands[" + vocalCount + "].vocalMemberNo' class ='selectedMemberNo' />" +
                    	"<input type = 'text'   name = 'arrangeVocalCommands[" + vocalCount + "].vocalMemberName' class ='selectedMemberBox'  value =''></td>" +
                    "<td><a href='#none' class='layerPopType4'><i class='fa fa-envelope'></i></a></td>" +
                    "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>");
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("보걸추가는 8개항목만 추가 가능합니다")
        }
        vocalCount++;
    });
    
    
    //addLineType4
    //편곡자 추가 버튼 이벤트 핸들러 
    //클래스 변경(dsbae 2014.10.17)
    $(".addLineType4").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            $(this).parents(".arrangeAddContainer").find(".addTrType1").append(
                    "<tr>" +
                    "<td><a href='#none' class='layerPopType3'><i class='fa fa-user'></i></a></td>" +
                    "<td>" +
                    	"<input type = 'hidden' name = 'composeArrangeCommands[" + arrangeCount + "].updateType' class ='updateType' value ='4' >" +
                    	"<input type = 'hidden' name = 'composeArrangeCommands[" + arrangeCount + "].isMessageSend' value = 'n' class ='isMessageSend'/>" +
                    	"<input type = 'hidden' name = 'composeArrangeCommands[" + arrangeCount + "].messageContent' value = '' class ='message'/>" +
                    	"<input type = 'hidden' name = 'composeArrangeCommands[" + arrangeCount + "].messageType' value = '' class ='messageType'/>" +
                    	"<input type = 'hidden' name = 'composeArrangeCommands[" + arrangeCount + "].arrangeMemberNo' class ='selectedMemberNo' />" +
                    	"<input type = 'text'   name = 'composeArrangeCommands[" + arrangeCount + "].arrangeMemberName' class ='selectedMemberBox'  value =''></td>" +
                    "<td><a href='#none' class='layerPopType4'><i class='fa fa-envelope'></i></a></td>" +
                    "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>");
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("편곡자추가는 8개항목만 추가 가능합니다")
        }
        arrangeCount++;
    });
    
    //연주자 제거  버튼 이벤트 핸들러 
    $(".addTrType1").on("click", ".removeLineType1", function () {
    	var obj = $(this).parents('tr').find('.updateType');
    	var actionType = obj.val();
    	
    	if (actionType == '1'){
        	obj.val('3');
        	$(this).parents('tr').hide();
        } else if (actionType == '2'){
         	obj.val('3');
         	$(this).parents('tr').hide();
        }else if (actionType == '4'){
    		 $(this).parents("tr").remove();
    	} 
    });

    //addLineType2
    $(".addLineType2").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            var playFieldNo = $(this).parents(".arrInfoWrap").find("select").val();
            var playFieldName = $('#playFields option:selected').text();
            
            if (playFieldNo == -1){
            	alert('추가하실 연부 분야를 선택하거나 입력해주세요');
            	return;
            }
            
        	if (playFieldNo == 1){
        		var playFieldInput = $('#playFieldInput').val().trim(); 
        		if (playFieldInput == ""){
        			alert('연주파트 직접 입력을 선택하신 경우에는 모집할 연주파트를 입력하셔야합니다');
        			return;
        		} else {
        			playFieldName = playFieldInput;
        		}
        	}
            var musicianName = $(this).parents(".arrInfoWrap").find(".musicianName").val()
            
            //클래스 변경(안영철)
            $(this).parents(".tabCont").find(".addTrType2").append(
                    "<tr>" +
                    	"<td>" + playFieldName + 
                    	"</td>" +
                    	"<td>" +
                    		"<a href='#none' class='layerPopType1'><i class='fa fa-user'></i></a></td>" +
                    	"<td>" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].updateType' class ='updateType' value ='4' >" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].isMessageSend' value = 'n' class ='isMessageSend'/>" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].messageContent' value = '' class ='message'/>" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].messageType' value = '' class ='messageType'/>" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].playFiledNo' value ='" + playFieldNo +"' class ='playFieldNo'/>" +
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].playFieldName' value ='" +playFieldName + "' class ='playFieldName'/>"+
                    		"<input type = 'hidden' name = 'performanceCommands[" + performCount + "].performMemberNo' class ='selectedMemberNo' />" +
                    		"<input type = 'text'   name = 'performanceCommands[" + performCount + "].performMemberName' placeholder='선택한 연주자 이름' class = 'selectedMemberBox' value='' style='width: 200px;' readonly>" +
                    	"</td>" +
                    	"<td>" +
                    		"<input type='text' name = 'performanceCommands[" + performCount +"].performRate' value = '' style='width: 50px; text-align: right;' class ='performRate'> % 배분" +
                    	"</td>" +
                    	"<td><a href='#none' class='layerPopType2'><i class='fa fa-envelope'></i></a></td>" +
                    	"<td><a href='#none'><i class='fa fa-check-circle'></i></a></td>" +
                    	"<td><a href='#none'><i class='fa fa-external-link'></i></a></td>" +
                    	"<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>"
            );
            performCount++;
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("연주자는 8개항목만 추가 가능합니다")
        }
        $('#playFieldInput').val('');
    });
    
    //페이지 로딩이 연주자 수 설정(안영철)
    var performCount = Number($('#performCount').val());
    var vocalCount = Number($('#arrangeVocalCount').val());
    
    
    //보컬 제거 이벤트 핸들러 
    //각 연주자 상태를 처리할 수 있도록 추적함.(안영철)
    $(".addTrType2").on("click", ".removeLineType1", function () {
    	var obj = $(this).parents('tr').find('.updateType');
    	var actionType = obj.val();
    	
    	if (actionType == '1'){
        	obj.val('3');
        	$(this).parents('tr').hide();
        } else if (actionType == '2'){
         	obj.val('3');
         	$(this).parents('tr').hide();
        }else if (actionType == '4'){
    		 $(this).parents("tr").remove();
    	} 
    });
    
    //연주자 배분율이 변경되었을 때 관련 처리 (안영철)
    // init 값이 경우에만 updateType 을 변경해서 서버에서 업데이트 및 메시지 송신 처리를 할 수 있도록 함(안영철) 
    $(document).on('change', '.performRate',function(){
    	if (!checkRate(this)){
    		alert("수익 배분은 작곡자, 편곡자 , 작사가 배분율을 더해서 \n총 100 % 가되어야 합니다!!!");
    		$(this).val('');
    		$(this).focus();
    		return;
    	}
    	var obj = $(this).parents('tr').find('.updateType');
    	var actionType = obj.val();
    	if (actionType == '1'){
    		obj.val('2');
    	}
    } );
    
    function checkRate(target){
		var arrangeRate = Number($('#arrangeRate').val());
    	var lyricsRate = Number($('#lyricsRate').val());
    	var performRateSum = 0;
    	
    	$('.performRate').each(function(){
    		var performRate = $(this).val();
    		performRateSum  += (performRate == '') ? 0 :Number($(this).val()); 
    	});

    	var rateSum = arrangeRate + composeRate + performRateSum + lyricsRate;
    	if (rateSum > 100){
    		return false;
    	}else {
    		return true;
    	}
    	
	}
    
    // 팝업 생성시 타이틀및 제목을 추가할 수 있도록 함수 수정(안영철)
    function layer_open(el,title) {
        var temp = $('#' + el);
        if (title){
        	$('.title', temp).html(title);
        }
        
        $('#messageSend', temp).html(title);
        temp.parents('.layer').fadeIn();

        if (temp.outerHeight() < $(document).height()) {
            temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px')
        } else {
            temp.css('top', '0px');
        }
        
        if (temp.outerWidth() < $(document).width()) {
            temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px')
        } else {
            temp.css('left', '0px');
        }
        
        $('.layer .bg, .layer .btnClose').click(function (e) {
            $('.layer').fadeOut();
            e.preventDefault();
        });
        
        //편곡자 검색 및 보컬 검색 다이알로그에서 select 버튼 클릭시 처리 (안영철)
        $(".select-member").click(function(){
        	 var memberNo = $(this).attr('data-member-no');
        	 var memberName = $(this).attr('data-member-name');
        	 JcurSelectedObj.find('input.selectedMemberBox').val(memberName);
        	 JcurSelectedObj.find('input.selectedMemberNo').val(memberNo);
             $('.layer .bg, .layer .messageSendCancel').trigger('click');
        });
    }
    
    //이후의 소스 부분 추가 및 수정(안영철)
    var JcurSelectedObj;
    
    //메세지 대화창에서 확인 버튼을 눌렀을경우의 이벤트 핸들러 
    $(document).on("click", ".messageSendOk", function () {
    	if ( $(this).parents('.popCont').find('.messageTextArea').val().trim().length != 0){
	    	 JcurSelectedObj.find('input.message').val($(this).parents('.popCont').find('.messageTextArea').val());
	    	 $(this).parents('.popCont').find('.messageTextArea').val('');
	    	 var selectedMessageType = $(this).parents('.popCont').find('#messageTypeSelect option:selected').val();
	    	 JcurSelectedObj.find('input.messageType').val(selectedMessageType);
    	}else {
    		alert('메시지를 입력해주세요. \n입력하신 메시지는 폼에 제출될 때 전송됩니다.');
    	}
    });
    
    $(document).on("click", ".messageSendCancel", function () {
    	$(this).parents('.popCont').find('.messageTextArea').val('');
    });
    
    $(document).on("click", ".layerPopType1", function () {
    	JcurSelectedObj = $(this).parent().parent();;
        layer_open("playerAppoint");
    });
    $(document).on("click", ".layerPopType2", function () {
    	JcurSelectedObj = $(this).parent().parent();
    	var mailTargetPerformName  = $(this).parent().parent().find('input.selectedMemberBox').val();
    	if (mailTargetPerformName == ''){
    		alert("연주자를 선택하셔야만 메세지를 보내실 수 있습니다");
    		return;
    	}
        layer_open("msgSend", mailTargetPerformName);
    });
    
    $(document).on("click", ".layerPopType3", function () {
    	JcurSelectedObj = $(this).parent().parent();
        layer_open("vocalSearch")
    });
    
    $(document).on("click", ".layerPopType4", function () {
    	JcurSelectedObj = $(this).parent().parent();
    	var mailTargetVocalName  = $(this).parent().parent().find('input.selectedMemberBox').val();
    	if (mailTargetVocalName == ''){
    		alert("보컬을 선택하셔야만 메세지를 보내실 수 있습니다");
    		return;
    	}
    	layer_open("msgSend",mailTargetVocalName);
    });
    
    //연주 필드 선택 셀렉트 값의 변경시 처리 추가 (안영철)
    $(document).on("change", "#playFields", function () {
    	var value = $('#playFields option:selected').val();
    	var target = $('#playFieldInput').val('');
    	if (value == '1'){
    		target.removeAttr('disabled');
    	}else {
    		target.attr('disabled', true);
    	}
    });
    
    //플레이 필드 셀렉트 박스 초기화(안영
    if ($('#playFields option:selected').val() == 'a') {
    	$('#playFieldInput').val('');
    	$('#playFieldInput').attr('disabled', true);
    } 
});