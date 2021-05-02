<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<%@ include file="../include/top.jsp"%>

<c:set var = "command" value = "${arrangeUpdateCommand}"/>
<fmt:parseNumber  var = "performanceCommandLength" value = "${fn:length(command.performanceCommands)}"/>
<fmt:parseNumber  var = "arrangeVocalsCommandLength" value = "${fn:length(command.arrangeVocalCommands)}"/>

<input type ="hidden" id = "performCount" name = "performCount" value = "${performanceCommandLength}"/>
<input type ="hidden" id = "arrangeVocalCount" name = "arrangeVocalCount" value = "${arrangeVocalsCommandLength}"/>

<form id = "arrange-update-form" name = "arrange-update-form" method ="post" >
<div class="contents">
	
	
	<div class="titleWrap">
		<h2>편곡 등록</h2>
		<a class="btn large btnPoint floatR" href="#none"><span>최종 편곡 업로드</span></a>
	</div>
	
	<div class="arrRegList">
		<div class="hType1">
			<h3>작곡기본 정보</h3> 
			<p>다음 내용은 작곡의 기본 정보입니다.</p>
		</div>
	
		<div class="oh">
			<div class="coverArt">
				<a href="#none"><img src="${command.compositionCommand.coverImageWebString}" alt="" style="width: 110px; height: 110px;"></a>
			</div>
			<div class="soundArea">
				<div class="soundHeader">
					<a href="#none" class="bulPlay" id = 'compose-play' data-sound-title ="what do you think about this?"  data-sound-url="http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg">
						<i class="fa fa-play-circle fa-2x"></i>
					</a> 
					<span class="songTitle"> <a href="#none">${command.compositionCommand.composeTitle}</a></span>
				</div>
				<!-- 개발에서 확인요망 -->
				<div class="soundBody">
					<div class="pajaImg">
						<img src="../resources/images/holderType2.gif" class="mb20" alt="" style="width: 100%;">
					</div>
					<div class="soundBar"></div>
				</div>
				<!-- //개발에서 확인요망 -->
			</div>
		</div>
		<table class="tblType01 mt20 mb20">
			<colgroup>
				<col style="width: 10%">
				<col style="width: auto">
			</colgroup>
			<caption></caption>
			<tr>
				<th>작곡자</th>
				<td>${command.compositionCommand.composeMemberName}</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<a href="#none" data-score-url = "${command.compositionCommand.composeScoreWeb}" class="showScore" data-score-url=""> 
						<span class="label label-score">작곡 악보</span>
					</a>
					<a href="#none" data-sound-url = "${command.compositionCommand.composeSoundMp3};${command.compositionCommand.composeSoundOgg}">
					   <span class="label label-source">작곡 음원</span>
				   </a>
				</td>
			</tr>
			<tr>
				<th>공개</th>
				<td>${command.compositionCommand.openStatusString}</td>
			</tr>
			<tr>
				<th>수익률</th>
				<td>${command.compositionCommand.composeRate}&nbsp;%</td>
			</tr>
		</table>
		<div class="arrInfoWrap">
			<h4>작곡자 메모</h4>
			<textarea cols="50" readonly rows="5" placeholder="작곡자 메모 내용 삽입"style="width: 908px">
				${command.compositionCommand.composeMemo}
			</textarea>
		</div>
	</div>

	<div class="hType1">
		<h3>편곡 기본 정보 입력</h3>
	</div>
	<div class="arrInfoWrap">
		<h4>편곡 제목</h4>
		<div class="mb20">
			<input type="text" value="${command.arrangeCommand.arrangeTitle}" readonly style="width: 914px">
		</div>
		<h4>
			장르<strong class="pointColor">(필수)</strong>
		</h4>
		<div class="mb20">
			<select class="dropdown" class="dropdown" name="arrangeCommand.genreNo">
				<!-- <option value = "0">장르선택</option> -->
				<c:forEach items = "${genres}" var = "genre">
					<option value ="${genre.genreNo}" <c:if test="${genre.genreNo == command.arrangement.genreNo}">selected="selected"</c:if> >
						${genre.genreName}
					</option>
				</c:forEach>
			</select>
		</div>
		<h4>
			편곡 업로드<strong class="pointColor">(필수 1개 이상)</strong>
		</h4>
		<div class="mb20">
			<div class="floatL">
				<a class="uploadBtn" data-upload-type = "1" href="#none"><span>가이드 음원 업로드</span></a>
			</div>
			<p class="uploadPut">
				<img id ='arrange-sound-progress-img' src = ''>
				<span style ="padding-left: 10px" id ='arrange-sound-progress-string'></span>
			</p> 
			<p class="ml130">* WAV, MP3 포맷의 편곡 음원을 업로드 할 수 있습니다.</p>
		</div>
		<div class="soundHeader">
			<a href="#none" class="bulPlay" id = 'arrange-play' data-sound-url='${command.arrangeCommand.playSource}'>
				<i class="fa fa-play-circle fa-2x"></i>
			</a> 
		</div>
		<img id = "arrange-frequency-holder" height = "70px" src="${command.arrangeCommand.arrangeSoundPng}" class="mb20" alt="" style="width: 95%;">
		
		<div class="mb10">
			<div class="floatL">
				<a class="uploadBtn" data-upload-type = "2"  href="#none"><span>악보 업로드</span></a>
			</div>
			<p class="uploadPut">
				<img id ='arrange-score-progress-img' src = ''>
				<span style ="padding-left: 10px" id ='arrange-score-progress-string'></span>
			</p> 
			<p class="ml130">* PNG, BMP, JPG, GIF 포맷의 파일을 업로드 할 수 있습니다.</p>
		</div>
		
		<div class="mb20">
			<div class="floatL">
				<a class="uploadBtn" data-upload-type = "3" href="#none"><span>추가파일 업로드</span></a>
			</div>
				<p class="uploadPut">
					<img id ='arrange-zip-progress-img' src = ''>
					<span style ="padding-left: 10px" id ='arrange-zip-progress-string'></span>
				</p> 
			<p class="ml130">* 연주에 도움이 될 수 있는 파일을 올릴 수 있으며. ZIP (압축) 포맷 파일을 업로드 할 수 있습니다..</p>
		</div>
		<h4>편곡자 메모</h4>
		
		<div class="mb20">
			<textarea cols="50" rows="5" placeholder="메모를 입력하세요" name = "arrangeCommand.arrangeMemo" style="width: 908px">${command.arrangement.arrangeMemo}</textarea>
		</div>
		<h4>편곡 이미지</h4>
		
		<div class="floatL">
			<img id ="arrange-image-holder" src="${command.arrangeCommand.realArrangeImage}" alt="">
		</div>
		<div class="imgUpload">
			<div class="floatL">
				<a class="uploadBtn" data-upload-type = "4" href="#none">
				<span>업로드 image</span></a>
			</div>
			<p class="uploadPut">
				<img id ='arrange-image-progress-img' src = ''>
				<span style ="padding-left: 10px" id ='arrange-image-progress-string'></span>
			</p>
			<p class="ml130">* PNG, BMP, JPG, GIF 포맷의 파일을 업로드 할 수 있습니다.</p> 
		</div>
	</div>
	<div class="hType1">
		<h3>
			편곡자 배분율 및 배포 설정<strong class="pointColor">(필수)</strong>
		</h3>
	</div>
	<div class="arrInfoWrap">
		<h4>배포 수</h4>
		<div class="contBox01 mb20">
			<p class="bulList mb10" >배포 수를 지정하시면 당 편곡은 지정한 배포 수 만큼만 보컬에게 판매됩니다.</p>
				<input type="radio" name = "arrangeCommand.limitStatus" class = "limitStatus "  <c:if test ="${command.arrangeCommand.limitStatus  == 'N'}"> checked = "checked"</c:if> name ="arrangement.limitStatus" value = "N" id="unlimit"/><label for="unlimit">무제한</label>
				<input type="radio" name = "arrangeCommand.limitStatus" class = "limitStatus"  <c:if test ="${command.arrangeCommand.limitStatus  == 'Y'}"> checked = "checked"</c:if> name ="arrangement.limitStatus" value = "Y" id="limit"/><label for="limit">제한</label>
				<input type="text"  name = "arrangeCommand.limitCount"  class = "limitCountBox" 
					<c:choose>
						<c:when test ="${command.arrangeCommand.limitStatus  == 'N'}">
							disabled
						</c:when>
						<c:when test ="${command.arrangeCommand.limitStatus  == 'Y'}">
							value ="${command.arrangeCommand.realLimitCount}"
						</c:when>
					</c:choose>
				 style="width: 100px; text-align: right;"> 명
		</div>
		<h4>배분율</h4>
		<div class="contBox01">
			<ul>
				<li>
					해당 편곡이 판매 되었을 때 받으실 배분율을 선택해주세요. 배분율에 대해서 알고 싶으시면 <a class="linkArea" href="#none">여기</a>를
					클릭하세요.
				</li>
				<li>
					무료로 배포하시더라도 차후 2차 수익이 발생했을 때를 위해서 기입해 주세요. 
					<p style ="margin-top: 10px">
					<input type="text"   id ="arrangeRate" name = "arrangeCommand.arrangeRate" value = "${command.arrangeCommand.arrangeRate}" style="width: 100px; text-align: right;"> &nbsp;%
					</p>
				</li>
			</ul>
		</div>
	</div>
	<div class="hType1">
		<h3>연주자 입력</h3>
	</div>
	<!--tab-->
	
	<div class="tabWrapType1">
		<ul class="tabBtnSet1">
			<li><a href="#none"><span>프로세스</span></a></li>
			<li><a href="#none"><span>음원</span></a></li>
		</ul>
		<!-- tabBox1 -->
		<div class="tabCont">
		
			<div class="arrInfoWrap mb20">
				<h4>연주자 및 연주 파트 정보</h4>
				<div class="floatL">
					<select id ="playFields"  class="dropdown" name="">
						<!-- <option value = "a" selected ="selected" >연주 파트</option> -->
						<c:forEach items = "${playFields}" var = "playField">
							<option value ="${playField.playFieldNo}">${playField.playFieldName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="floatL mb20">
					<input type="text" id ="playFieldInput" class="selectInput" placeholder="직접입력">
					<a href="#none" class="addLineType2"><i
						class="fa fa-plus-circle"></i></a>
				</div>
				<fmt:parseNumber  var = "performanceCommandLength" value = "${fn:length(command.performanceCommands)}"/>
				<input type ="hidden" name = "performsLength" value = "${performCommandLength}"/>
				
				<table class="tblType02 addTrType2 mb20">
					<colgroup>
						<col style="width: 10%">
						<col style="width: 8%">
						<col style="width: auto">
						<col style="width: 15%">
						<col style="width: 8%">
						<col style="width: 8%">
						<col style="width: 8%">
						<col style="width: 8%">
					</colgroup>
					<c:if test = "${performanceCommandLength > 0 }">
					
					<c:forEach items = "${command.performanceCommands}" var = "performanceCommand" 
						begin = "0" end = "${performanceCommandLength -1}" varStatus = "status">
					<tr>
						<td>
							${performanceCommand.playFieldName}
						</td>
						<td>
							<a href="#none" class = 'layerPopType1'><i class="fa fa-user"></i></a>
						</td>
						<td>
							<input type = "hidden"  name = "performanceCommands[${status.index}].updateType" 	  	value = "${performanceCommand.updateType}" 		  class ="updateType" />
							<input type = "hidden"  name = "performanceCommands[${status.index}].isMessageSend"   	value = "${performanceCommand.isMessageSend}" 	  class ="isMessageSend"/>
							<input type = "hidden"  name = "performanceCommands[${status.index}].messageContent"    value = "" 	 class ="message"/>
							<input type = "hidden"  name = "performanceCommands[${status.index}].messageType"       value = ""   class ="messageType"/>
							<input type = "hidden"  name = "performanceCommands[${status.index}].playFieldNo"     	value = "${performanceCommand.playFieldNo}" 	  class ="playFieldNo"/>
							<input type = "hidden"  name = "performanceCommands[${status.index}].playFieldName"   	value = "${performanceCommand.playFieldName}" 	  class ="playFieldName"/>
							<input type = "hidden"  name = "performanceCommands[${status.index}].performMemberNo"   value = "${performanceCommand.performMemberNo}"   class ="selectedMemberNo"/>
							<input type = "text" 	name = "performanceCommands[${status.index}].performMemberName" value = "${performanceCommand.performMemberName}" class = "selectedMemberBox" readonly  placeholder="선택한 연주자 이름" style="width: 200px;">
						</td>
						<td>
							<input type="text" name = "performanceCommands[${status.index}].performRate" value = "${performanceCommand.performRate}" style="width: 50px; text-align: right;" 
								class ="performRate"> % 배분
						</td>
						<td>
							<a href="#none" class = 'layerPopType2'><i class="fa fa-envelope"></i></a>
						</td>
						<td>
							<a href="#none"><i class="fa fa-check-circle"></i></a></td>
						<td>
							<a href="#none"><i class="fa fa-external-link"></i></a></td>
						<td>
							<a href="#none" class="removeLineType1"><i class="fa fa-minus-circle"></i></a>
						</td>
					</tr>
					</c:forEach>
					</c:if>
				</table>
				<h4>
					작사가 배분율<strong class="pointColor">(필수)</strong>
				</h4>
				<input type="text" name = "arrangeCommand.lyricsRate" id ="lyricsRate" value ="${command.arrangeCommand.lyricsRate}" 
					style = "width: 96px; text-align: right;" class ="compseRate" >&nbsp;%&nbsp; 배분
			</div>
		</div>
		<!-- //tabBox1 -->
		<!-- tabBox2 -->
		<div class="tabCont">
			<ul class="soundSource arrList2">
				<li>
					<div class="soundSource">
						<p class="musician">기타</p>
						<div class="soundArea">
							<div class="soundHeader">
								<a href="#none" class="bulPlay" data-sound-url=""><i
									class="fa fa-play-circle fa-2x"></i></a> <span class="songTitle"><input
									type="text" placeholder="선택한 연주자 이름"></span>
							</div>
							<!-- 개발에서 확인요망 -->
							<div class="soundBody">
								<div class="pajaImg">
									<img src="../resources/images/holderType2.gif" class="mb20" alt=""
										style="width: 100%;">
								</div>
								<div class="soundBar"></div>
							</div>
							<!-- //개발에서 확인요망 -->
						</div>
						<div class="soundState">연주중</div>
					</div>
				</li>
				<li>
					<div class="soundSource">
						<p class="musician">기타</p>
						<div class="soundArea">
							<div class="soundHeader">
								<a href="#none" class="bulPlay" data-sound-url=""><i
									class="fa fa-play-circle fa-2x"></i></a> <span class="songTitle"><input
									type="text" placeholder="선택한 연주자 이름"></span>
							</div>
							<!-- 개발에서 확인요망 -->
							<div class="soundBody">
								<div class="pajaImg">
									<img src="../resources/images/holderType2.gif" class="mb20" alt=""
										style="width: 100%;">
								</div>
								<div class="soundBar"></div>
							</div>
							<!-- //개발에서 확인요망 -->
						</div>
						<div class="soundState">연주중</div>
					</div>
				</li>
			</ul>
		</div>
		<!-- //tabBox2 -->
	</div>
	<!-- //tab -->
	<div class="hType1">
		<h3>
			보컬 정보 입력<strong class="pointColor">(필수)</strong>
		</h3>
		<p>당 편곡에 대하여, 노래를 부를 보컬을 지정하거나 혹은 누구에게든지 공개하여 자유롭게 부르게 할 수 있습니다.</p>
	</div>
	<div class="arrInfoWrap">
		<h4>보컬 공개 여부</h4>
		<div class="mb20">
			<input type="radio" name ="arrangeCommand.openStatus" id="openVocal" 
				<c:if test ="${command.arrangeCommand.openStatus  == 'Y' }"> checked = "checked"</c:if> value ="Y">
				<label for="openVocal">공개</label>
			<input type="radio" name ="arrangeCommand.openStatus" id="closedVocal" 
				<c:if test ="${command.arrangeCommand.openStatus  == 'N' }"> checked = "checked"</c:if> class="checkType1" value ="N">
			<label for="closedVocal">비공개</label>  
			<strong class="pointColor">(편곡의 보컬에 대한 공개 여부를 지정합니다.)</strong>
		</div>
		<fmt:parseNumber  var = "arrangeVocalLength" value = "${fn:length(command.arrangeVocalCommands)}"/>
		<input type ="hidden" id = "arrangeVocalLength" name = "arrangeVocalLength" value = "${arrangeVocalLength}"/>
		
		<div class ="vocalAddContainer">
			<div class="hiddenBoxType1" <c:if test ="${command.arrangeCommand.openStatus  == 'Y'}"> style ="display:none"</c:if> >
				<div class="btnVocalAdd">
					<a href="#none" class="addLineType1 btn topayc"><span>보컬추가</span></a>
				</div>
			</div>
			
			<div class="floatL" style="width: 30%;">
				<table class="tblType02 addTrType1">
					<colgroup>
						<col style="width: 10%">
						<col style="width: auto">
						<col style="width: 20%">
						<col style="width: 10%">
					</colgroup>
					<c:if test = "${command.arrangeCommand.openStatus == 'N'}">
						<c:if test = "${arrangeVocalsCommandLength > 0 }">
							<c:forEach items = "${command.arrangeVocalCommands}" var = "arrangeVocalCommand" begin = "0" end = "${arrangeVocalsCommandLength-1}" varStatus ="status">
								<tr>
									<td>
										<a href="#none" class = "layerPopType3" >
											<i class="fa fa-user"></i>
										</a>
									</td>
									<td>
										<input type = "hidden" name = "arrangeVocalCommands[${status.index}].updateType" 	  value = "${arrangeVocalCommand.updateType}" class ="updateType" />
										<input type = "hidden" name = "arrangeVocalCommands[${status.index}].isMessageSend"   value = "${arrangeVocalCommand.isMessageSend}" class ="isMessageSend"/>
										<input type = "hidden" name = "arrangeVocalCommands[${status.index}].messageType"     value = "" class ="messageType"/>
										<input type = "hidden" name = "arrangeVocalCommands[${status.index}].messageContent"  value = "" class ="message"/>
										<input type = "hidden" name = "arrangeVocalCommands[${status.index}].vocalMemberNo"   value = "${arrangeVocalCommand.vocalMemberNo}" class ="selectedMemberNo"/> 
										<input type	= "text"   name = "arrangeVocalCommands[${status.index}].vocalMemberName" value = "${arrangeVocalCommand.vocalMemberName}" id = "selectedMemberBox" class = 'selectedMemberBox' >
									</td>
									<td>
										<a href="#none" class = "layerPopType4" >
											<i class="fa fa-envelope"></i>
										</a>
									</td>
									<td>
										<a href="#none" class="removeLineType1">
											<i class="fa fa-minus-circle"></i>
										</a>
									</td>
								</tr>						
							</c:forEach>
					</c:if>
				</c:if>
				</table>
			</div>
		</div>
	</div>
	<div class="btnAreaType01">
		<div class="textR">
			<a class="btn large" href="#none"><span>취소</span></a> 
			<a class="btn large btnPoint" href="#none" id ="arrange-update-submit"><span>등록</span></a>
		</div>
	</div>

	<!-- layer popup : 편곡자찾기 -->
	<div class="layer">
		<div class="bg"></div>
		<div id="arrangeFind" class="pop-layer">
			<div class="layerPopupWrap">
				<h3>편곡자 찾기</h3>
				<div class="popCont">
					<div class="floatL mb10">
						<select class="dropdown" name="">
							<option>편곡자1</option>
							<option>편곡자2</option>
						</select>
					</div>
					<div class="floatR mb10">
						<input type="text"><a class="btn small btnPoint ctgView"
							href="#none"><span>검색</span></a>
					</div>
					<table class="tblType03 addTrType2">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 25%">
							<col style="width: auto">
							<col style="width: 20%">
						</colgroup>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>활동분야</th>
							<th>선택</th>
						</tr>
						<tr>
							<td>1</td>
							<td>안영철</td>
							<td>작곡 / 편곡 / 연주</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '1' data-member-name = '안영철' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>김지민</td>
							<td>작곡 / 편곡 / 연주</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '2' data-member-name = '김지민' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>홍길동</td>
							<td>작곡 / 편곡 / 연주</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '3' data-member-name = '홍길동' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
					</table>
					<div class="textC mt20">
						<a class="btn large btnPoint btnClose" href="#none"><span>닫기</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //layer popup -->

	<!-- layer popup : 메시지 보내기 -->
	<div class="layer">
		<div class="bg"></div>
		<div id="msgSend" class="pop-layer ">
			<div class="layerPopupWrap">
				<h3>
					<strong class = 'title'>메투리스</strong> 님에게 메시지 보내기
				</h3>
				<div class="popCont">
					<div class="popListType01">
						<dl>
							<dt>곡명</dt>
							<dd>${command.compositionCommand.composeTitle}_${command.arrangeCommand.arrangeTitle} </dd>
							<dt>메세지 구분</dt>
							<dd>
								<div class="floatL mb10">
									<select class="dropdown" id ="messageTypeSelect" name="">
										<c:forEach items = "${memberMessageTypes}" var ="messageType">
											<option value ="${messageType.code}">${messageType.codeString}</option>
										</c:forEach>
									</select>
								</div>
							</dd>
						</dl>
					</div>
					<h4 class="tit01">메시지</h4>
					<textarea class="msgDiv messageTextArea"></textarea>
					<div class="textC mt20">
						<a class="btn large btnPoint btnClose messageSendCancel" href="#none"><span>취소</span></a>
						<a class="btn large btnPoint btnClose messageSendOk" href="#none"><span>확인</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //layer popup -->

	<!-- layer popup : 연주자 지정 -->
	<div class="layer">
		<div class="bg"></div>
		<div id="playerAppoint" class="pop-layer">
			<div class="layerPopupWrap">
				<h3>연주자 지정</h3>
				<div class="popCont">
					<div class="tabWrapType1">
						<ul class="tabBtnSet1">
							<li><a href="#none"><span>참여 대상 리스트</span></a></li>
							<li><a href="#none"><span>새로운 연주자 검색</span></a></li>
						</ul>
						<!-- tabBox1 -->
						<div class="tabCont">
							<table class="tblType03 addTrType2">
								<colgroup>
									<col style="width: 10%">
									<col style="width: 25%">
									<col style="width: auto">
									<col style="width: 20%">
								</colgroup>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>활동분야</th>
									<th>선택</th>
								</tr>
								<tr>
									<td>1</td>
									<td>안영철</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '1' data-member-name = '안영철' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>김지민</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '2' data-member-name = '김지민' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td>홍길동</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '3' data-member-name = '홍길동' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
							</table>
						</div>
						<!-- //tabBox1 -->
						<!-- tabBox2 -->
						<div class="tabCont">
							<div class="floatL mb10">
								<select class="dropdown" name="">
									<option>편곡자1</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
									<option>편곡자2</option>
								</select>
							</div>
							<div class="floatR mb10">
								<input type="text"><a class="btn small btnPoint ctgView"
									href="#none"><span>검색</span></a>
							</div>
							<table class="tblType03 addTrType2">
								<colgroup>
									<col style="width: 10%">
									<col style="width: 25%">
									<col style="width: auto">
									<col style="width: 20%">
								</colgroup>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>활동분야</th>
									<th>선택</th>
								</tr>
								<tr>
									<td>1</td>
									<td>안영철</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '1' data-member-name = '안영철' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>김지민</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '2' data-member-name = '김지민' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td>홍길동</td>
									<td>작곡 / 편곡 / 연주</td>
									<td>
										<a class="btn small btnPoint ctgView" href="#none">
											<span data-member-no = '3' data-member-name = '홍길동' class = 'select-member'>select</span>
										</a>
									</td>
								</tr>
							</table>
						</div>
						<!-- //tabBox2 -->
						<div class="textC mt20">
							<a class="btn large btnPoint btnClose" href="#none"><span>닫기</span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //layer popup -->

	<!-- layer popup : 보컬검색 -->
	<div class="layer">
		<div class="bg"></div>
		<div id="vocalSearch" class="pop-layer">
			<div class="layerPopupWrap">
				<h3>보컬검색</h3>
				<div class="popCont">
					<div class="floatL mb10">
						<select class="dropdown" name="">
							<option>보컬1</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>
							<option>보컬2</option>

						</select>
					</div>
					<div class="floatR mb10">
						<input type="text"><a class="btn small btnPoint ctgView"
							href="#none"><span>검색</span></a>
					</div>
					<table class="tblType03 addTrType2">
						<colgroup>
							<col style="width: 10%">
							<col style="width: 25%">
							<col style="width: auto">
							<col style="width: 20%">
						</colgroup>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>활동분야</th>
							<th>선택</th>
						</tr>
						
						<tr>
							<td>1</td>
							<td>안영철</td>
							<td>보컬</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '1' data-member-name = '안영철' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>김지민</td>
							<td>보컬</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '2' data-member-name = '김지민' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>홍길동</td>
							<td>보컬</td>
							<td>
								<a class="btn small btnPoint ctgView" href="#none">
									<span data-member-no = '3' data-member-name = '홍길동' class = 'select-member'>select</span>
								</a>
							</td>
						</tr>
					</table>
					<div class="textC mt20">
						<a class="btn large btnPoint btnClose" href="#none"><span>닫기</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</form>
	<!--이미지 업로드용 폼-->
	<form  action = "/music/upload/uploadFile" style = "display:none;" method = "post" enctype = "multipart/form-data" 
					id = "arrange_file_upload" name = "arrange_file_upload" >
		<input type = "hidden" name = "uploadType" 	 id = "uploadType" value = ""/>
		<input type = "hidden" name = "musicClassNo" id = "musicClassNo" value = "02"/>
		<input type = "hidden" name = "musicNo"      id = "musicNo" value = "${command.arrangement.arrangeNo}"/>
		<input type	= "file"   name = "uploadFile"   id = "uploadFile" />
	</form>
	<!-- //layer popup -->
</div>

<!-- 업로드 스크립트 (안영철)
차후 별도의 자바 스크립트 클래스 모듈로 분리  -->
<script type="text/javascript" src="../resources/common/old/js/jquery.form.js"></script>
<script type = "text/javascript">
	var composeRate = ${command.compositionCommand.composeRate};
	var arrangeRate = ${command.arrangement.arrangeRate};
	
	var dotCount = 0;
	
	var holderIndex = 0;
	var progressImageIndex = 1;
	var progressStringIndex = 2;
	var sourcePlayIndex = 3;
	
	var curUploadType  = '';
	var isUploading = false;
	var curUploadElement; 
	var fileSize = 0;
	var dot
	var intervalCode = -1;
	var compleIntervalCode = -1;
	var eventCount =0;
	var repeat =0;
	
	var UploadTypeArray = [
			/* {arrange_sound 			: */ { typeCode: '1'	,target: ['#arrange-frequency-holder','#arrange-sound-progress-img','#arrange-sound-progress-string','#arrange-play']}/* } */,
			/* {arrange_score 			:  */{ typeCode: '2'	,target: ['','#arrange-score-progress-img','#arrange-score-progress-string']}/* } */,
			/* {arrange_extra 			:  */{ typeCode: '3'	,target: ['','#arrange-zip-progress-img','#arrange-zip-progress-string']}/* } */,
			/* {arrange_image 			:  */{ typeCode: '4'	,target: ['#arrange-image-holder','#arrange-image-progress-img','#arrange-image-progress-string']}/* } */,
			/* {arrange_complete_sound  :  */{ typeCode: '5'	,target: []}/* } */,
			/* {arrange_guide_sound 	:  */{ typeCode: '6'	,target: []}/* } */,
			/* {compose_image 			:  */{ typeCode: '7'	,target: []}/* } */,
			/* {compose_sound 			:  */{ typeCode: '8'	,target: []}/* } */,
			/* {compose_score 			:  */{ typeCode: '9'	,target: []}/* } */,
			/* {vocal_image   			:  */{ typeCode: '10'	,target: []}/* } */,
			/* {vocal_sound  			:  */{ typeCode: '11'	,target: []}/* } */,
			/* {perform_sound 			:  */{ typeCode: '12'	,target: []}/* } */,
			/* {profile_image 		    :  */{ typeCode: '13'	,target: []}/* } */
	];
	
	// 파일 확장자 분리
	function extractExt(fileName){
		var last_point = fileName.lastIndexOf('.');
        var extension = fileName.substring(last_point +1,  fileName.length);
        return extension.toLowerCase();
	}
	
	$('.uploadBtn').click(function() {
		alert(i18n('login.start'));
		return false;
		if (isUploading){
			alert('현재 업로드가 진행중입니다. 끝나고 시도해주세요');
			return;
		}
		
		curUploadType = $(this).attr('data-upload-type');
		$('#uploadType').val(curUploadType);
		
		curUploadElement = $(this);
		$('#uploadFile').trigger('click');
	});
	
	$('#uploadFile').change(function() {
		if ($('#uploadType').val() ==''){
			return ;		
		}
	
		isUploading = true;
		var f  = this.files[0];
		fileSize = f.size || f.file.Size;
		
		var index = Number($('#uploadType').val()) -1;
		var fileName = $('#uploadFile').val();
		var fileExt = extractExt(fileName);
		var file_bool = false;
		var message = "";
		
		var curUploadType = $('#uploadType').val();
		if (curUploadType == UploadTypeArray[1].typeCode || curUploadType == UploadTypeArray[3].typeCode ||  
				curUploadType == UploadTypeArray[6].typeCode  || curUploadType == UploadTypeArray[8].typeCode || 
				curUploadType == UploadTypeArray[12].typeCode){
			
			if(fileExt == 'png' || fileExt == 'bmp' ||  fileExt == 'gif' || fileExt == 'jpg'){
				file_bool = true;
			}else {
				file_bool = false
				message = ' 이미지 파일은 png, jpg, bmp, gif 만 업로드가 가능합니다';
				$('#uploadType').val('');
			}
		}else if (curUploadType == UploadTypeArray[0].typeCode ||  curUploadType == UploadTypeArray[4].typeCode || 
				curUploadType == UploadTypeArray[5].typeCode || curUploadType == UploadTypeArray[7].typeCode || 
				curUploadType == UploadTypeArray[10].typeCode) {
			
			if(fileExt == 'wav' || fileExt == 'mp3'){
				file_bool = true;
			}else {
				file_bool = false
				message = ' 음원 파일은 wav , mp3 파일만 업로드가 가능합니다'; 
			}
		}else if (curUploadType == UploadTypeArray[2].typeCode){
			if (fileExt == 'zip') {
				file_bool = true;
			}else {
				file_bool = false;
				 message = ' 추가 파일은 zip 파일만 업로드가 가능합니다.'; 
			}
		}else {
			file_bool = false;
			message = '파일 포맷이 문제가 있습니다. 다시 시도해주세요';
		}
		
		if(!file_bool){
			alert(message);
			$('#uploadType').val('');
			isUploading = false;
			return;
		} else{ 
			$('#arrange_file_upload').submit();
		}
	});
	
	$('#arrange_file_upload').ajaxForm({
		dataType :'json',
		type : 'POST',
		
		beforeSend: function() {
			var index = Number($('#uploadType').val()) -1;
			$(UploadTypeArray[index].target[progressImageIndex]).show();
			$(UploadTypeArray[index].target[progressStringIndex]).html('<strong> File Size : ' + fileSize + '  </strong>  ready to upload ').show();	
		},
		
		uploadProgress: function(event, position, total, percentComplete) {
			var index = Number($('#uploadType').val()) -1;
			if (position < total ){
				$(UploadTypeArray[index].target[progressStringIndex]).html( '<strong>'+ position + '  /  ' + total + ' ( ' + percentComplete + ' % )</strong>  uploading   ' /* + dotString */ );
			} else {
				if (index == 0){
					var formatObj = $(UploadTypeArray[index].target[progressStringIndex])
					formatObj.css('color','gray');
					formatObj.html( '<strong style ="color:green">Converting The Audio File Format .....   Please Wait</strong>   '/*  + dotString  */);
					intervalCode = setInterval(function() {
						if (formatObj.css('visibility') == 'visible') {
							formatObj.css('visibility', 'hidden'); 
						} else {
							formatObj.css('visibility', 'visible');
						}
					},500); 
				}
			}
		},
		
		error: function(jqXHR, textStatus, errorThrown){
			alert("서버 오류로 업로드 및 파일 변환이 실패했습니다");
			isUploading = false;  
        },
		
		complete: function(req) {
			if (intervalCode != -1){
				clearInterval(intervalCode);
				intervalCode = -1;
			}
			var curUploadType = $('#uploadType').val();
			var index = Number(curUploadType) -1;
			$(UploadTypeArray[index].target[progressImageIndex]).hide();
			$(UploadTypeArray[index].target[progressStringIndex]).html('<strong style ="color:#E57733">Upload Completed</strong>');	
			
			var repeat = 0;
			compleIntervalCode = setInterval(function() {
				var formatObj = 	$(UploadTypeArray[index].target[progressStringIndex]);
				repeat = repeat + 1;
				if (repeat == 10){
					formatObj.html('').hide();
					repeat = 0;
					clearInterval(compleIntervalCode);
				}else {
					if (formatObj.css('visibility') == 'visible'){
						formatObj.css('visibility', 'hidden'); 
					} else {
						formatObj.css('visibility', 'visible');
					}
				}
			},500);
			
			var  obj = eval('('+req.responseText+')'); 
			switch(curUploadType){
			case '1':
				$(UploadTypeArray[index].target[holderIndex]).attr('src', obj.frequencyImage);
				$(UploadTypeArray[index].target[sourcePlayIndex]).attr('data-sound-url', obj.ogg +';' + obj.mp3);
				break;
			case '4':
				$(UploadTypeArray[index].target[holderIndex]).attr('src', obj.image);
				break;
			}
			$('#uploadType').val($(''));
			$('#uploadFile').val('');
			curUploadType = '';
			isUploading = false;
		}
	});
	
	$(document).ready(function() {
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
	    		alert("수익 배분은 작곡자, 편곡자 , 작사가 배분율을 더해서 \n총 100 % 가되어야 합니다");
	    		$(target).val('');
	    		$(target).focus();
	    		return false;
	    	}
		
	    	return true;
		}
		
		$('a#naver').click(function(event){
			location.href= "http://www.daum.net";
			event.preventDefault(); 
		});
		
	    $('.limitStatus').change(function() {
	        if ($(this).val() == 'Y'){
	        	$('.limitCountBox').attr('disabled', false).val('0');
	        }else {
	        	$('.limitCountBox').attr('disabled', true).val('');
	        }
	    });
	    
	    //폼 등록 버튼 클릭시 호출
	    $('#arrange-update-submit').click(function(event){
	    	event.preventDefault();
	    	if (!checkRate()){
	    		alert("수익 배분은 작곡자, 편곡자 , 작사가 배분율을 더해서 \n총 100 % 가되어야 합니다");
	    		return;
	    	}
	    	//기타 입력갑 검증
	    	//검증이 통과할 경우 폼 제출
	    	$('#arrange-update-form').attr('action','/music/arrange/update').submit();
	    });
	    
	    //편곡 배분율, 작사 배분율 , 각 연주파트 배뷴율이 변경될 때 호출되어 값의 유효험위를 체크한다.
	    $(document).on('change', '#arrangeRate, #lyricsRate', function(){
	    	checkRate(this);
	    });
	});
	
</script>
<!-- //contents -->
<%@ include file="../include/bottom.jsp"%>
</html>
