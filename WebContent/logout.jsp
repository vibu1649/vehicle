<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<center><b><label style="font-size: 20px;color: green;">SUCCESSFULLY LOGGED OUT</label></b><br><br>
<a href="index.jsp">login</a></center>
</h1>
<%session.invalidate(); %>
</body>
</html>