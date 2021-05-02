<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>
<script type="text/javascript" src="../resources/common/js/join_step3.js"></script>

<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">회원가입</h2>
		<ul class="wrap tab tab_bg2">
			<li class="step1 step"><span>약관동의</span></li>
			<li class="step2 step"><span class="fc_white">회원정보입력</span></li>
			<li class="step3 step"><span>가입완료</span></li>
		</ul>
		<form id="step3_form" name="step3_form"  method="post">
			<table class="join">
				<colgroup>
					<col width="140px" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>email</th>
					<td>
						<div class="ml_10 wrap">
							<input type="text" name="email" id="email" class="w_300" />
							<input type="button" id="overlap_chk1" class="overlap vertMid ml10" value="중복확인">
							<span id="alert1" class="dp_none ml_30 fc_red">Email을 입력해주세요</span>
							<span id="alert10" class="dp_none ml_30 fc_red">사용불가능한 Email입니다</span>
							<span id="alert11" class="dp_none ml_30 fc_red">Email 중복확인이 필요합니다</span>
							<span id="alert14" class="dp_none ml_30 fc_red">유효한 Email이 아닙니다</span>
							<span id="allow1" class="dp_none ml_30 fc_green">사용가능한 Email입니다</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>Password</th>
					<td>
						<div class="ml_10 wrap">
							<input type="password" name="password" id="password" class="w_300 plr_10">
							<span id="alert2" class="dp_none ml_30 fc_red">비밀번호를 입력해주세요</span>
							<span id="alert8" class="dp_none ml_30 fc_red">비밀번호가 일치하지 않습니다</span>
							<span id="alert15" class="dp_none ml_30 fc_red">비밀번호는6~10자로 입력해야 합니다</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>Password 확인</th>
					<td>
						<div class="ml_10 wrap">
							<input type="password" name="passwordConfirm" id="passwordconfirm" class="w_300 plr_10">
							<span id="alert3" class="dp_none ml_30 fc_red">비밀번호 확인을 입력해주세요</span>
							<span id="alert9" class="dp_none ml_30 fc_red">비밀번호가 일치하지 않습니다</span>
							<span id="alert16" class="dp_none ml_30 fc_red">비밀번호는6~10자로 입력해야 합니다</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>
						<div class="ml_10 wrap">
							<input type="text" name="name" id="name" class="w_300 plr_10">
							<span id="alert4" class="dp_none ml_30 fc_red">이름을 입력해주세요</span>
							<span id="alert18" class="dp_none ml_30 fc_red">이름은 50자 이내로 입력해야 합니다</span>
						</div>
					</td>
				</tr>
				<tr>
					<th>NickName</th>
					<td>
						<div class="ml_10 wrap">
							<input type="text" name="nickName" id="nickName" class="w_300 plr_10">
							<input type="button" id="overlap_chk2" class="overlap ml10" value="중복확인">
							<span id="alert5" class="dp_none ml_30 fc_red">닉네임을 입력해주세요</span>
							<span id="alert12" class="dp_none ml_30 fc_red">사용불가능한 닉네임입니다</span>
							<span id="alert13" class="dp_none ml_30 fc_red">닉네임 중복확인이 필요합니다</span>
							<span id="allow2" class="dp_none ml_30 fc_green">사용가능한 닉네임 입니다</span>
							<span id="alert17" class="dp_none ml_30 fc_red">닉네임은 50자 이내로 입력해야 합니다</span>
						</div>
					</td>
				</tr>
				<tr class="hide">
					<th>활동분야</th>
					<td>
						<div class="ml_10 wrap">
							<c:forEach items = "${activities}" var = "activity" varStatus = "status">
								<c:choose>
									<c:when test = "${activity.codeNo == '01'}">
										<label><input type="checkbox" value="${activity.codeNo}" name="activities" checked="checked"  
											class="playFields" />&nbsp;${activity.codeName}&nbsp;&nbsp;</label>
									</c:when>
									<c:when test = "${activity.codeNo == '03'}">
										<label><input type="checkbox" value="${activity.codeNo}" id="chk_bt" name="activities"  
											class="playFields" />&nbsp;${activity.codeName}&nbsp;&nbsp;</label>
									</c:when>
									<c:otherwise>
										<label><input type="checkbox" value="${activity.codeNo}" name="activities"  
											class="playFields" />&nbsp;${activity.codeName}&nbsp;&nbsp;</label>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						<span id="alert6" class="dp_none ml_30 fc_red">활동분야를 선택해주세요</span>
					</div>
					<input type="hidden" id="chk" value="0" />
				</td>
			</tr>
			<tr class="hide1">
				<th>연주분야</th>
				<td>
					<div class="ml_10 wrap box_wrap">
						<span class="hypen mb10"> * 자신의 연주 가능 분야를 여러 개 선택할 수 있습니다.</span>
						<img src="../resources/images/ico_plus.png" class="plus vertMid">
						<div class="clear"></div>
						<div class="box">
							<select name="memberPlay1" class="memberPlay1">
								<option></option>
								<c:forEach items = "${playFields}" var = "playField" varStatus = "status">
									<option value="${playField.playFieldNo}">${playField.playFieldName}</option>
								</c:forEach>
								</select>
								<input type="text" name="memberPlay2" class="direct_input plr_10 memberPlay2">
							</div>
							<span id="alert7" class="dp_none ml_30 fc_red">연주분야를 선택해주세요</span>
							<div class="clear"></div>
						</div>
					</td>
				</tr>
			</table>	
		</form>
		<div class="wrap mt_30">
			<input type="submit" id="submit" class="btn btn-red btn-ms f_right fc_white fs_13" value="다음">
		</div>
	</div> 
</div>
	
<%@ include file="../include/bottom.jsp" %>


	
