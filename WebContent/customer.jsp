
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
				<td align="left"><li><a href="#"><h3 style="text-align: left;">CONTACT US &nbsp;&nbsp;&nbsp;</h3>
					</a>
				</li>
				</td>
				<td align="left"><li><a href="logout.jsp" ><h3 style="text-align: left;">LOGOUT
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
					</a>
				</li>
				</td>
			</tr>
		</table>
	</div>
	<div id="w">
		<div id="content" class="clearfix">
			<div id="userphoto">
				<img src="images/avatar.png" alt="default avatar">
			</div>
			<h1 style="color: threedshadow;; text-decoration: blink;">
				HELLO &nbsp;
				<%= session.getAttribute("UserID") %>
			</h1>
			<nav id="profiletabs">
			<ul class="clearfix">
			<li><a href="customer.jsp" default>Home</a>
				</li>
				<li><a href="profile.jsp" >Profile</a>
				</li>
				<li><a href="search.jsp" >Search Vehicle</a>
				</li>
				<li><a href="myVehicles.jsp">My Vehicles</a>
				</li>
			</ul>
			</nav>

		</div>
		<!-- @end #content -->
	</div>
	<!-- @end #w -->




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

