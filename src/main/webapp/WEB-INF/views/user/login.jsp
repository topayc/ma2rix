<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/top.jsp" %>
<div class="contents">
	<div class="m_com">
		<h2 class="tit wrap">로그인</h2>
		<div class="login">
			<strong> Enjoy your ma2rix </strong>
			<p class="mt_20 textC">Ma2rix에 오신 것을 환영합니다</p>
			<p class="mt_20 textC">${message.mainMessage}</p>
			<p class="mt_20 textC">${message.subMessage}</p>
			<div class="loginBox">
				<div class="otherLogin">
				 	<a href="javascript:facebooklogin()"><img src="../resources/images/btn_facebook.gif"></a>
				 	<a href="javascript:googlelogin()"><img src="../resources/images/btn_google.gif"></a>
				 </div>
				 <div class="loginArea">
					<form id="login" name="login" method="post">
						<div class="email">
							<input type="text" name="email" id="email" value="${loginCommand.email}" class="selectInput" style="width: 390px;" placeholder="  E-mail을 입력해주세요">
							<p id="alert1" class="vb_hid fc_red">올바른 E-mail을 기입하세요.</p>
						</div>
						<div class="pw">
							<input type="password" name="password" id="password" class="selectInput" style="width: 390px;" placeholder="  Password를 입력해주세요">
							<p id="alert2" class="vb_hid fc_red">비밀번호를 입력해주세요.</p>
						</div>
						<div class="loginKeep">
							<input type="button" class="btnLogin" id="login_box" value="로그인">
							<input type="checkbox" value="keep_login" name="emailcookie" id="emailcookie"><label for="emailcookie">로그인 상태 유지</label>
						</div>
						<input type="hidden" id="loginRoute" name="loginRoute" value="MA">
						<input type="hidden" id="fbusername" name="fbusername">
						<input type="hidden" id="fbemail" name="fbemail">
						<input type="hidden" id="fbuserid" name="fbuserid">
						<input type="hidden" id="gguserid" name="gguserid">
						<input type="hidden" id="ggusername" name="ggusername">
					</form>	
				</div>
			</div>
		 </div>
	<%@ include file="../shared/member_function.jsp" %>
	</div>
</div>

<script type="text/javascript" src="../resources/common/old/js/login.js"></script>	
<script type="text/javascript">
	window.fbAsyncInit = function() {  
	    FB.init({appId: "520960038040634", status: true, cookie: true,xfbml: true});      
	};  
	
	(function(d){  
	   var js, id = "facebook-jssdk", ref = d.getElementsByTagName("script")[0];  
	   if (d.getElementById(id)) {return;}  
	   js = d.createElement("script"); js.id = id; js.async = true;  
	   js.src = "//connect.facebook.net/en_US/all.js";  
	   ref.parentNode.insertBefore(js, ref);  
	 }(document));     
	
	function facebooklogin() {  
	    //페이스북 로그인 버튼을 눌렀을 때의 루틴.  
	  FB.login(function(response) {  
	    var fbname;  
	    var accessToken = response.authResponse.accessToken;  
	    FB.api('/me', function(user) {  
	      $("#loginRoute").val("FB");
	      $("#fbemail").val(user.email);
	      $("#fbusername").val(user.name);
	      $("#login").submit();
	    });   
	  }, {scope: "user_about_me,publish_stream,read_friendlists,offline_access,email,user_birthday"});  
	}  
</script>

<script type="text/javascript">

function googlelogin() 
{
  var myParams = {
    'clientid' : '1067318800169-q3v5722m4b8f7cpoqs4f5sa91lb9u2rq.apps.googleusercontent.com',
    'cookiepolicy' : 'single_host_origin',
    'callback' : 'googleLoginCallback',
    'approvalprompt':'force',
    'scope' : 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
  };
  gapi.auth.signIn(myParams);
}

function onLoadCallback() {
    gapi.client.setApiKey('AIzaSyAC3rwNxdKU2DUzHKEfRNL_3zuJtnXvT8E'); 	//set your API KEY
    gapi.client.load('plus', 'v1',function(){});						//Load Google + API
}

function googleLoginCallback(result)
{
    if(result['status']['signed_in'])
    {
        var request = gapi.client.plus.people.get(
        {
            'userId': 'me'
        });
        request.execute(function (resp)
        {
        	$("#loginRoute").val("GG");
        	$("#ggusername").val(resp['displayName']);
            $("#login").submit();
        });
    }
}
</script>
<script  type="text/javascript">
(function() {
      var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
      po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
    })();
</script>
<%@ include file="../include/bottom.jsp" %>

