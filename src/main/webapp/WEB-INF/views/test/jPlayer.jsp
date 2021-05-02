<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Funny Teiklr</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #bbb;
      }
    
      .container > footer p {
        text-align: center; /* center align it with the container */
      }
      
        .container {
        width:80%; /* center align it with the container */
      }
      
      

      /* The white background content wrapper */
      .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */
        -webkit-border-radius: 0 0 10px 10px;
           -moz-border-radius: 0 0 10px 10px;
                border-radius: 0 0 10px 10px;
        -webkit-box-shadow: 0 0 5px 5px rgba(0,0,0,.15);
           -moz-box-shadow: 0 0 5px 5px rgba(0,0,0,.15);
                box-shadow: 0 0 5px 5px rgba(0,0,0,.15);
      }

      /* Page header tweaks */
      .page-header {
        background-color: #f5f5f5;
        padding: 20px 20px 10px;
        margin: -20px -20px 20px;
        border-bottom-width: 7px;
        border-bottom-color: #bbb;
        
      }

      /* Styles you shouldn't keep as they are for displaying this base example only */
      .content .span,
      .content .span3 {
        min-height: 500px;
      }
      /* Give a quick and non-cross-browser friendly divider */
      .content .span3 {
        margin-left: 0;
        padding-left: 19px;
        border-left: 1px solid #eee;
      }

      .topbar .btn {
        border: 0;
      }
      img {
       margin: 10px;
        -webkit-box-shadow: 0 3px 3px rgba(0,0,0,.15);
           -moz-box-shadow: 0 3px 3px rgba(0,0,0,.15);
                box-shadow: 0 3px 3px rgba(0,0,0,.15);
      }
      
      .show {
      	display:block;
      }
      
      .hide {
      	display:none;
      }
    </style>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
    
     <link type="text/css" href="/music/skin/jplayer.blue.monday.css" rel="stylesheet" />
 	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
 	 <script type="text/javascript" src="/music/js/jquery.jplayer.min.js"></script>
 	 <script type="text/javascript" src="/music/js/ma2rixplayer.js"></script>
  	 <script type="text/javascript">
    	$(document).ready(function(){
    		var ma2 = new Ma2rixInit('#jquery_jplayer_1');
    		var sources = 'http://www.jplayer.org/audio/m4a/Miaow-07-Bubble.m4a;http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg'
    		$('#play').click(function(){
    			ma2.startAuido(sources);
    			 
    		});
    		
    		$('#stop').click(function(){
    			  ma2.stopAudio();
    		});
    		
    		$('#controll').click(function(){
    		   if ($('#jp_container_1').attr('class').indexOf('show') > 0){
    			   $('#jp_container_1').removeClass('show');  
    			   $('#jp_container_1').addClass('hide');  
    		   }else{
    			   $('#jp_container_1').removeClass('hide');  
    			   $('#jp_container_1').addClass('show');  
    		   }
    		});
   
    });
  </script>
  </head>

  <body>
	
    <div  id="jquery_jplayer_1" class="jp-jplayer"></div>
	  <div id="jp_container_1" class="jp-audio show"  >
	    <div class="jp-type-single">
	      <div class="jp-gui jp-interface">
	        <ul class="jp-controls">
	          <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
	          <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
	          <li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
	          <li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
	          <li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
	          <li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
	        </ul>
	        <div class="jp-progress">
	          <div class="jp-seek-bar">
	            <div class="jp-play-bar"></div>
	          </div>
	        </div>
	        <div class="jp-volume-bar">
	          <div class="jp-volume-bar-value"></div>
	        </div>
	        <div class="jp-time-holder">
	          <div class="jp-current-time"></div>
	          <div class="jp-duration"></div>
	          <ul class="jp-toggles">
	            <li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
	            <li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
	          </ul>
	        </div>
	      </div>
	      <div class="jp-details">
	        <ul>
	          <li><span class="jp-title">test</span></li>
	        </ul>
	      </div>
	      <div class="jp-no-solution">
	        <span>Update Required</span>
	        To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
	      </div>
	    </div>
 	 </div>
 
 	 <button id ="controll"> controll</button>&nbsp;
 	 <button id ="play">play</button>&nbsp;
 	 <button id ="stop">stop</button>
  </body>
</html>