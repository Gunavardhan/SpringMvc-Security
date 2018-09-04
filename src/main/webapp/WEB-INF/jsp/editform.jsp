<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Edit page</h3>
	<form action="updateStudent" method="post">
		Name : <input type="text" name="stdName" value="${editRecrd.getStdName()}"></br>
		Password  : <input type="password" name="pwd" value="${editRecrd.getPwd()}"/></br>
		Mobile : <input type="text" name="mobile" value="${editRecrd.getMobile()}"/></br>
		<input type="button" value="Update" onclick="updateStudent('${editRecrd.getEmail()}')""/>
		
	</form>
	<script type="text/javascript">
		function updateStudent(email){
			alert(email);
			document.forms[0].action = "updateStudent?email="+email;
			document.forms[0].method = "POST";
			document.forms[0].submit();
		}
	</script>
</body>
</html>