<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring mvc registration & login</title>
</head>
<body>
	<div>
	<h1>Registration Login</h1>
	<span><img src="https://cdn.dribbble.com/users/255512/screenshots/2215917/animation.gif" style="width: 45px;height:45px;"/></span>
	</div>
	<form action="registeruser" method="post">
		Student Name : <input type="text" name="stdName"/></br>
		Email : <input type="email" name="email"/></br>
		Password : <input type="password" name="pwd"/></br>
		Mobile : <input type="text" name="mobile"></br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>