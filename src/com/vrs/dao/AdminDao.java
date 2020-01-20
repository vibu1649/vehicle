package com.vrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.util.logging.Logger;


import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.AdminTO;
import com.vrs.model.UserTO;
import com.vrs.util.DbUtil;

public class AdminDao {
	private Connection connection;
	public static final Logger LOG = Logger.getLogger("UserDao");

	
	public List<AdminTO> stock_requests()
	{
	
		List<AdminTO> list1=new ArrayList<AdminTO>();
		LOG.info("Inside - method approved_requests in VehicleDao class");
		final String queryString = QueryConstants.SHOW_STOCK_REQUEST;
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement(); 
			//statement.setString(1, value);
			result = statement.executeQuery(queryString); 
			while (result.next()) {
				//System.out.println(result.getString(1));
				AdminTO adminBean=new AdminTO();
				 adminBean.setVehicle_code(result.getString("Vehicle_code"));
				 adminBean.setManufacturer_Name(result.getString("Manufacturer_Name"));
				 adminBean.setEx_showroom_price(result.getString("Ex_showroom_price"));
				 adminBean.setColour(result.getString("Colour"));
				 adminBean.setNo_of_vehicle_In_stock(result.getString("No_of_vehicles_In_stock"));
				 adminBean.setBranch(result.getString("Branch"));
				 adminBean.setRequest_more_vehiclescol(result.getString("request_more_vehiclescol"));
				list1.add(adminBean);
			}
			LOG.info("Exit - method apprve_requests in VehicleDao class");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {

			try {
				statement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		return list1;
	}


public List<UserTO> pendingRegistrations() {


		System.out.println("in vehicle dao");
		List<UserTO> list1=new ArrayList<UserTO>();
		LOG.info("Inside - pending requests in adminDao class");
		final String queryString = QueryConstants.PENDING_REGISTRATIONS;
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			System.out.println("in vtry");
			connection = DbUtil.getConnection();
			statement = connection.createStatement(); 
			//statement.setString(1, value);
			result = statement.executeQuery(queryString); 
			while (result.next()) {
				//System.out.println(result.getString(1));
				UserTO user=new UserTO();
				 user.setUserid(result.getString(1));
				 user.setRole(result.getString(3));
				 user.setDate(result.getString(5));
				list1.add(user);
			}
			LOG.info("Exit - method apprve_requests in VehicleDao class");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {

			try {
				statement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		return list1;
	}


public int approveRegistrations(String[] userids) {
	
	LOG.info("Inside - aproove requests in adminDao class");
	final String queryString = QueryConstants.PENDING_REGISTRATIONS;
	int result,count=0;
	java.sql.Statement statement = null;
	try {
		connection = DbUtil.getConnection();
		statement = connection.createStatement();
		for(int i=0;i<userids.length;i++){
		result = statement.executeUpdate("update user_details set status='T' where User_id="+Integer.parseInt(userids[i])+";");
		if(result>0)
			count++;
		}
		LOG.info("Exit - method apprve_requests in VehicleDao class");
		}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally {

		try {
			statement.close();
			if(connection!=null)
			{
				connection.close();
			}
		} catch (SQLException sqlException) {
			new DatabaseOperationException(
					sqlException);
		}
	}
	return count;
	
	
	}
public int approveVehicles(String[] userids) {
	
	LOG.info("Inside - aproove requests in adminDao class");
	
	int result,count=0;
	java.sql.Statement statement = null;
	try {
		System.out.println("in try");
		connection = DbUtil.getConnection();
		statement=connection.createStatement();
		for(int i=0;i<userids.length;i++){
			StringTokenizer st=new StringTokenizer(userids[i]);
			String vehiclecode = st.nextToken();
			String branch = st.nextToken();
			int avail=getAvail(vehiclecode,branch);
			int req=getrequests(vehiclecode, branch);
			result = statement.executeUpdate("update vehicles set No_of_vehicles_available="+(avail+req)+" where Branch_Location='"+branch+"' and Vehicle_code='"+vehiclecode+"';");
			statement.executeUpdate("delete from request_more_vehicles where Branch='"+branch+"' and Vehicle_code='"+vehiclecode+"';");
			if(result>0)
				count++;
		System.out.println("after try");
		}
		LOG.info("Exit - method apprve_requests in VehicleDao class");
		}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally {

		try {
			statement.close();
			if(connection!=null)
			{
				connection.close();
			}
		} catch (SQLException sqlException) {
			new DatabaseOperationException(
					sqlException);
		}
	}
	System.out.println("after in admin dao");
	return count;
	
	
	}


private int getAvail(String vehiclecode, String branch) throws SQLException {

	int int1 = 0;
	java.sql.Statement statement = connection.createStatement();
	ResultSet avail = statement.executeQuery("select No_of_vehicles_available from vehicles where Branch_Location='"+branch+"' and Vehicle_code='"+vehiclecode+"';");
	if(avail.next()) {
		int1 = avail.getInt(1);
	}
	return int1;
}

private int getrequests(String vehiclecode, String branch) throws SQLException {

	int int1 = 0;
	java.sql.Statement statement = connection.createStatement();
	ResultSet avail = statement.executeQuery("select request_more_vehiclescol from request_more_vehicles where Branch='"+branch+"' and Vehicle_code='"+vehiclecode+"';");
	if(avail.next()) {
		int1 = avail.getInt(1);
	}
	return int1;
}
}
