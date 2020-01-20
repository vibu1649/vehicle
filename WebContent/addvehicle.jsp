<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vrs</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="all" href="css/user.css" />
<link href="css/tablestyle.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
</head>


<body>

	<div id="topbar">
		<table align="right">
			<tr valign="top">
				<td align="left"><li><a href="#"><h3 style="text-align: left;">CONTACT US &nbsp;&nbsp;&nbsp;</h3> </a>
				</li>
				</td>
				<td align="left"><li><a href="logout.jsp"><h3 style="text-align: left;">LOGOUT
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3> </a>
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
				HELLO <%=session.getAttribute("UserID")%>
			</h1>
			<nav id="profiletabs">
			<ul class="clearfix">
				<li><a href="home.jsp">Home</a></li>
				<li><a href="Admin.jsp">Requested Stock</a></li>
				<li><a href="#addvehicle">Add Vehicle</a></li>
				<li><a href="userregistrations.jsp">Approve logins</a>
				</li>
			</ul>
			</nav>
	
	
			
		<section id="addvehicle" >
			<form id="pro" action="AddVehicleController" method="post">
				<p class="setting">
					<span>Manufacturer </span> <input type="text" style="color: black;" name="Manufacturer" required/>
				</p>
				<p class="setting">
					<span>Price</span> <input type="text" placeholder="no special charecters" required name="Price" />*
				</p>
				<p class="setting">
					<span>Color</span><input type="text" name="Color">*
				</p>
				<p class="setting">
					<span>Seating Capacity</span> <input type="text" placeholder="address" required name="Seating Capacity">*
				</p>
				<p class="setting">
					<span>Branch</span> <input type="text" placeholder="XXX-XXXXXXX" name="Branch" required>*
				</p>
				<p class="setting">
					<span>Vehicle Code</span> <input type="text" placeholder="XXXX@XXX.XXX" required name="Vehicle Code">*
				</p>
				<p class="setting">
					<span>Number of Vehicles</span> <input type="text" placeholder="ocupation" required name="Number of Vehicles">*
				</p>
				<p class="setting">
					<span>Stock_Lasting_Date</span> <input type="text" placeholder="ocupation" required name="Stock_Lasting_Date">*
				</p>
				<p class="setting">
					<span><input type="submit" value="Add Vehicle" id="butt" ></span>
				</p>
				<%if (!(session.getAttribute("vehicleentrytrue")==null)) {
				%><div>
					<label style="color: green; font-size: 13px;"> successfully registered </label>
				</div>
				<%	session.removeAttribute("vehicleentrytrue");}%>
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