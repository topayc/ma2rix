<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 


<%@ include file="../include/top.jsp" %>	


<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">회원정보 수정</h2>
		
		<form id="profile_ch" name="profile_ch" method="post">
			<div class="hType1">
		         <h3>사용하시려는 이름을 입력해주세요.</h3>
		       </div>	
			<div class="ml20">
				<input type="text" class="selectInput" name="user.memberName" id="name" placeholder="이름" value ="${profileCommand.user.memberName}">
				<span id="alert1" class="dp_none ml_30 fc_red">이름은 0~50자(한글 25자) 이내로 입력해야 합니다</span>
			</div>
			<div class="hType1">
		         <h3>사용하시려는 닉네임을 입력해주세요.</h3>
		       </div>
			<div class="ml20">
				<input type="text" name="user.memberNickName" id="nickName" class="selectInput" placeholder="닉네임" value ="${profileCommand.user.memberNickName}">
				<input type="button" id="overlap_chk1" class="overlap" value="중복확인">
				<span id="alert2" class="dp_none ml_30 fc_red">닉네임은 0~50자(한글 25자) 이내로 입력해야 합니다</span>
				<span id="alert3" class="dp_none ml_30 fc_red">닉네임 중복확인이 필요합니다</span>
				<span id="alert4" class="dp_none ml_30 fc_red">사용불가능한 닉네임입니다</span>
				<span id="allow2" class="dp_none ml_30 fc_green">사용가능한 닉네임 입니다</span>
			</div>
			<div class="hType1">
		         <h3>프로필 이미지</h3>
		       </div>
			<div class="image_wrap b_inline">
				<c:choose>
					<c:when test="${profileCommand.user.memberImage == null}">
						<img id="profile_image" src="../resources/images/profile/profile_photo.png" />
					</c:when>
					<c:otherwise>
							<img id="profile_image" src="${profileCommand.profileWebPath}" />
					</c:otherwise>
				</c:choose>
			</div>
			<div class="button_wrap b_inline">
				<div class="b_inline"><input type="button" id="UploadButton" class="overlap2" value="Upload a New Image"></div>
				<div id ="progress" class="progress mt_10">
					<div class="bar"></div >
					<div class="percent">0%</div >
				</div>
			</div>
			<div class="hType1">
			  	<h3>지역</h3>
			</div>
		    <div class="arrInfoWrap">
		    <h4 class="floatL">거주나라</h4>
				<select name="user.countryNo" id="SelectNation" class="SelectNation floatL ml20">
					<option></option>
					<c:forEach items = "${contries}" var = "country">
						<option value ="${country.countryNo}" <c:if test="${country.countryNo == profileCommand.user.countryNo}">selected="selected"</c:if> >
						${country.countryEname}
						</option>
					</c:forEach>
				</select>
				<h4 class="floatL">거주도시</h4>
				<input type="text" name="user.memberCity" id="SelectCity" class="floatL ml20" style="width: 315px;" value = "${profileCommand.user.memberCity}">
			</div>
			<div class="wrap"><input id="geocomplete" type="text" placeholder="Type in an address" value="111 Broadway, New York, NY"></div>
			<div class="map_canvas"></div>
			<div class="hType1">
		        <h3>내소개</h3>
		    </div>
			<textarea cols="150" rows="10" name="user.memberIntroduce">${profileCommand.user.memberIntroduce}</textarea>
			<div class="wrap">
				<div class="hType1 title wrap">
					<h3>My WebSite and Link</h3> 
					<p id="plus1" class="floatL pl10 vertMid"><img src="../resources/images/ico_plus.png"></p>
				</div>		
				<p class="bulList ml20">자신의 웹사이트나 혹은 자신을 알릴 수 있는 사이트가 있으면 등록해주세요.</p>
				<div class="arrInfoWrap">
					<table class="link mt_30 mb30">
						<colgroup>
							<col width="140px" />
							<col width="410px" />
							<col width="310px" />
							<col width="20px" />
						</colgroup>
						<tbody id ="linkWrapper">
							<c:set var = "memberLinksLength" value = "${fn:length(profileCommand.memberLinks)}"/>
							<c:choose>
								<c:when test = "${memberLinksLength == 0}">
								</c:when>
								<c:otherwise>
									<c:forEach items ="${profileCommand.memberLinks}" var = "member_Link" varStatus = "status">
										<tr>
											<th>Web Site</th>
											<td><input type="text" name="memberLinks[${status.count-1}].memberLink" 
												value = "${member_Link.memberLink}" class="w_400 plr_10 memberLink" placeholder="http://"> </td>
											<td><input type="text" name="memberLinks[${status.count-1}].linkComment" 
												value ="${member_Link.linkComment}" class="w_250 plr_10" placeholder="간단한 설명"> </td>
											<td><img class='minus1 verMid' src='../resources/images/ico_minus.png'></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						
						</tbody>
					</table>
				</div>
			</div>
			<div class="wrap">
				<div class="title hType1 pt0"><h3>회원유형</h3></div>
				<div class="arrInfoWrap">
					<h4>활동 분야 선택</h4>
					<div class="ml_10 wrap mt_10 mb30">
						<div class="box">
							<c:forEach items = "${activities}" var = "activity" varStatus = "status">
								<c:forEach items = "${profileCommand.memberFields}" var = "field">
								</c:forEach>
								<label>
									<input type="checkbox" name = "memberFields[${status.count-1}].musicField" value="${activity.codeNo}" 
									<c:if test = "${activity.codeNo == profileCommand.memberFields[status.count-1].musicField}">
										checked = "checked"
									</c:if>
									<c:if test = "${activity.codeNo == '03'}">
										id="chk_bt"
									</c:if>
								 class="playFields">&nbsp;${activity.codeName}&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</c:forEach>
							<c:forEach items = "${profileCommand.memberFields}" var ="field" varStatus = "status">
								<input type = "hidden" value = "${field.musicField}" class ="fieldCount">
							</c:forEach>
						</div>
						<span id="alert5" class="dp_none ml_30 fc_red">활동분야를 선택해주세요</span>
					</div>
					<input type="hidden" id="chk" value="0" />
					<c:set var = "memberPlaysSize" value = "${fn:length(profileCommand.memberPlays)}"/>
					<input type = "hidden" id ="memberPlaysSize" value = "${memberPlaysSize}">
					<div class="hide1 wrap" <c:if test = "${memberPlaysSize == 0}"> style ="display:none;"</c:if> >
						<div class="wrap box_wrap">
							<h4 class="floatL">연주 분야 선택</h4> 
						  	<p class="floatL ml20">자신의 연주 가능 분야를 여러 개 선택할 수 있습니다.<img src="../resources/images/ico_plus.png" class = "ml_10 vertMid" id="plus2"></p>
							<c:choose>
								<c:when test = "${memberPlaysSize == 0}">
									<div class="box">
										<select name="memberPlays[0].playFieldNo" class="memberPlay1" >
											<!-- <option></option> -->
											<c:forEach items = "${playFields}" var = "playField" varStatus = "status">
													<option value="${playField.playFieldNo}">${playField.playFieldName} </option>
											</c:forEach>
										</select>
										<input style = "display:none;" type="text" name="memberPlays[0].playFieldName" value = "${memberPlay.playFieldName}" class="direct_input plr_10 ml_10"/>
												&nbsp;&nbsp;&nbsp;&nbsp;<img src='../resources/images/join/ico_minus.png' class='minus2'/>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach items = "${profileCommand.memberPlays}" var = "memberPlay" varStatus = "memberPlaysStatus">
										<c:if test = "${memberPlay.playFieldNo != 1 }">
										<div class="box">
											<select name="memberPlays[${memberPlaysStatus.count-1}].playFieldNo" class="memberPlay1">
												<!-- <option></option> -->
												<c:forEach items = "${playFields}" var = "playField" varStatus = "status">
													<option 
													 	<c:if test = "${memberPlay.playFieldNo == playField.playFieldNo}">
													 		selected = "selected"
													 	</c:if> 
													 	 value="${playField.playFieldNo}">${playField.playFieldName}
													</option>
												</c:forEach>
											</select>
											<input style = "display:none;" type="text" name="memberPlays[${memberPlaysStatus.count-1}].playFieldName" value = "${memberPlay.playFieldName}" class="direct_input plr_10 ml_10">
											<img src='../resources/images/join/ico_minus.png' class='minus2 vertMid'>
										</div>
										</c:if>
										<div class="clear"></div>
										<c:if test = "${memberPlay.playFieldNo == 1 }">
										<div class="box">
											<select name="memberPlays[${memberPlaysStatus.count-1}].playFieldNo" class="memberPlay1">
												<!-- <option></option> -->
												<c:forEach items = "${playFields}" var = "playField" varStatus = "status">
													<option <c:if test = "${memberPlay.playFieldNo == playField.playFieldNo}">selected = "selected"</c:if> value="${playField.playFieldNo}">${playField.playFieldName} </option>
												</c:forEach>
												</select>
											<input type="text" name="memberPlays[${memberPlaysStatus.count-1}].playFieldName" value = "${memberPlay.playFieldName}" class="direct_input plr_10 ml_10">
											<img src='../resources/images/join/ico_minus.png' class='minus2 vertMid'>
											</div>
										</c:if>
										<div class="clear"></div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<span id="alert6" class="dp_none ml_30 fc_red">연주분야를 선택해주세요</span>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="mt_50 textC">
				 <input type="button" id="bt_cancel" class="btn btn-red fc_white btn-ms" value="취소"> 
				 <input type="button" id="bt_confirm" class="btn btn-red fc_white btn-ms" value="저장">
			</div>
		</form>
		<!-- 이미지 전송 폼 -->
		<form action="/music/upload/profile" method="post" enctype="multipart/form-data" id="profile_image_upload" name="profile_image_upload" class="dp_none">
			<input type="file" name="profileImage" id="file_upload">
		</form>
	 </div>
</div>

<script type="text/javascript" src=" http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
<script type="text/javascript" src="../resources/common/old/js/jquery.ui.map.js"></script>
<script type="text/javascript" src="../resources/common/old/js/jquery.geocomplete.js"></script>
<script type="text/javascript" src="../resources/common/old/js/jquery.form.js"></script>
<script type="text/javascript" src="../resources/common/old/js/profile_ch.js"></script>	
<%@ include file="../include/bottom.jsp" %>	

