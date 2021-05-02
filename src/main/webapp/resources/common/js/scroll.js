	//앨범라인 자동생성
	var AutoAddLine = function(){};
	
    //작곡 라인 추가 함수
	AutoAddLine.addRowType1 = function(){};	
	AutoAddLine.prototype.addRowType1 = function(data){

             $(".arrList").append(
                     "<li class='secType1 oh'>" +
                     "<div class='coverArt'>" +
                     "<a href='/music/compose/composeDetail2?composeNo=" + data['composeNo'] + "&listType=" + listType + "'><img src='" + data['composeImageWeb'] + "' alt='' style='width: 110px; height: 110px;'></a>" +
                     "</div>" +
                     "<div class='soundArea'>" +
                     "<div class='soundHeader'>" +
                     "<a class='bulPlay' href='#none' data-sound-title='" + data['composeTitle'] + "' data-sound-url='"+"http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"+"'><i class='fa fa-play-circle fa-2x'></i></a> " +
                     "<span class='songTitle'><a href='#none'>" + data['composeMemo'] + "</a></span> " +
                     "<span class='songSinger'><a href='#none'>" + data['composeMemberNickName'] + "</a></span>" +
//                     "<a class='btn small btnPoint ctgView' href='#none'><span></span></a>" +
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
                     "<a class='btn large btnType8' href='#none'><span>악보</span></a> " +

                         "<span class='floatR'>" +
                             "<i class='fa fa-heart'></i> " +
                             "<span><strong>15</strong></span> " +
                             "<span class='bar'></span> " +
                             "<i class='fa fa-download'></i>" +
                             "<span><strong>100</strong></span>" +
                         "</span>" +

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

	

	
	
    //편곡 라인 추가 함수
	AutoAddLine.addRowType2 = function(){};	
	AutoAddLine.prototype.addRowType2 = function(data){

             $(".arrList").append(
                     "<li class='secType1 oh'>" +
                     "<div class='coverArt'>" +
                     "<a href='/music/arrange/arrangeDetail?arrangeNo=" + data['arrangeNo'] + "&listType="+listType+"'><img src='" + data['arrangeImageWeb'] + "' alt='' style='width: 110px; height: 110px;'></a>" +
                     "</div>" +
                     "<div class='soundArea'>" +
                     "<div class='soundHeader'>" +
                     "<a class='bulPlay' href='#none' data-sound-title='" + data['arrangeTitle'] + "' data-sound-url='"+"http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"+"'><i class='fa fa-play-circle fa-2x'></i></a> " +
                     "<span class='songTitle'><a href='#none'>" + data['arrangeMemo'] + "</a></span> " +
                     "<span class='songSinger'><a href='#none'>" + data['arrangeMemberNickName'] + "</a></span>" +
                     "<a class='btn small btnPoint ctgView' href='#none'><span>" + data['genreName'] + "</span></a>" +
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
                     "<a class='btn large btnType8' href='#none'><span>악보</span></a> " +

                         "<span class='floatR'>" +
                             "<i class='fa fa-heart'></i> " +
                             "<span><strong>15</strong></span> " +
                             "<span class='bar'></span> " +
                             "<i class='fa fa-download'></i>" +
                             "<span><strong>100</strong></span>" +
                         "</span>" +

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
	
	
	

	AutoAddLine.noData = function(){};		
	AutoAddLine.prototype.noData = function(){

        $(".arrList").append(
        		"<li class='secType1 oh'>" + 
        		"<div class='coverArt'>" +
        		"등록된 음원이 없거나 해당 장르에 음원이 없습니다." +	
        		"</div>" +
        		"</li>"      		        		
        );  		

	}	

	
	//JSON이용한 리스트 받아오기.
	AutoAddLine.arrangement_list = function(){};
	AutoAddLine.prototype.arrangement_list = function(data){
		
			var param = "?page=" + page + "&listType=" + listType + "&genreNo=" + genreNo + "&orderBy=" + orderBy;
			
			if(listType==1){
				var url="/music/compose/composeRemoteList" + param;  //작곡 리스트 통신
			}else if(listType==2 || listType==3){
				var url="/music/arrange/arrangeRemoteList" + param;  //편곡 리스트 통신			
			}

			
		   $.getJSON(url, function(data) {

	 		 total_cnt = Object.keys(data).length;

	              $.each(data, function(key, state){
	            	  
	            	  if(key=='objects'){  //objects만 추출
	            		  for(var i=0;i<total_cnt;i++){

							var obj = state[i];

							if(listType==1){
								AutoAddLine.addRowType1(obj);   //작곡리스트 데이터 가져오기
							}else if(listType==2 || listType==3){
								AutoAddLine.addRowType2(obj);   //편곡리스트 데이터 가져오기			
							}							

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
				
				
				var param = "?page=" + page + "&listType=" + listType + "&genreNo=" + genreNo + "&orderBy=" + orderBy;
				
				if(listType==1){
					var url="/music/compose/composeRemoteList" + param;
				}else if(listType==2 || listType==3){
					var url="/music/arrange/arrangeRemoteList" + param;			
				}

				
				//ajax 통신				
				$.ajax({           
					type : "GET",
					url : url,					
					dataType : "json",
					success : function(result){
						
						   setTimeout(function(){
							AutoAddLine.arrangement_list(result); //리스트 받아오기
	                        new $$close_loop_progress();							
						   }, 500);

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
	
	var AutoAddLine = new AutoAddLine();
	
    //변수초기화    
    AutoAddLine.load_cnt = 1;
    AutoAddLine.scroll_able = true;
    AutoAddLine.scrollOK = true;

    
    //sound list append	    
	$(window).scroll(function(){
		if(AutoAddLine.scrollOK==true){
	
			var pageBottom = ($(document).height() - $(window).height());
		
			if($(window).scrollTop() >= pageBottom - 150){
				if(pageon==1){					
					new $$loop_progress_init();
					new $$open_loop_progress();
		  			e.beginScroll();	//스크롤이 하단끝에 닿았을때 데이터 로딩.
					page++;
				}
			}
		}				
	});
	
	
	