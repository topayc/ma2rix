<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

                 <!--tab-->
                <div class="tabWrapType1">
                    <ul class="tabBtnSet1">
                        <li><a href="#none"><span>기본정보</span></a></li>
                        <li><a href="#none"><span>음원 및 파일</span></a></li>
                        <li><a href="#none"><span>현황</span></a></li>
                        <li><a href="#none"><span>Comment</span></a></li>
                    </ul>
                    <!-- tabBox1 -->
                    <div class="tabCont">
	                	<table class="tblType01 addTrType2">
                            <colgroup>
                                <col style="width: 20%">
                                <col style="width: 30%">
                                <col style="width: 20%">
                                <col style="width: 30%">
                            </colgroup>
                            <tr>
                            	<th>제목</th>
                                <td colspan="3">${arrangeDetail.arrangeTitle}</td>
                            </tr>
                            <tr>
                                <th>작곡자</th>
                                <td>${arrangeDetail.composeMemberName}</td>
                                <th class="line">편곡수</th>
                                <td>100</td>
                            </tr>
                        </table>
		                <div class="hType1">
		                    <h3>작곡자 메모</h3>
		                </div>  
		                <div class="memoArea">${arrangeDetail.composeMemo}</div>
	                </div>
	                <!-- //tabBox1 -->
                    <!-- tabBox2 -->
                    <div class="tabCont">
                    	<div class="hType1 pt0">
		                    <h3>연관 파일</h3>
		                </div>
		                <div class="needPart">
						    <span class="label label-score">작곡 악보</span>
						    <span class="label label-source">작곡 음원</span>
                        </div>
		            </div>
                    <!-- tabBox2 -->
                    <!-- tabBox3 -->
                    <div class="tabCont">
	                    <table class="tblType03 addTrType2">
                            <colgroup>
                                <col style="width: 10%">
                                <col style="width: 10%">
                                <col style="width: 10%">
                                <col style="width: 15%">
                                <col style="width: auto">
                                <col style="width: 10%">
                            </colgroup>
                            <tr>
                            	<th>연주파트</th>
                                <th>연주자</th>
                                <th>배분율</th>
                                <th>상태</th>
                                <th>상세정보</th>
                                <th>참여가능여부</th>
                            </tr>
                            <tr>
                            	<td><span class="label label-blue">기타</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td>참여가능</td>
                            	<td class="textL">현재 파트는 참여 요청이 가능합니다.</td>
                            	<td><span class="label label-joinOK">참여하기</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-sky">드럼</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td>참여가능</td>
                            	<td class="textL">편곡자에게 참여를 요청했고, 편곡자의 선택을 기다리고 있습니다.</td>
                            	<td><span class="label label-joinDone">참여완료</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-orange">피아노</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td>참여가능</td>
                            	<td class="textL">편곡자가 당신은 연주자로 선택했습니다. 요청 수락을 누르면 확정되며, 연주탈퇴를 누르면 해당 참여가 취소됩니다.</td>
                            	<td><span class="label label-joinCancel">참여취소</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-green">베이스</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td>참여가능</td>
                            	<td class="textL">연주자가 확정되었습니다. 연주곡을 등록할 수 있습니다.</td>
                            	<td><span class="label label-joinAsk">요청수락</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-red">건반</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td>참여가능</td>
                            	<td class="textL">현재 파트는 참여 요청이 가능합니다.</td>
                            	<td><span class="label label-joinOut">연주탈퇴</span></td>
                            </tr>
                        </table>
	                </div>
	                <!-- //tabBox3 -->
                    <!-- tabBox4 -->

						<%@ include file="../include/comment.jsp" %>

                    <!-- tabBox4 -->
                </div>
                <!-- //tab -->