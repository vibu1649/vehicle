<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>vrs</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text.css' />
</head>

<body >
<div >
	<div class="main" >
		<div class="header">
			<h1><b>Vehicle Reservation System</b></h1>
		</div>
		<form action="RegistrationController" value="signinform" method="post">
			<ul class="left-form">
				<h2 >New Account:</h2>
				<li><input type="text" placeholder="UserId" required
					name="USERID" /> <a href="#" class="icon ticker"> </a>
					<div class="clear"></div></li>
				<li><input type="password" placeholder="password" name="PASSWORD" required><a href="#" class="icon into"> </a>
					<div class="clear"></div></li>
				<li><input type="password" placeholder="re-enter password" name="PASSWORD2" required /> <a href="#" class="icon into"></a>
					<div class="clear"></div></li>
					<% 
				if(session.getAttribute("error")!=null){ session.removeAttribute("error");
					    %>
					    <p style="color: red;" >password do not match </p><div class="clear"></div>
					    <%} %>
				<li><select class="select" autofocus="autofocus" name="ROLE">
						<option class="option" disabled="disabled" selected="selected">select
							role</option>
						<option>Admin</option>
						<option>customer</option>
				</select></li>
				<div class="clear">
				</div>
				<%  if(session.getAttribute("error1")!=null) {session.removeAttribute("error1"); %>
					    <p style="color: red;" >please select a role </p><div class="clear"></div>
					    <% } %>
				<input type="submit" onclick="" value="Create Account">
				<div class="clear">
			
				</div>
				<%  if(session.getAttribute("success")!=null) {session.removeAttribute("success"); %>
					    <p style="color: green;" >Registration Successful </p><div class="clear"></div>
					    <% } %>
			</ul>
		</form>
		<form action="LoginController" value="loginform" method="post">
			<ul class="right-form">
				<h3>Login:</h3>
				<div>
					<li><input type="text" placeholder="UserId" required
						name="userid" /></li>
					<li><input type="password" placeholder="Password" required
						name="password" />
					</li>
					<h4><a href="#">i forgot my Password!</a></h4>
					<input type="submit" value="Login"></a>
				</div>
				<div class="clear"></div>
			</ul>
			<div class="clear"></div>
		</form>
	</div>
	</div>
</body>
</html>
    