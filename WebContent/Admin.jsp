<%@page import="com.vrs.bo.AdminBO"%>
<%@page import="com.vrs.model.AdminTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList,com.vrs.model.VehicleTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
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
                <td align="left"><li><a href="logout.jsp"><h3 style="text-align: left;">LOGOUT &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3> </a>
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
                    HELLO
                    <%= session.getAttribute("UserID")%>
                </h1>
                <nav id="profiletabs">
                    <ul class="clearfix">
                        <li><a href="home.jsp">home</a></li>
                        <li><a href="Admin.jsp">Requested Stock</a></li>
                        <li><a href="addvehicle.jsp">Add Vehicle</a></li>
                        <li><a href="userregistrations.jsp">Approve logins</a></li>
                    </ul>
                </nav>





                <section id="stockadd" >
                    <form action="AdminController" method="post">
                        <p>
                        <table id="table-2">
                            <tr>
                                <th><lable style="color: dodgerblue; font-size: 15px;">Vehicle Code</lable></th>
                            <th><lable style="color: dodgerblue; font-size:  15px;">Manufacturer</lable>
                            </th>
                            <th><lable style="color: dodgerblue; font-size: 15px;">Price</lable>
                            </th>
                            <th><lable style="color: dodgerblue; font-size: 15px;">Colour</lable>
                            </th>
                            <th><lable style="color: dodgerblue; font-size: 15px;">availablity</lable>
                            </th>
                            <th><lable style="color: dodgerblue; font-size: 15px;">Branch</lable>
                            </th>
                            <th><lable style="color: dodgerblue; font-size: 15px;">number requested </lable>
                            </th>
                            </tr><%
                                List<AdminTO> show_list = (List<AdminTO>) new AdminBO().stock_requests();
                                for (AdminTO admin : show_list) {%><tr>
                                <td><label style="font-size: 12px;"><%=admin.getVehicle_code()%></label>
                                </td>
                                <td><label style="font-size: 12px;"><%=admin.getManufacturer_Name()%></label>
                                </td>
                                <td><lable style="font-size: 12px;"><%=admin.getEx_showroom_price()%></lable>
                            </td>
                            <td><label style="font-size: 12px;"><%=admin.getColour()%></label>
                            </td>
                            <td><label style="font-size: 12px;"><%=admin.getNo_of_vehicle_In_stock()%></label>
                            </td>
                            <td><label style="font-size: 12px;"><%=admin.getBranch()%>
                                </label></td>
                            <td><label style="font-size: 12px;"><%=admin.getRequest_more_vehiclescol()%>
                                </label></td>
                            <td><input type="checkbox" value="<%=admin.getVehicle_code()%> <%=admin.getBranch()%>" name="approve"></td>
                            </tr>
                            <%}
                                if (!(session.getAttribute("successveh") == null)) {
                            %>  <p> <lable style="color:green; font-size: 14px">Successfully update</lable></p><%session.removeAttribute("successveh");
                                    }
                                %>

                        </table></p><p>
                            <input type="submit" value="update">
                        </p>
                    </form>
                </section>
            </div>
        </div>

        <script>
            $(function () {
                $('#profiletabs ul li a').on('click', function (e) {
                    e.preventDefault();
                    var newcontent = $(this).attr('href');
                    $('#profiletabs ul li a').removeClass('sel');
                    $(this).addClass('sel');
                    $('#content section').each(function () {
                        if (!$(this).hasClass('hidden')) {
                            $(this).addClass('hidden');
                        }
                    });
                    //$(newcontent).removeClass('hidden');
                });
            });
        </script>
    </body>
</html>

