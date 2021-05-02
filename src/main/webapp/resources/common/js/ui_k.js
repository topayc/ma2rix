
/**
 * Created by on 2014-09-03.
 */

//    layer popup
function layer_open(el) {
    var temp = $('#' + el);
    temp.parents('.layer').fadeIn();
    if (temp.outerHeight() < $(document).height()) {
        temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px')
    } else {
        temp.css('top', '0px')
    }
    if (temp.outerWidth() < $(document).width()) {
        temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px')
    } else {
        temp.css('left', '0px')
    }
    $('.layer .bg, .layer .btnClose').click(function (e) {
        $('.layer').fadeOut();
        e.preventDefault();
    });
}

$(function () {
    //dropType1
    $('.dropType1').dropit();
    //sound list append
    $(".testBtn").on("click", function (){
        addRowType1();
    });

    function addRowType1() {
        $(".arrList").append(
                "<li class='secType1 oh'>" +
                "<div class='coverArt'>" +
                "<a href='#none'><img src='../../images/holderType3.gif' alt='' style='width: 110px; height: 110px;'></a>" +
                "</div>" +
                "<div class='soundArea'>" +
                "<div class='soundHeader'>" +
                "<a class='bulPlay' href='#none' data-sound-url=''><i class='fa fa-play-circle fa-2x'></i></a> " +
                "<span class='songTitle'><a href='#none'>You raise up me</a></span> " +
                "<span class='songSinger'><a href='#none'>ma2rix</a></span>" +
                "<a class='btn small btnPoint ctgView' href='#none'><span>rock</span></a>" +
                "</div>" +
                "<div class='soundBody'>" +
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

    function addRowType2() {
        $(".arrList2").append(
                "<li>" +
                "<div class='soundSource'>" +
                "<p class='musician'>기타</p>" +
                "<div class='soundArea'>" +
                "<div class='soundHeader'>" +
                "<a href='#none' class='bulPlay' data-sound-url=''><i class='fa fa-play-circle fa-2x'></i></a>" +
                "<span class='songTitle'><input type='text' placeholder='선택한 연주자 이름'></span>" +
                "</div>" +
                "<div class='soundBody'>" +
                "<div class='soundBar'></div>" +
                "</div>" +
                "</div>" +
                "<div class='soundState'>연주중</div>" +
                "</div>" +
                "</li>"
        );
    }

    addRowType2();

    //play button toggle type1
    var ma2 = new Ma2rixInit('#audioSet');
    var sources = 'http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg';
    $(document).on("click", ".bulPlay", function () {
        ma2.stopAudio();
        var currentPlay = $(document).find(".bulPlay").index(this);
        $(document).find(".bulPlay i").not(':eq(' + currentPlay + ')').removeClass("fa-stop").addClass("fa-play-circle");
//        $(this).find("i").toggleClass("fa-play-circle fa-stop");
        if ($(this).find("i").hasClass("fa-play-circle")) {
            $(this).find("i").removeClass("fa-play-circle").addClass("fa-stop");
            ma2.startAuido(sources);
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
    $('.fileStyleType1').jfilestyle({'icon': false, 'buttonText': '가이드 음원 업로드', 'buttonBefore': true});
    $('.fileStyleType2').jfilestyle({'icon': false, 'buttonText': '악보 업로드', 'buttonBefore': true});
    $('.fileStyleType3').jfilestyle({'icon': false, 'buttonText': '추가파일 업로드', 'buttonBefore': true});
    $('.fileStyleType4').jfilestyle({'icon': false, 'buttonText': '업로드 image', 'buttonBefore': true});
    $('.fileStyleType5').jfilestyle({'icon': false, 'buttonText': '오디오 업로드', 'buttonBefore': true});
    $('.fileStyleType6').jfilestyle({'icon': false, 'buttonText': '파일 선택', 'buttonBefore': true});

    //checkType1
    $(".hiddenBoxType1").hide();
    $("#openVocal, #closedVocal").click(function () {
        if($(this).parents(".arrInfoWrap").find("#closedVocal").is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
            $(".hiddenBoxType1").hide();
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
    $(".addLineType1").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            $(this).parents(".hiddenBoxType1").find(".addTrType1").append(
                    "<tr>" +
                    "<td><a href='#none' onclick='layer_open(\"vocalSearch\")'><i class='fa fa-user'></i></a></td>" +
                    "<td><input type='text'></td>" +
                    "<td><a href='#none' onclick='layer_open(\"msgSend\")'><i class='fa fa-envelope'></i></a></td>" +
                    "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>");
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("보걸추가는 8개항목만 추가 가능합니다")
        }
    });
    $(".addTrType1").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });

    //addLineType2
    $(".addLineType2").on("click", function () {
        if ($(this).parents(".arrInfoWrap").find("tr").length < 8) {
            var musician = $(this).parents(".arrInfoWrap").find("select").val()
            var musicianName = $(this).parents(".arrInfoWrap").find(".musicianName").val()
            console.log(musicianName)
            $(this).parents(".tabCont").find(".addTrType2").append(
                    "<tr>" +
                    "<td>" + musician + "</td>" +
                    "<td><a href='#none' onclick='layer_open(\"playerAppoint\")'><i class='fa fa-user'></i></a></td>" +
                    "<td><input type='text' placeholder='선택한 연주자 이름' value='' style='width: 200px;'></td>" +
                    "<td><input type='text' style='width: 50px; text-align: right;'> % 배분</td>" +
                    "<td><a href='#none' onclick='layer_open(\"msgSend\")'><i class='fa fa-envelope'></i></a></td>" +
                    "<td><a href='#none'><i class='fa fa-check-circle'></i></a></td>" +
                    "<td><a href='#none'><i class='fa fa-external-link'></i></a></td>" +
                    "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                    "</tr>"
            );
        } else if ($(this).parents(".arrInfoWrap").find("tr").length > 7) {
            alert("연주자는 8개항목만 추가 가능합니다")
        }

    });
    $(".addTrType2").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });

});


/**
 * Created by on 2014-09-03.
 * 객체 AutoAddLine 스크롤 동작에 따라 스크롤이 최하단까지 스크롤되었을때 
 * 리스트를 받아온후 리스트 하단에 추가적으로 발생시킨다. 
 */

$(function () {

    function addRowType2() {
        $(".arrList2").append(
                "<li>" +
                "<div class='soundSource'>" +
                "<p class='musician'>기타</p>" +
                "<div class='soundArea'>" +
                "<div class='soundHeader'>" +
                "<a href='#none' class='bulPlay' data-get-sound=''><i class='fa fa-play-circle fa-2x'></i></a>" +
                "<span class='songTitle'><input type='text' placeholder='선택한 연주자 이름'></span>" +
                "</div>" +
                "<div class='soundBody'>" +
                "<img src='../common/images/arrage/holderType1.gif' alt='' style='width: 90%;'>" +
                "</div>" +
                "</div>" +
                "<div class='soundState'>연주중</div>" +
                "</div>" +
                "</li>"
        )
    }

    
    
    //play button toggle type1
    var ma2 = new Ma2rixInit('#audioSet');
    var sources = 'http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg'
    $(document).on("click", ".bulPlay", function () {;
        ma2.stopAudio();
        var currentPlay = $(document).find(".bulPlay").index(this);
        $(document).find(".bulPlay i").not(':eq(' + currentPlay + ')').removeClass("fa-stop").addClass("fa-play-circle");
//        $(this).find("i").toggleClass("fa-play-circle fa-stop");
        if($(this).find("i").hasClass("fa-play-circle")){
            $(this).find("i").removeClass("fa-play-circle").addClass("fa-stop");
            ma2.startAuido(sources);
        }else if($(this).find("i").hasClass("fa-stop")){
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
    $('.fileStyleType1').jfilestyle({'icon': false, 'buttonText': '가이드 음원 업로드', 'buttonBefore': true});
    $('.fileStyleType2').jfilestyle({'icon': false, 'buttonText': '악보 업로드', 'buttonBefore': true});
    $('.fileStyleType3').jfilestyle({'icon': false, 'buttonText': '추가파일 업로드', 'buttonBefore': true});
    $('.fileStyleType4').jfilestyle({'icon': false, 'buttonText': '업로드 image', 'buttonBefore': true});

    //checkType1
    $(".hiddenBoxType1").hide();
    $(".checkType1").click(function () {
        if ($(this).is(":checked") == true) {
            $(".hiddenBoxType1").show();
        } else {
            $(".hiddenBoxType1").hide();
        }
    });

    //addLineType1
    $(".addLineType1").on("click", function () {
        $(this).parents(".hiddenBoxType1").find(".addTrType1").append(
                "<tr>" +
                "<td><a href='#none'><i class='fa fa-user'></i></a></td>" +
                "<td><input type='text'></td>" +
                "<td><a href='#none'><i class='fa fa-envelope'></i></a></td>" +
                "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                "</tr>");
    });
    
    $(".addTrType1").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });

    //addLineType2
    $(".addLineType2").on("click", function () {
        $(this).parents(".tabCont").find(".addTrType2").append(
                "<tr>" +
                "<td>기타</td>" +
                "<td><a href='#none'><i class='fa fa-user'></i></a></td>" +
                "<td><input type='text' placeholder='선택한 연주자 이름' style='width: 200px;'></td>" +
                "<td><input type='text'></td>" +
                "<td>% 배분</td>" +
                "<td><a href='#none'><i class='fa fa-envelope'></i></a></td>" +
                "<td><a href='#none'><i class='fa fa-check-circle'></i></a></td>" +
                "<td><a href='#none'><i class='fa fa-external-link'></i></a></td>" +
                "<td><a href='#none' class='removeLineType1'><i class='fa fa-minus-circle'></i></a></td>" +
                "</tr>"
        );
    });
    $(".addTrType2").on("click", ".removeLineType1", function () {
        $(this).parents("tr").remove();
    });
    
    
    

    
    
    
    
    
    
    
    /*###################### 김기수 과장 작성 부분 시작######################## */
            
	//앨범라인 자동생성
	var AutoAddLine = function(){};
		        
    //편곡 라인 추가 함수
	AutoAddLine.addRowType1 = function(){};	
	AutoAddLine.prototype.addRowType1 = function(data){

		
             $(".arrList").append(
                     "<li class='secType1 oh'>" +
                     "<div class='coverArt'>" +
                     "<a href='/music/arrange/arrangeDetail?arrangeNo=" + data['arrangeNo'] + "&listType="+listType+"'><img src='../resources/images/arrage/holderType3.gif' alt='' style='width: 110px; height: 110px;'></a>" +
                     "</div>" +
                     "<div class='soundArea'>" +
                     "<div class='soundHeader'>" +
                     "<a class='bulPlay' href='#none' data-get-sound=''><i class='fa fa-play-circle fa-2x'></i></a> " +
                     "<span class='songTitle'><a href='#none'>" + data['arrangeMemo'] + "</a></span> " +
                     "<span class='songSinger'><a href='#none'>" + data['arrangeMemberNickName'] + "</a></span>" +
                     "<a class='btn small btnPoint ctgView' href='#none'><span>rock</span></a>" +
                     "</div>" +
                     "<div class='soundBody'>" +
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

        if (listType === "1") {
            $(".btnType3, .btnType4, .btnType5").remove();
        } else if (listType === "2") {
            $(".btnType5, .btnType6, .btnType7").remove();
        } else if (listType === "3") {
            $(".btnType3, .btnType4").remove();
        }
        
	};



	//JSON이용한 리스트 받아오기.
	AutoAddLine.arrangement_list = function(){};
	AutoAddLine.prototype.arrangement_list = function(data){

		   $.getJSON('/music/arrange/remoteList?page='+page+'&listType='+listType, function(data) {

	 		 total_cnt = Object.keys(data).length;

	              $.each(data, function(key, state){
	            	  
	            	  if(key=='objects'){  //objects만 추출
	            		  for(var i=0;i<total_cnt;i++){
	            			  
							var obj = state[i];
							AutoAddLine.addRowType1(obj);   //편곡리스트 데이터 가져오기
							
	            		  }
	            	  }
	              });	 		  	             
	          });

	         AutoAddLine.scroll_again();
	};
	
	// 스크롤 이벤트 중복발생 방지용 (릴레이).	
	AutoAddLine.scroll_again = function(){};	
	AutoAddLine.prototype.scroll_again = function(){
		var timer = setInterval(function(){
			AutoAddLine.scrollOK = true;
		}, 3600);
	};
	
	//더 이상 불러올 데이터 없음 표시
    AutoAddLine.addRow_End_Mark = function(){};
    AutoAddLine.prototype.addRow_End_Mark = function(){
        $(".arrList").append(
                "<div class='textC'>" +
                " 더 이상 데이터가 없습니다." + 
                "</div>"
        );
    };
      
    
	//더 이상 불러올 데이터 없음 표시 - 삭제
    AutoAddLine.lodingbars_end = function(cnt){};
    AutoAddLine.prototype.lodingbars_end = function(cnt){
  	  jQuery('#more'+cnt).fadeOut(2000).delay(5000);    	
    };
    
    
    //로딩중 이미지
    AutoAddLine.lodingbars = function(cnt){};
    AutoAddLine.prototype.lodingbars = function(cnt){
     	  var newDiv=document.createElement('div');
      	  newDiv.setAttribute('class','textC');
      	  newDiv.setAttribute('id','more'+cnt);
      	  
      	  newDiv.innerHTML="<img src='../resources/images/arrage/bul_h3.gif' alt=''> 데이터를 불러오는중입니다.";
      	  $(newDiv).insertAfter($(".arrList"));
    };    

    
	/*패키지 추자  및 클래스 정의*/ 
	var AutoAddLine_event = {};
	AutoAddLine_event.Event = {};
	AutoAddLine_event.Event.InfiniteScroll = function(scrollArrange, callback){
		this.scrollArrange = scrollArrange;
		this.callback = callback;
	};
	
	AutoAddLine_event.Event.InfiniteScroll.prototype =  {
		beginScroll: function() {
			AutoAddLine.scrollOK=false;												
			if(AutoAddLine.scroll_able==true){
				
				AutoAddLine.scroll_able=false;
				
				//ajax 통신				
				$.ajax({           
					type : "GET",
					url : "/music/arrange/remoteList?page="+page+"&listType="+listType,					
					dataType : "json",
					success : function(result){
						
						AutoAddLine.lodingbars(AutoAddLine.load_cnt);  //로딩중 표시
						AutoAddLine.arrangement_list(result); //리스트 받아오기
						AutoAddLine.lodingbars_end(AutoAddLine.load_cnt); //로딩중 표시 제거
						AutoAddLine.load_cnt++;

						AutoAddLine.scroll_able=true;
						
					},
					error : function(xhr, status, error){
		          		alert('더 이상 데이터가 없습니다.');
					}
				});										
			}			
		},
		stopScroll : function(){
			AutoAddLine.scroll_able=false;				
		}
	};
	
	/*이벤트 객체 생성*/
	var e = new AutoAddLine_event.Event.InfiniteScroll();
	/*이벤트 리스너 시작*/

	
	var AutoAddLine = new AutoAddLine();
	
    //변수초기화    
    AutoAddLine.load_cnt=1;
    AutoAddLine.scroll_able=true;
    AutoAddLine.scrollOK=true;

    //dropType1
    $('.dropType1').dropit();

    //sound list append	    
	$(window).scroll(function(){
		
		if(AutoAddLine.scrollOK==true){			
			if($(window).scrollTop()==($(document).height()-$(window).height())){
				
	  			e.beginScroll();	//스크롤이 하단끝에 닿았을때 데이터 로딩.												
				page++;
//				alert(page + "페이지");				
			}									
		}				
	});
        
});





