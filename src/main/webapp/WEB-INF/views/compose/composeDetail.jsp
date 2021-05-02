<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>

<% String listType = request.getParameter("listType");%>

<c:set var="listType" value="<%=listType%>"/>

            <div class="contents">
                <div class="titleWrap">
                    <h2>${listTypeString}</h2>
                </div>
                <div class="detailTop">
                	<div class="visual"><img src="xxxxx" alt="" style="width: 150px; height: 150px;"></div>
                	<div class="soundArea">
                		<div class="soundHeader">
							<a class="bulPlay" href="#none" data-sound-title="${composeDetail.composeTitle}" data-sound-url="http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"><i class="fa fa-play-circle fa-2x"></i></a>
							<span class="songTitle">${composeDetail.composeMemo}</span>
							<span class="songSinger"><a href="#none">${composeDetail.composeMemberName}</a></span>
							<span class="songTitle"><a class="btn small btnPoint2" href="#none"><span>Join</span></a></span>
<%-- 							<a class="btn small btnPoint ctgView" href="#none"><span>${composeDetail.genreName}</span></a> --%>
						</div>
                		<!-- 개발에서 확인요망 -->
						<div class="soundBody">
	                        <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div>
	                        <div class="soundBar"></div>
						</div>
						<!-- //개발에서 확인요망 -->
                		<div class="textR mt20">
		                    <a class="btn large" href="#none"><span>Fan</span></a>
		                    <a class="btn large" href="#none"><span>Map</span></a>
		                </div>
                	</div>
                </div>

<c:if test = "${ listType eq '1'}" >                                
<%@ include file="../include/tab_1.jsp" %>  <!--  작곡 상세  -->
</c:if>                

<c:if test = "${ listType eq '2'}" >                                
<%@ include file="../include/tab_2.jsp" %>  <!--  편곡 상세  -->
</c:if>                

<c:if test = "${ listType eq '3'}" >                                
<%@ include file="../include/tab_3.jsp" %>  <!--  완료 상세  -->
</c:if>                

            </div>
            <!-- //contents -->   
   

<%@ include file="../include/bottom.jsp" %>
