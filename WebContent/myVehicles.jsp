<%@page import="java.util.ArrayList"%>
<%@page import="com.vrs.model.BookedTO"%>
<%@page import="java.util.List"%>

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
				<td align="left"><li><a href="#"><h3	style="text-align: left;">CONTACT US &nbsp;&nbsp;&nbsp;</h3>
					</a>
				</li>
				</td>
				<td align="left"><li><a href="logout.jsp"><h3 style="text-align: left;">LOGOUT
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
				<li><a href="customer.jsp">Home</a>
				</li>
				<li><a href="profile.jsp" >Profile</a>
				</li>
				<li><a href="search.jsp" >Search Vehicle</a>
				</li>
				<li><a href="myVehicles.jsp" default>My Vehicles</a>
				</li>
				
			</ul>
			</nav>
<section id="home">


</section>

<section id="myvehicles">

<p><form  action="MyvehicleController" method="post">
<input type="submit" value="click to view booked vehicles">
</p>

<p>
				<%
					if(!(session.getAttribute("myvehicle")==null))
						      		{
						  				List<BookedTO> list=(ArrayList<BookedTO>) session.getAttribute("myvehicle");
				%>
				<table id="table-2">
					<tr>
						<th><lable style="color: dodgerblue; font-size: 13px;">vehicle Code</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Manufacturer</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Price
							</lable></th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Color</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Status</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Booked on</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Approved date
							</lable></th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Branch</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Comments
							</lable></th>
					<tr>
						<%
							for(BookedTO vehicle: list )
										  					{
						%>
						<div>
							<tr>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getVehicle_code()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getManufacturer_Name()%></label>
								</td>
								<td><lable style="font-size: 12px;"><%=vehicle.getEx_showroom_price()%></lable>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getColor()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getBooking_status()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getBooking_date()%>
								</label></td>
								<td><label style="font-size: 12px;"><%=vehicle.getBooking_confirmed_date()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getBranch()%>
								</label></td>
								<td><label style="font-size: 12px;"><%=vehicle.getComments()%>
								</label></td>
							</tr>
							<div class="wrapper"></div>
							<%}
						      		}
						else if(!(session.getAttribute("err")==null)){
							%> <h2 style="color:red; font-size: 14px;">No Booked Vehicles </h2>  <% 
							
							%>
						
				</table>
				<br>
				<div>
				</div>
				<%
					session.removeAttribute("vehiclesPojo");}
				%>
			</form></p>


</section>




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

