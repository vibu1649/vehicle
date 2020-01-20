<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vrs</title>
<link rel="stylesheet" type="text/css" media="all" href="css/user.css" />
<link href="css/tablestyle.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">


</head>
<body>
	<div id="topbar">
		<table align="right">
			<tr valign="top">
				<td align="left"><li><a href="#"><h3 style="text-align: left;">CONTACT US &nbsp;&nbsp;&nbsp;</h3> </a></li></td>
				<td align="left"><li><a href="logout.jsp"><h3 style="text-align: left;">LOGOUT
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3> </a></li></td>
			</tr>
		</table>
	</div>
	<div id="w">
		<div id="content" class="clearfix">
			<div id="userphoto">
				<img src="images/avatar.png" alt="default avatar">
			</div>
			<h1 style="color: threedshadow;; text-decoration: blink;">
				HELLO
				<%=session.getAttribute("UserID")%>
			</h1>
			<nav id="profiletabs">
			<ul class="clearfix">
				<li><a href="customer.jsp">Home</a></li>
				<li><a href="#" id="profile1" default>Profile</a></li>
				<li><a href="search.jsp" id="search1" >Search Vehicle</a></li>
				<li><a href="myVehicles.jsp">My Vehicles</a></li>
				
			</ul>
			
			
			
			
			
			<section id="profile">
			<form id="pro" action="ProfileController" method="get">
				<p class="setting">
					<span>User ID </span> <input type="text" style="color: black;"
						placeholder="<%=session.getAttribute("UserID")%>"
						disabled="disabled" name="userid" />
				</p>
				<p class="setting">
					<span>User Name </span> <input type="text"
						placeholder="no special charecters" required name="username" />*
				</p>
				<p class="setting">
					<span>Date Of Birth</span><input type="text" id="datepicker"
						name="dob">*
				</p>
				<p class="setting">
					<span>Address</span> <input type="text" placeholder="address"
						required name="address">*
				</p>
				<p class="setting">
					<span>Phone Number </span> <input type="text"
						placeholder="XXX-XXXXXXX" name="phno" required>*
				</p>
				<p class="setting">
					<span>Email Id</span> <input type="text" placeholder="XXXX@XXX.XXX"
						required name="email">*
				</p>
				<p class="setting">
					<span>Occupation</span> <input type="text" placeholder="ocupation"
						required name="ocupation">*
				</p>
				<p class="setting">
					<span><input type="submit" value="Save" id="butt" ></span>
				</p>
				

				<%
					if (!(session.getAttribute("profileentrytrue") == null)) {
				%><div>
					<label style="color: green; font-size: 13px;"> successfully registered </label>
				</div>
				<%	session.removeAttribute("profileentrytrue");}%>
			</form>
		</section>
		</div>
	</div>




	<script type="text/javascript">
		$(function() {
			$('#profiletabs ul li a').on('click', function(e) {
				e.preventDefault();
				var newcontent = $(this).attr('href');
				$('#profiletabs ul li a').removeClass('sel');
				$(this).addClass('sel');
				$('#content section').each(function() {
					if (!$(this).hasClass('hidden')) {
						$(this).addClass('hidden');
					}
				});
				$(newcontent).removeClass('hidden');
			});
		});
	</script>


</body>
</html>