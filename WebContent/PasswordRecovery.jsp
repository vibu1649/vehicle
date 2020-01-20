<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PASSWORD RECOVERY</title>
</head>

<h4 style="direction: center;"> PASSWORD RECOVERY</h4>

<body>
<center>
<%
out.print("Select a secret Question");  
%>
<select>
<option value="1">What is your first school's name?</option>
<option value="2">What is your first best friend's name?</option>
<option value="3">What is your favorite car's name?</option>
<option value="4">What is your first pet's name?</option>
<option value="5">What is your favorite holiday spot?</option>
</select><br>
<%
out.print("Your Answer");
%>
<input type="text" name="Answer">
iterator.
</center>
</body>

</html>