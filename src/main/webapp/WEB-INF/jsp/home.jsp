<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function getAllUsers(){
		alert("getAll users");
		document.forms[0].action = "getallusers";
		document.forms[0].method = "GET";
		document.forms[0].submit();
	}
</script>
<style type="text/css">

.navbar-inverse {
    background-color: #392179;
    border-color: #392179;
}

.form-body{
    background:#fff;
    padding:20px;
}
.login-form{
    background:rgba(255,255,255,0.8);
	padding:20px;
	border-top:3px solid#3e4043;
}
.innter-form{
	padding-top:20px;
}
.final-login li{
	width:50%;
}

.nav-tabs {
    border-bottom: none !important;
}

.nav-tabs>li{
	color:#222 !important;
}
.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus {
    color: #fff;
    background-color: #d14d42;
    border: none !important;
    border-bottom-color: transparent;
	border-radius:none !important;
}
.nav-tabs>li>a {
    margin-right: 2px;
    line-height: 1.428571429;
    border: none !important;
    border-radius:none !important;
	text-transform:uppercase;
	font-size:16px;
}

.sa-innate-form input[type=text], input[type=password], input[type=file], textarea, select, email{
    font-size:13px;
	padding:10px;
	border:1px solid#ccc;
	outline:none;
	width:100%;
	margin:8px 0;
	
}
.sa-innate-form input[type=submit]{
    border:1px solid#e64b3b;
	background:#e64b3b;
	color:#fff;
	padding:10px 25px;
	font-size:14px;
	margin-top:5px;
	}
	.sa-innate-form input[type=submit]:hover{
	border:1px solid#db3b2b;
	background:#db3b2b;
	color:#fff;
	}
	
	.sa-innate-form button{
	border:1px solid#e64b3b;
	background:#e64b3b;
	color:#fff;
	padding:10px 25px;
	font-size:14px;
	margin-top:5px;
	}
	.sa-innate-form button:hover{
	border:1px solid#db3b2b;
	background:#db3b2b;
	color:#fff;
	}
    .sa-innate-form p{
        font-size:13px;
        padding-top:10px;
    }
    .footer-bottom {
    background-color: #15224f;
    min-height: 30px;
    width: 100%;
    
    clear: both;
    position: relative;
    z-index: 10;
    height: 3em;
    margin-top: -3em;
    
}
.copyright {
    color: #fff;
    line-height: 30px;
    min-height: 30px;
    padding: 7px 0;
}
.design {
    color: #fff;
    line-height: 30px;
    min-height: 30px;
    padding: 7px 0;
    text-align: right;
}
.design a {
    color: #fff;
}
</style>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!-- <link rel="stylesheet" href="/custome-style.css"> -->
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #402e7538;">
	<nav class="navbar navbar-inverse" style="background-color: #392179;border-color: #392179;border-radius: none">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">WebSiteName</a>
	    </div>
	  </div>
	</nav>
	<div class="container">
	<div class="row">
		<h2 style="text-align: center;color:#f7990e">Login / Registration form</h2>
		<hr>
	</div>
</div>
<br>
<br>
<div class="container">
<div class="row">
<div class="col-md-4 col-md-offset-4">
<div class="form-body">
    <ul class="nav nav-tabs final-login">
        <!-- <li class="active"><a data-toggle="tab" href="#sectionA">Sign In</a></li> -->
        
        <li><a data-toggle="tab" href="#sectionB">Register</a></li>
    </ul>
    <div class="tab-content">
        <div id="sectionA" class="tab-pane fade in active">
        	<%-- <div class="innter-form">
        	<font color="green"><h4>${succMsg}</h4></font>
        	<font color="red"><h5>${message}</h5></font>
            <form class="sa-innate-form" action="login" method="post">
            <label>Email Address</label>
            <input type="text" name="email">
            <label>Password</label>
            <input type="password" name="pwd">
            <button type="submit">Sign In</button>
            <!-- <a href="">Forgot Password?</a> -->
            </form>
            </div> --%>
            <div class="clearfix"></div>
        </div>
        <div id="sectionB" class="tab-pane fade">
			<div class="innter-form">
            <form class="sa-innate-form" method="post" action="registeruser">
            <label>Name</label>
            <input type="text" name="stdName" required="required">
            <label>Email Address</label>
            <input type="text" name="email" required="required">
            <label>Password</label>
            <input type="password" name="pwd" required="required">
            <label>Mobile</label>
            <input type="text" name="mobile" required="required">
            <button type="submit">Register</button>&nbsp;&nbsp;
            <button type="button" onclick="getAllUsers()">GET All USERS</button>
            </form>
            </div>
        </div>
    </div>
    </div>
    </div>
    </div>
    </div>
	<div class="footer-bottom">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<div class="copyright">
					© 2018, All rights reserved
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<div class="design">
					 <a href="#"> </a>Students Management System&nbsp;<a target="_blank" href="https://www.facebook.com/gunavardhan.reddygujjula">Web Design & Development by Gunavardhan</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>