<%@page import="com.vrs.model.VehicleTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<li><a href="profile.jsp">Profile</a></li>
				<li><a href="search.jsp"  default>Search Vehicle</a></li>
				<li><a href="myVehicles.jsp">My Vehicles</a></li>
			</ul>
			</nav>



			<section id="search" >
			<form id="selection" action="SearchController" method="get">
				<p>SEARCH A VEHICLE AND BOOK</p>
				<p class="activity">Search By</p>
				<select name="selecttype" id="sel">
					<option value="" disabled="disabled">Select</option>
					<option value="Manufacturer_Name">Manufacturer name</option>
					<option value="Ex_Showroom_Price">showroom price</option>
					<option value="Color">color</option>
					<option value="Seating_Capacity">seating capacity</option>
					<option value="Vehicle_code">Vehicle Code</option>
				</select> <input type="submit" id="button" value="select">
			</form>

			<form id="selection2" action="SearchController" method="post">
				<p class="activity">Select your choice</p>
				<select name="selecttype2">
					<%
					if(!(session.getAttribute("list")==null)){
								        			ArrayList al=(ArrayList<String>) session.getAttribute("list");
								        			for(int i=0;i<Integer.parseInt(String.valueOf(session.getAttribute("size")));i++){
					%>
					<option value="<%=al.get(i)%>"><%=al.get(i)%></option>
					<%
						}
								        			session.removeAttribute("list");session.removeAttribute("size");}
					%>
				</select> <span><input type="submit" value="search" name="search">
				</span>
			</form>
			
			
			
		
			<p><form id="search1" action="bookController" method="get">
				<%
					if(!(session.getAttribute("vehiclesPojo")==null))
						      		{
						  				List<VehicleTO> search_result=(ArrayList<VehicleTO>) session.getAttribute("vehiclesPojo");
				%>
				<table id="table-2">
					<tr>
						<th><lable style="color: dodgerblue; font-size: 13px;">select</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Manufacturer</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Price
							</lable></th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Color</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Capacity</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Location
							</lable></th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Vehicle
							Code</lable></th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Availability</lable>
						</th>
						<th><lable style="color: dodgerblue; font-size: 13px;">Lasting Date</lable>
						</th>
					<tr>
						<%
							for(VehicleTO vehicle: search_result )
										  					{
						%>
						<div>
							<tr>
								<td><input type="radio"  name="book"
									value="<%=vehicle.getBranch_Location()%> <%=vehicle.getVehicle_code()%>" />
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getManufacturer_Name()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getEx_Showroom_Price()%></label>
								</td>
								<td><lable style="font-size: 12px;"><%=vehicle.getColor()%></lable>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getSeating_Capacity()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getBranch_Location()%></label>
								</td>
								<td><label style="font-size: 12px;"><%=vehicle.getVehicle_code()%>
								</label></td>
								<td><label style="font-size: 12px;"><%=vehicle.getNo_of_vehicles_available()%>
								</label></td>
								<td><label style="font-size: 12px;"><%=vehicle.getStock_Lasting_Date()%>
								</label></td>
							</tr>
							<div class="wrapper"></div>
							<%
								}
							%>
				</table>
				<br>
				<div>
					<span><input type="submit" value="book" > </span>
				</div>
				<%
					session.removeAttribute("vehiclesPojo");}
				%>
			</form></p>
			<p><%
					if(!(session.getAttribute("booksuccess")==null)){
				%>
				SUCCESSFULLY BOOKED<% session.removeAttribute("booksuccess");}  %>
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