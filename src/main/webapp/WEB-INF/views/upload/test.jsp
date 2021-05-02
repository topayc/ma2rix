<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta property="og:title" content="" />
	<meta property="og:description" content="" />
	<meta property="og:url" content="" />
	<meta property="og:type" content="article" />
	<meta property="og:site_name" content="" />
	
	<link href="../resources/_common/css/common.css" rel="stylesheet" type="text/css" />
	<link href="../resources/_common/css/login.css" rel="stylesheet" type="text/css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/js/header.js"></script>
	
	<script type="text/javascript" src="../resources/js/jquery.jscroll.js"></script>
	<script type="text/javascript" src="../resources/js/jscroll.jquery.json"></script>	
		
	<script type="text/javascript" src="../resources/js/login.js"></script>
	
	<script src="http://malsup.github.com/jquery.form.js"></script>	
	
<script>				 
$('.scroll').jscroll();
</script>	
	
</head>
<body>
<div id="wrap">
    <!---------- header------------->
    <!---------- header------------->
    <div id="header">
    	<div class="m_main">
	     	<div id="gnb">
	    		<h1 id="logo"><a href="#"><img src="../resources/_images/logo.png" /></a></h1>
	    		<form action="#"name="find_ma2rix" id="find_ma2rix" method="post" class="find">
	    			<input type="text" placeholder="온라인 음악제작사이트 Ma2rix" />
	    			<span class="tooltip"></span>
	    		</form>
	    		<ul id="nav">
	    			<li><a href="compose.html"><img src="../resources/_images/header/compose_off_.png" /><br /><span>작곡</span></a></li>
	    			<li><a href="arrange.html"><img src="../resources/_images/header/ing_arrange_off_.png" /><br /><span>진행중인 편곡</span></a></li>
	    			<li><a href="comp_arr.html"><img src="../resources/_images/header/complete_arrange_off_.png" /><br /><span>왼료된 편곡</span></a></li>
	    			<li><a href="songlist.html"><img src="../resources/_images/header/song_list_off_.png" /><br /><span>곡 리스트</span></a></li>
	    		</ul>
	    		<ul class="f_right">
	    			<li><a href="login.html">로그인</a></li>
	    			<li><a href="join_step1.html">회원가입</a></li>
	    		</ul>
	    		
	    		
	    	   <!--	 로그인 후  <ul class="f_right" 
	    			<li><a href="#"><img src="_images/top_ico1.png" /></a></li>
	    			<li><a href="#"><img src="_images/top_ico2.png" /></a></li>
	    			<li><a href="#"><img src="_images/top_ico3.png" /></a></li>
	    		 </ul> -->
	    		 
	    		 
	    	</div>
    	</div>
    </div><!-- header -->
    <!---------- container------------->
    <div id="container">
		<div id="content">
			<div class="m_com">
				<h3 class="tit wrap">업로드 테스트  </h3>
				<div class="pw">
					<div class="t_center">
																
								<!-- 업로드 폼 -->																
								<div  style="border:1px solid #000000;width:200px;height:35px">								
								<form name="upload" id="upload" method="get">
									<input type="hidden" name="uploadType" id="uploadType" value="1" />
									<input type="hidden" name="musciClassNo" id="musciClassNo" value="1" />
									<input type="hidden" name="musicNo" id="musicNo" value="1" />
									<input type="text" name="uloadFile" id="uloadFile" />																																
									<input type="button" onclick="javascript:upload_chk()" value="업로드"/>								
								</form>								
								</div>
									
								<!-- 실제 업로드 폼 -->																
								<div id="upload_div" style="display:none;border:1px solid #000000;width:100px;height:100px">
								<form name="uploadForm" id="uploadForm" method="post" encytype="multipart/form-data">
									<input type="file" name="r1" id="r1" class="file"/>
								</form>		
								</div>
								
																																

<script type="text/javascript">

function upload_chk(){
		real_chk();		//ajax 업로드 폼 호출!
}


function real_chk(){
	
	  $('.file').click();		
	  $('.file').change(function(){                             //업로드할 파일을 선택 할 경우 동작을 일으킵니다.
		   var form = $('#uploadForm');
		   form.ajaxSubmit({
		             url: '/music/upload/upload',
		             data: form.serialize(),                    //폼의 값들을 주소화하여 보내게 됩니다.
		             type: 'POST',
		             success:function(data){
					 alert(data);					 
//		         	 $('.file').val('');                     
//		             console.log(data);                      
		       		},
		   			error:function(data, e){
						alert(e);		   				
		   			}		   
		   });
		  });		
}
</script> 


					</div>
				 </div>
				 
				 
				 <div class="login_bottom wrap mt_30 t_center mt_50">
					<div class="b_inline">
						<form method="get" name="find_id" id="find_id" action="id_sh">
							<span><img src="../resources/_images/login/arrow.png" /><span>
							<span class="ml_5"> 아이디를 잊으셨나요? </span>
							<input type="submit" class="btn-ms2 ml_10"  value="아이디 찾기" />  
					  </form>
					</div>
					<div class="b_inline ml_30">
						<form method="get" name="find_pass" id="find_pass" action="pass_sh">
							<span><img src="../resources/_images/login/arrow.png" /><span>
							<span class="ml_5"> 비밀번호를 잊으셨나요?</span>
							<input type="submit" class="btn-ms2 ml_10"  value="비밀번호 찾기" />  
						</form>
					</div>
					<div class="b_inline ml_30">
						<form method="get" name="GotoJoin" id="GotoJoin" action="join_step1">
							<span><img src="../resources/_images/login/arrow.png" /><span>
							<span class="ml_5"> ma2rix회원이 아니신가요? </span>
							<input type="submit" class="btn-ms2 ml_10"  value="회원가입" />  
						</form>
					</div>	
				</div>
			</div>
		</div><!--content-->
		<div id="footer">온라인 음원 제작 사이트 MA2RIX <br>Copyrightⓒ. 2014. MA2RIX. All Rights Reserved. </div>
	</div><!--container-->
</div>
</html>

