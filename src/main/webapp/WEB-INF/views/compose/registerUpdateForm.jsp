<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ include file="../include/top.jsp"%>

<c:set var = "command" value = "${composeUpdateCommand}"/>
<fmt:parseNumber  var = "composeArrangeCommandsLength" value = "${fn:length(command.composeArrangeCommands)}"/>
<input type="hidden" id="composeArrangeCount" name="composeArrangeCount" value = "${composeArrangeCommandsLength}"/>

<form id = "arrange-update-form" name = "arrange-update-form" method ="post" >
            <div class="contents">
            	<div class="titleWrap">
					<h2 class="testBtn">곡 등록</h2>
				</div>
                <div class="hType1">
                    <h3>곡 제목</h3>
                    <p>등록하시려는 곡의 제목을 입력해주세요.</p>
                </div>
                <div class="mb20"><input type="text" id="composeTitle" name="composeTitle" value="${command.compositionCommand.composeTitle}" readonly style="width: 99%"></div>
                
                <div class="hType1">
                    <h3>곡 이미지</h3>
                </div>
                
                <div class="arrInfoWrap">
                    <div class="floatL"><img id ="compose-image-holder" src="${command.compositionCommand.realComposeImage}"  alt="" style="width: 120px; height: 120px;">
                    </div>
                    <div class="imgUpload">
                    	<div class="floatL">
                    		<a class="uploadBtn"  data-upload-type = "7" href="#none"><span>파일선택</span></a>
                    	</div>
                    		<p class="uploadPut">
								<img id ='compose-image-progress-img' src = ''/>
								<span style ="padding-left: 10px" id ='compose-image-progress-string'></span>
							</p>
                   		<p>* 업로드 된 이미지는 곡이 게재될 시 같이 보여집니다.</p>
                   	</div>
                </div>
                
                
                <div class="hType1">
                    <h3>작곡 설명</h3>
                    <p>곡에 대한 설명을 입력해주세요.</p>
                </div>
                
              	<div class="mb20">
					<textarea cols="50" rows="5" placeholder="메모를 입력하세요" name = "composition.composeMemo" style="width: 99%">${command.compositionCommand.composeMemo}</textarea>
				</div>
                <div class="hType1">
                    <h3>작곡 업로드<strong class="pointColor">(필수 1개)</strong></h3>
                    <p>작곡 악보나 작곡 음원을 업로드 할 수 있습니다. 업로드한 파일은 작곡 리스트에서 보여집니다.</p>
                </div>
                <div class="arrInfoWrap">
                	<div class="floatL"><a class="uploadBtn" data-upload-type = "8" href="#none"><span>파일선택(음원)</span></a></div>
                    <p class="uploadPut">
                    	<img id ='compose-sound-progress-img' src = ''/>
						<span style ="padding-left: 10px" id ='compose-sound-progress-string'></span>
                    </p>
                    <div class="floatL"><a class="uploadBtn" data-upload-type = "9" href="#none"><span>파일선택(악보)</span></a></div>
                    <p class="uploadPut">
                    	<img id ='compose-score-progress-img' src = ''/>
						<span style ="padding-left: 10px" id ='compose-score-progress-string'></span>
                    </p>
                </div>
                <div class="hType1">
                    <h3>배포 가격 및 정산율<strong class="pointColor">(필수)</strong></h3>
                </div>
                <div class="arrInfoWrap">
                    <div class="contBox01 mb20">
                    	<ul>
	                		<li>자신의 곡을 무료와 유료로 배포할 수 있습니다.</li>
	                		<li>유료로 배포 할 경우에는 배포 가격과 자신이 원하는 정산율을 기입해주세요.</li>
	                	</ul>
                        
                        <input type="radio" name ="composition.chargeStatus" id="freeMusic" 
							<c:if test ="${command.compositionCommand.chargeStatus  == 'N' }">  checked = "checked"</c:if> value ="N">
							<label for="freeMusic">무료</label>
						<input type="radio" name ="composition.chargeStatus" id="chargeMusic" 
							<c:if test ="${command.compositionCommand.chargeStatus  == 'Y' }">  checked = "checked"</c:if> class="checkType1" value ="Y">
							<label for="chargeMusic">유료</label> 
                        
                    </div>
                </div>
                <div class="hType1">
                    <h3>배포 가격</h3>
                </div>
                <div class="pl20"><input type="text" style="width: 100px; text-align: right;" name="composition.salePrice" value="${command.compositionCommand.salePrice}" > $</div>
                <div class="hType1">
                    <h3>배분율</h3>
                </div>
                <div class="arrInfoWrap">
	                <div class="contBox01">
	                	<ul>
	                		<li>해당 작곡이 판매 되었을 때 받으실 배분율을 선택해주세요.</li>
	                		<li>배분율에 대해서 알고 싶으시면 <a class="linkArea" href="#none">여기</a>를 클릭하세요.</li>
	                		<li>무료로 배포하시더라도 차후 2차 수익이 발생했을 때를 위해서 기입해 주세요. <input type="text" style="width: 50px; text-align: right;" name="composition.composeRate" value="${command.compositionCommand.composeRate}" > %</li>
	                	</ul>
	                </div>
	            </div>
                <div class="hType1">
                    <h3>공개 여부 선택<strong class="pointColor">(필수)</strong></h3>
                </div>
                <div class="arrInfoWrap">
                    <h4>공개 여부</h4>
                    <div class="mb20">
						<input type="radio" name ="composition.openStatus" id="openArrange" 
							<c:if test ="${command.compositionCommand.openStatus  == 'Y' }">    checked = "checked"</c:if> value ="Y">
							<label for="openArrange">공개</label>
						<input type="radio" name ="composition.openStatus" id="closedArrange" 
							<c:if test ="${command.compositionCommand.openStatus  == 'N' }"> checked = "checked"</c:if> class="checkType1" value ="N">
						<label for="closedArrange">비공개</label>  
                    </div>
                    
                   	<div class ="arrangeAddContainer">
						<div class="hiddenBoxType1" <c:if test ="${command.compositionCommand.openStatus  == 'Y'}"> style ="display:none"</c:if> >
							<div class="btnVocalAdd">
								<a href="#none" class="addLineType4 btn topayc"><span>편곡자추가</span></a>
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
								
								<c:if test = "${command.composition.openStatus == 'N' && composeArrangeCommandsLength > 0}">
								<c:forEach items = "${command.composeArrangeCommands}" var = "composeArrangeCommand" begin = "0" 
									end = "${composeArrangeCommandsLength-1}" varStatus ="status">
									<tr>
										<td>
											<a href="#none" class = "layerPopType3" >
												<i class="fa fa-user"></i>
											</a>
										</td>
										<td>
											<input type = "hidden" name = "composeArrangeCommands[${status.index}].updateType" 	  value = "${composeArrangeCommand.updateType}" class ="updateType" />
											<input type = "hidden" name = "composeArrangeCommands[${status.index}].isMessageSend"   value = "${composeArrangeCommand.isMessageSend}" class ="isMessageSend"/>
											<input type = "hidden" name = "composeArrangeCommands[${status.index}].messageType"     value = "" class ="messageType"/>
											<input type = "hidden" name = "composeArrangeCommands[${status.index}].messageContent"  value = "" class ="message"/>
											<input type = "hidden" name = "composeArrangeCommands[${status.index}].arrangeMemberNo"   value = "${composeArrangeCommand.arrangeMemberNo}" class ="selectedMemberNo"/> 
											<input type	= "text"   name = "composeArrangeCommands[${status.index}].arrangeMemberName" value = "${composeArrangeCommand.arrangeMemberName}" id = "selectedMemberBox" class = 'selectedMemberBox' >
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
							</table>
						</div>
				</div>
                    
                   
                </div>
                <div class="btnAreaType01">
                	<div class="textR">
	                    <a class="btn large" href="#none"><span>취소</span></a>
	                    <a class="btn large btnPoint" href="#none" id ="compose-update-submit"><span>등록</span></a>
	                </div>
                </div>


                <!-- layer popup : 메시지 보내기 -->
                <div class="layer">
                    <div class="bg"></div>
                    <div id="msgSend" class="pop-layer">
                        <div class="layerPopupWrap">
                            <h3><strong class = 'title'>메투리스</strong> 님에게 메시지 보내기</h3>
                            <div class="popCont">
                                <div class="popListType01">
                                    <dl>
                                        <dt>곡 명</dt>
                                        <dd>${command.compositionCommand.composeTitle}</dd>
                                        <dt>메시지 구분</dt>
                                        <dd>
										<dd>
											<div class="floatL mb10">
												<select class="dropdown" id ="messageTypeSelect" name="">
													<c:forEach items = "${memberMessageTypes}" var ="messageType">
														<option value ="${messageType.code}">${messageType.codeString}</option>
													</c:forEach>
												</select>
											</div>
										</dd>
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
                	<!-- layer popup : 편곡자검색 -->
				<div class="layer">
					<div class="bg"></div>
					<div id=vocalSearch class="pop-layer">
						<div class="layerPopupWrap">
							<h3>편곡자검색</h3>
							<div class="popCont">
								<div class="floatL mb10">
									<select class="dropdown" name="">
										<option>편곡자1</option>
										<option>편곡자2</option>
										<option>편곡자3</option>
										<option>편곡자4</option>
										<option>편곡자5</option>
										<option>편곡자6</option>
										<option>편곡자7</option>
										<option>편곡자8</option>
										<option>편곡자9</option>
										<option>편곡자10</option>
										<option>편곡자11</option>
										<option>편곡자12</option>
			
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
										<td>편곡자</td>
										<td>
											<a class="btn small btnPoint ctgView" href="#none">
												<span data-member-no = '1' data-member-name = '안영철' class = 'select-member'>select</span>
											</a>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>김지민</td>
										<td>편곡자</td>
										<td>
											<a class="btn small btnPoint ctgView" href="#none">
												<span data-member-no = '2' data-member-name = '김지민' class = 'select-member'>select</span>
											</a>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>홍길동</td>
										<td>편곡자</td>
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

            </div><!-- //contents -->
</form> 
<%@ include file="../include/bottom.jsp"%>
	
	<!--이미지 업로드용 폼-->
	<form  action = "/music/upload/uploadFile" style = "display:none;" method = "post" enctype = "multipart/form-data" 
					id = "compose_file_upload" name = "compose_file_upload" >
		<input type = "hidden" name = "uploadType" 	 id = "uploadType" value = "">
		<input type = "hidden" name = "musicClassNo" id = "musicClassNo" value = "01">
		<input type = "hidden" name = "musicNo"      id = "musicNo" value = "${command.compositionCommand.composeNo}"/>
		<input type	= "file"   name = "uploadFile"   id = "uploadFile">
	</form>
	<!-- //layer popup -->

<!-- 업로드 스크립트 (안영철)
차후 별도의 자바 스크립트 클래스 모듈로 분리  -->
<script type="text/javascript" src="../resources/common/old/js/jquery.form.js"></script>
<script type = "text/javascript">
	//var composeRate = ${command.compositionCommand.composeRate};
	var composeRate = 0;
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
	        			/* {compose_image 			:  */{ typeCode: '7'	,target: ['#compose-image-holder','#compose-image-progress-img','#compose-image-progress-string']}/* } */,
	        			/* {compose_sound 			:  */{ typeCode: '8'	,target: ['','#compose-sound-progress-img','#compose-sound-progress-string']}/* } */,
	        			/* {compose_score 			:  */{ typeCode: '9'	,target: ['','#compose-score-progress-img','#compose-score-progress-string']}/* } */,
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
	
	// 파일명 분리
	function extractOrigin(fileName){
		var last_point = fileName.lastIndexOf('\\');
        var extension = fileName.substring(last_point +1,  fileName.length);
        return extension.toLowerCase();
	}
	
	$('.uploadBtn').click(function() {
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
		}
		else{ 
			$('#compose_file_upload').submit();
		} 
	});
	
	$('#compose_file_upload').ajaxForm({
		dataType :'json',
		type : 'POST',
		
		beforeSend: function() {
			var index = Number($('#uploadType').val()) -1;
			$(UploadTypeArray[index].target[progressImageIndex]).show();
			$(UploadTypeArray[index].target[progressStringIndex]).html('<strong> File Size : ' + fileSize + '  </strong>  ready to upload ').show();	
		},
		
		uploadProgress: function(event, position, total, percentComplete) {
		/* 	dotCount +=1;
			var i = dotCount % 15;
			var dotString = '';
			for (var k = 0; k < i ;k++){
				dotString +='.';
			} */
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
		complete: function(req) {

			var curUploadType = $('#uploadType').val();
			var index = Number(curUploadType) -1;
			$(UploadTypeArray[index].target[progressImageIndex]).hide();
			var fileName = $('#uploadFile').val();
			
			$(UploadTypeArray[index].target[progressStringIndex]).html("<strong style ='color:#E57733'>"+extractOrigin(fileName)+"</strong>");	
			
			var  obj = eval('('+req.responseText+')'); 
			switch(curUploadType){
			case '1':
				$(UploadTypeArray[index].target[holderIndex]).attr('src', obj.frequencyImage);
				$(UploadTypeArray[index].target[sourcePlayIndex]).attr('data-sound-url', obj.ogg +';' + obj.mp3);
				break;
			case '7':
				$(UploadTypeArray[index].target[holderIndex]).attr('src', obj.image);
				break;
			}
			$('#uploadType').val($(''));
			$('#uploadFile').val('');
			curUploadType = '';
			isUploading = false;
		}
	});
	
	$(document).ready(function(target) {
		
		function checkRate(target){
			var arrangeRate = Number($('#arrangeRate').val());
	    	var salePrice = Number($('#salePrice').val());
	    	
	    	if (arrangeRate > 100){
	    		alert("100% 이내여야 합니다.");
	    		$(target).focus();
	    		return false;
	    	}
	    	
	    	if (salePrice > 100000){
	    		alert("100,000 이내여야 합니다.");
	    		$(target).focus();
	    		return false;
	    	}
	    	return true;
		}
		
	    $('.limitStatus').change(function() {
	        if ($(this).val() == 'Y'){
	        	$('.limitCountBox').attr('disabled', false).val('0');
	        }else {
	        	$('.limitCountBox').attr('disabled', true).val('');
	        }
	    });

	    
	    //폼 등록 버튼 클릭시 호출
	    $('#compose-update-submit').click(function(event){
	    	event.preventDefault();
/* 	    	if (!checkRate()){
	    		alert("수익 배분은 작곡자, 편곡자 , 작사가 배분율을 더해서 \n총 100 % 가되어야 합니다");
	    		return;
	    	} */
	    	//기타 입력갑 검증
	    	//검증이 통과할 경우 폼 제출
	    	$('#arrange-update-form').attr('action','/music/compose/update').submit();
	    });	    
	    
	    
	    //편곡 배분율, 작사 배분율 , 각 연주파트 배뷴율이 변경될 때 호출되어 값의 유효험위를 체크한다.
 	    $(document).on('change', '#salePrice, #composeRate' , function(){
	    	checkRate(this);
	    }); 
	});

	
</script>
<!-- //contents -->
</html>
