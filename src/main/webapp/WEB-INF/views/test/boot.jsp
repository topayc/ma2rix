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
      
      

    </style>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
  </head>

  <body>

    <div class="navbar navbar-fixed">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Teiklr</a>
          <ul class="nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">Category</a></li>
            <li><a href="#about">MemberShip Community</a></li>
              <li><a href="#about">About Teiklr</a></li>
            <li><a href="#contact">Contact</a></li>
            <li>
            	<form class="form-search navbar-form ">
 				 <div class="input-append">
				    <input type="text"  style ="width:200px;margin-left: 50px" class="span2 search-query">
				    <button type="submit" class="btn btn-info">Search</button>
				  </div>
				</form>
            </li>
          </ul>
          <button class="btn btn-primary pull-right" style ="margin-left: 10px" type="submit">Sign up</button>
          <form action="" class="form-search navbar-form pull-right">
            <input class="input-small" type="text" placeholder="Username">
            <input class="input-small" type="password" placeholder="Password">
            <button class="btn btn-success" type="submit">Sign in</button>
          </form>
          
        </div>
      </div>
    </div>

    <div class="container ">
      <div class="content">
        <div class="page-header">
          <h1>Teiklr <small>에 오신것을 환영합니다.</small></h1>
        </div>
        <div class="row-fluid">
          <div class="span9">
            <h4>새로운 소식들이 많이 올라와 있습니다</h4>
            <img width ="200" height= "200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYKM-Z-tti8HzBxAq7XSCY2zozSYANii9x-dBIfj09-fgmbp2Htw" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRBJGjJqpAhnqo1yD0VsVdaEx4fxU4w1WLpE5HioOGIze5jv29XQA" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcT5pSoYtjcFJYV78bUF6WeHg8DaPPLGqZV8OQ75zvIk2xdSvMCH" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcROzrEqU_zUtiQIW1WwR7uR76gFvrm2gYY0pk2fpfrPsWClAy8SGQ" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRa1-zcf98f5Lo_Bu_FxwtfBEqCE3QSZunfRtGS2U-ZTx-qJN_Z" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4_B38OalfBZT7-mNHgeHvxUH3lZJ0uwDVRp7NQpPKnK1LxNU" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ9SjqxSgK6fK74r-lD_lOA0qtsJJ8r32PPlJe6jatM9iBRBtRw" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcToOkbDL8AwOCs-7yCnNiM2shTDc-LrBvFVNCUrOwDhB9Jy9U_n" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSFe5ts5kRRuRufRBnWRP5Cl5wroIFWDnPID9SUaNmLbWfH05fiyQ" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRYpODPVv4SCDlPzZAUH91hoN0RVkNgxA_TkzK6maESdqHYAZQtlw" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQu8f7E6TwtYprfur0Hbv4caVs3rfYQSqpUVg72vH3vWRWKyns-mw" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYKM-Z-tti8HzBxAq7XSCY2zozSYANii9x-dBIfj09-fgmbp2Htw" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRBJGjJqpAhnqo1yD0VsVdaEx4fxU4w1WLpE5HioOGIze5jv29XQA" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcT5pSoYtjcFJYV78bUF6WeHg8DaPPLGqZV8OQ75zvIk2xdSvMCH" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcROzrEqU_zUtiQIW1WwR7uR76gFvrm2gYY0pk2fpfrPsWClAy8SGQ" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRa1-zcf98f5Lo_Bu_FxwtfBEqCE3QSZunfRtGS2U-ZTx-qJN_Z" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4_B38OalfBZT7-mNHgeHvxUH3lZJ0uwDVRp7NQpPKnK1LxNU" class="img-rounded">
            <img width ="200" height= "200" src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ9SjqxSgK6fK74r-lD_lOA0qtsJJ8r32PPlJe6jatM9iBRBtRw" class="img-rounded">
          </div>
          <div class="span3" >
          <blockquote>
          	
          	<p>Teiklr Category</p>
           <small>원하는 카테고리를 맘대로 제한없이 추가할 수 있습니다</small>
          </blockquote>
          	 <ul>
				  <li>car</li>
				  <li>travel</li>
				  <li>house</li>
				  <li>love</li>
				  <li>offline</li>
				  <li>lent</li>
				  <li>flower</li>
				        
				</ul>
          </div>
	         
        </div>
      </div>

      <footer>
        <br>
        <p>&copy; Teiklr  2014</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>