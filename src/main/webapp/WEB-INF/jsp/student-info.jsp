<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Information</h2>
	<hr>
	<h4>Name : ${getStdInfo.getStdName()}</h4>
	<h4>Email : ${getStdInfo.getEmail()}</h4>
	<h4>Password : ${getStdInfo.getPwd()}</h4>
	<h4>Mobile : ${getStdInfo.getMobile()}</h4>
</body>
</html>