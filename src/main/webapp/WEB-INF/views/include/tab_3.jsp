<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
                <!--tab-->
                <div class="tabWrapType1">
                    <ul class="tabBtnSet1">
                        <li><a href="#none"><span>기본정보</span></a></li>
                        <li><a href="#none"><span>음원 및 파일</span></a></li>
                        <li><a href="#none"><span>현황</span></a></li>
                        <li><a href="#none"><span>작사</span></a></li>
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
                                <th>편곡자</th>
                                <td>메투릭스</td>
                                <th class="line">작곡자</th>
                                <td>${arrangeDetail.composeMemberName}</td>
                            </tr>
                            <tr>
                                <th>장르</th>
                                <td>Rock</td>
                                <th class="line">구성원</th>
                                <td>10</td>
                            </tr>
                            <tr>
                                <th>작사수</th>
                                <td colspan="3">100</td>
                            </tr>
                        </table>
                        <div class="hType1">
		                    <h3>필요 연주 파트</h3>
		                </div>
                        <div class="needPart">
						    <span class="label label-blue">기타</span>
						    <span class="label label-green">베이스</span>
						    <span class="label label-sky">드럼</span>
						    <span class="label label-orange">피아노</span>
						    <span class="label label-red">건반</span>
                        </div>
                        <div class="hType1">
		                    <h3>편곡자 메모</h3>
		                </div>  
		                <div class="memoArea">${arrangeDetail.arrangeMemo}</div>
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
						    <span class="label label-arrange">편곡 음원</span>
						    <span class="label label-guide">가이드 편곡 음원</span>
                        </div>
                        <div class="hType1">
		                    <h3>최종 편곡 음원</h3>
		                    <div class="textR mt20">
			                    <a class="btn large" href="#none"><span>편곡 음원</span></a>
			                    <a class="btn large" href="#none"><span>보컬 가이드 음원</span></a>
			                </div>
		                </div>
		                <div class="listWrap">
							<ul class="arrList">
								<li class="secType1 oh pt0">
									<div class="coverArt">
										<a href="#none"><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 110px; height: 110px;"></a>
									</div>
									<div class="soundArea">
										<div class="soundHeader">
											<a class="bulPlay" href="#none"><i class="fa fa-play-circle fa-2x"></i></a>
											<span class="songTitle">Guitar</span>
											<span class="songSinger"><a href="#none">ahn young chul</a></span>
										</div>
										<!-- 개발에서 확인요망 -->
										<div class="soundBody">
		                                    <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div>
		                                    <div class="soundBar"></div>
										</div>
										<!-- //개발에서 확인요망 -->
									</div>
								</li>
								<li class="secType1 oh pt0">
									<div class="coverArt">
										<a href="#none"><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 110px; height: 110px;"></a>
									</div>
									<div class="soundArea">
										<div class="soundHeader">
											<a class="bulPlay" href="#none"><i class="fa fa-play-circle fa-2x"></i></a>
											<span class="songTitle">Guitar</span>
											<span class="songSinger"><a href="#none">ahn young chul</a></span>
										</div>
										<!-- 개발에서 확인요망 -->
										<div class="soundBody">
		                                    <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div>
		                                    <div class="soundBar"></div>
										</div>
										<!-- //개발에서 확인요망 -->
									</div>
								</li>
							</ul>
						</div>
                        <div class="hType1">
		                    <h3>믹싱 파일</h3>
		                </div>
		                <div class="listWrap">
							<ul class="arrList">
								<li class="secType1 oh pt0">
									<div class="coverArt">
										<a href="#none"><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 110px; height: 110px;"></a>
									</div>
									<div class="soundArea">
										<div class="soundHeader">
											<a class="bulPlay" href="#none"><i class="fa fa-play-circle fa-2x"></i></a>
											<span class="songTitle">Guitar</span>
											<span class="songSinger"><a href="#none">ahn young chul</a></span>
										</div>
										<!-- 개발에서 확인요망 -->
										<div class="soundBody">
		                                    <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div>
		                                    <div class="soundBar"></div>
										</div>
										<!-- //개발에서 확인요망 -->
										<div class="soundFooter">
											<div class="playerMemo">${arrangeDetail.arrangeMemo}</div>
										</div>
									</div>
								</li>
								<li class="secType1 oh">
									<div class="coverArt">
										<a href="#none"><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 110px; height: 110px;"></a>
									</div>
									<div class="soundArea">
										<div class="soundHeader">
											<a class="bulPlay" href="#none"><i class="fa fa-play-circle fa-2x"></i></a>
											<span class="songTitle">Guitar</span>
											<span class="songSinger"><a href="#none">ahn young chul</a></span>
										</div>
										<!-- 개발에서 확인요망 -->
										<div class="soundBody">
		                                    <div class="pajaImg"><img src="../resources/images/arrage/holderType2.gif" class="mb20" alt="" style="width: 100%;"></div>
		                                    <div class="soundBar"></div>
										</div>
										<!-- //개발에서 확인요망 -->
										<div class="soundFooter">
											<div class="playerMemo">${arrangeDetail.arrangeMemo}</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
		            </div>
                    <!-- tabBox2 -->
                    <!-- tabBox3 -->
                    <div class="tabCont">
	                    <table class="tblType03 addTrType2">
                            <colgroup>
                                <col style="width: 25%">
                                <col style="width: auto">
                                <col style="width: 25%">
                                <col style="width: 25%">
                            </colgroup>
                            <tr>
                            	<th>연주파트</th>
                                <th>참여자</th>
                                <th>배분율</th>
                                <th>진행현황</th>
                            </tr>
                            <tr>
                            	<td><span class="label label-blue">기타</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td><span class="label label-gray">등록완료</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-sky">드럼</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td><span class="label label-gray">등록완료</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-orange">피아노</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td><span class="label label-gray">등록완료</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-green">베이스</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td><span class="label label-gray">등록완료</span></td>
                            </tr>
                            <tr>
                            	<td><span class="label label-red">건반</span></td>
                            	<td>GD</td>
                            	<td>10%</td>
                            	<td><span class="label label-gray">등록완료</span></td>
                            </tr>
                        </table>
	                </div>
	                <!-- //tabBox3 -->
                    <!-- tabBox4 -->
                    <div class="tabCont">
                    	<div class="checkSelect floatL mb20">
                            <select class="dropdown">
                                <option value="">Language</option>
                                <option value="">Korea</option>
                                <option value="">English</option>
                            </select>
						</div> 
						<p class="floatL pl10">보시길 원하는 작사의 언어를 선택하세요.</p>
						<div class="mb20 oh clearB">
							<div class="floatL"><i class="fa fa-comment"></i> <span>현재 총 <strong>156</strong> 개의 작사가 등록되어 있습니다.</span></div>
							<div class="floatR"><a href="#none" class="addLineType1 btn topayc"><span>모두보기</span></a></div>
						</div>
						<table class="tblType02 textL addTrType2">
                            <colgroup>
                                <col style="width: 10%">
                                <col style="width: auto">
                            </colgroup>
                            <tr>
                                <td><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 50px; height: 50px;"></td>
                                <td class="textL">
                                	<p class="mb10">What a wonderful world</p>
                                	<div><a href="#">아이디</a></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <!-- tabBox4 -->
                    <!-- tabBox5 -->
						<%@ include file="../include/comment.jsp" %>
                    <!-- tabBox5 -->
                </div>
                <!-- //tab --> 	