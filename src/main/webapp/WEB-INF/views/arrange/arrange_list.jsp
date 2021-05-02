<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>	


			<div class="contents">
				<div class="titleWrap">
					<h2 class="testBtn">${listTypeString}</h2>
					<div class="arrayWrap">
						<div class="checkSelect">			
									
                            <select class="dropdown" id="genre_sel" name="genre_sel" onchange="javascript:genre_go()">                            
	                                <option value="0">--전체장르--</option>                            
								<c:forEach var="genre" items="${genreList}">
	                                <option value="${genre.genreNo}" <c:if test="${genre.genreNo == genreNo}">selected="selected"</c:if>>${genre.genreName}</option>
								</c:forEach>
                            </select>

						</div> 
						<dl class="arrayArea">
							<dt>[정렬]</dt>
							<dd><a href="javascript:genre_go(1)">팬 수</a><span class="bar"></span></dd>
							<dd><a href="javascript:genre_go(2)">최신순</a><span class="bar"></span></dd>
							<dd><a href="javascript:genre_go(3)">판매순</a></dd>
						</dl>
					</div>
				</div>
				<div class="listWrap">
					<ul class="arrList">
					

 					<c:forEach var="arrangeCommand" items="${resultList}"> 
 					<c:set var="pageon" value="1" scope="page"></c:set> 
<!-- 						<li class="secType1 oh"> -->
<!-- 							<div class="coverArt">							 -->
<%-- 								<a href="/music/arrange/arrangeDetail?arrangeNo=${arrangeCommand.arrangeNo}&listType=${listType}"><img src="${arrangeCommand.arrangeImageWeb}" alt="" style="width: 110px; height: 110px;"></a>	 --%>
<!-- 							</div> -->
<!-- 							<div class="soundArea"> -->
<!-- 								<div class="soundHeader"> -->
									
<%-- 									<a class="bulPlay" href="#none" data-sound-title="${arrangeCommand.arrangeTitle}" data-sound-url="http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"><i class="fa fa-play-circle fa-2x"></i></a>									 --%>
									
<%-- 									<span class="songTitle"><a href="#none">${arrangeCommand.arrangeMemo}</a></span> --%>
<%-- 									<span class="songSinger"><a href="#none">${arrangeCommand.arrangeMemberNickName}</a></span> --%>
<%-- 									<a class="btn small btnPoint ctgView" href="#none"><span>${arrangeCommand.genreName}</span></a> --%>
<!-- 								</div> -->
<!-- 								개발에서 확인요망 -->
<!-- 								<div class="soundBody"> -->
<!--                                     <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div> -->
<!--                                     <div class="soundBar"></div> -->
<!-- 								</div> -->
<!-- 								//개발에서 확인요망 -->
<!-- 								메뉴별 버튼 선택 -->
<!--                                 <div class="soundFooter"> -->
         
<!-- 						            <a class='btn large btnType1' href='#none'><span>Fan</span></a> -->
<!-- 						            <a class='btn large btnType2' href='#none' data-showing='0'><span>Comment</span></a> -->
<!-- 						            <a class='btn large btnType3' href='#none'><span>연주자 현황</span></a> -->
<!-- 						            <a class='btn large btnPoint btnType4' href='#none'><span>참여하기</span></a> -->
<!-- 						            <a class='btn large btnType5' href='#none'><span>Play list</span></a> -->
<!-- 						            <a class='btn large btnType6' href='#none'><span>맵보기</span></a> -->
<!-- 						            <a class='btn large btnPoint btnType7' href='#none'><span>구매</span></a> -->
<!-- 						            <a class='btn large btnType8' href='#none'><span>악보</span></a> -->
						
<!-- 						                <span class='floatR'> -->
<!-- 						                    <i class='fa fa-heart'></i> -->
<!-- 						                    <span><strong>15</strong></span> -->
<!-- 						                    <span class='bar'></span> -->
<!-- 						                    <i class='fa fa-download'></i> -->
<!-- 						                    <span><strong>100</strong></span> -->
<!-- 						                </span> -->
                                    
<!--                                 </div> -->
<!-- 								//메뉴별 버튼 선택 -->
<!-- 								<div class="commentWrap"> -->
<!-- 	                                <span class="commetText">comment</span> -->
<!-- 									<input type="text" style="width: 700px;" placeholder="글을 입력 하세요"> -->
<!-- 								</div> -->
<!-- 							<br />								 -->
<!-- 							</div> -->
<!-- 						</li> -->
 					</c:forEach> 
					

<%-- <c:if test="${pageon != 1}" > --%>
<!-- 						<li class="secType1 oh"> -->
<!-- 							<div class="coverArt">							 -->
<!-- 								등록된 음원이 없거나 해당 장르에 음원이 없습니다.								 -->
<!-- 							</div> -->
<!-- 						</li> -->
<%-- </c:if> --%>

					</ul>
				</div>
			</div>
			
	<form name="fom" action = "/music/arrange/arrangeList" method = "get">
		<input type = "hidden" name = "listType" id = "listType" value = "${listType}" />
		<input type = "hidden" name = "page" id = "page" value = "${page}" />
		<input type = "hidden" name = "orderBy" id = "orderBy" value = "${orderBy}" />
		<input type = "hidden" name = "genreNo" id = "genreNo" value = "${genreNo}" />
	</form>			
			
	<script type="text/javascript" src="../resources/common/js/scroll.js"></script>	
			
<%@ include file="../include/bottom.jsp" %>

<script type="text/javascript">

	var listType="${listType}";
	var page="${page}";
	var orderBy="${orderBy}";
	var genreNo="${genreNo}";
	var pageon="${pageon}";
	
    if (listType === "1") {
        $(".btnType3, .btnType4, .btnType5").remove();
    } else if (listType === "2") {
        $(".btnType5, .btnType6, .btnType7").remove();
    } else if (listType === "3") {
        $(".btnType3, .btnType4").remove();
    }

	function genre_go(orderBy){
		
		if(orderBy){
			document.fom.orderBy.value=orderBy;				
		}else{
			document.fom.orderBy.value=1;
		}
		
		var genre_val = document.getElementById("genre_sel").value;
		document.fom.listType.value=${listType};
		document.fom.genreNo.value=genre_val;
		document.fom.page.value=1;		
		fom.submit();		
	}    
    
	new $$loop_progress_init();
	new $$open_loop_progress();	
	e.beginScroll();
	page++;	
		
</script>


