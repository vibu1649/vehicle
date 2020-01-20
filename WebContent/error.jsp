<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR</title>
<link rel="stylesheet" href="css/error.css">
</head>
<body>
	<div id="header"></div>
	<div id="content" align="center">
		<table>
			<tr>
				<td><img src="images/Error.bmp" /></td>
				<td class="ERROR_VL"><%=request.getAttribute("message")%>.&nbsp;
				</td>
			</tr>
		</table>
	</div>
	<div id="footer"></div>
</body>
</html>