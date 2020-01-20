package com.vrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import java.util.logging.Logger;

import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.VehicleTO;
import com.vrs.util.DbUtil;

public class BookingDao {

	private Connection connection;
	public static final Logger LOG = Logger.getLogger("UserDao");
	VehicleTO vehiclebean = new VehicleTO();
	public void book(VehicleTO vehicle, String user) {

		
		String branch = vehicle.getBranch_Location();
		String vehiclecode = vehicle.getVehicle_code();
		
		vehicle.setResult(0);
		System.out.println("in search dao");
		LOG.info("Inside - method search in SearchDao class");
		ResultSet result = null;
		java.sql.PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			System.out.println("in try");
			statement = connection.prepareStatement(QueryConstants.BOOK_QUERY1);
			statement.setString(1, branch);
			statement.setString(2, vehiclecode);
			result = statement.executeQuery();
			if (result.next()) {
				vehiclebean.setManufacturer_Name(result.getString(1));
				vehiclebean.setEx_Showroom_Price(String.valueOf(result.getInt(2)));
				vehiclebean.setColor(result.getString(3));
				vehiclebean.setSeating_Capacity(String.valueOf(result.getInt(4)));
				vehiclebean.setBranch_Location(result.getString(5));
				vehiclebean.setVehicle_code(result.getString(6));
				vehiclebean.setNo_of_vehicles_available(String.valueOf(result.getInt(7)));
				vehiclebean.setStock_Lasting_Date(result.getString(8));

			}
			LOG.info("Exit - method search in SearchDao class");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("after in search dao");

		
		
		
		PreparedStatement preparedStatement=null;
		try {
			Date d=new Date();
			LOG.info("Inside - method addEmp in addCustmerProfileDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.REQUESTED_VEHICLE);
			preparedStatement.setInt(1, Integer.parseInt(user));
			preparedStatement.setString(3, vehiclebean.getManufacturer_Name() );
			preparedStatement.setString(2, vehiclebean.getVehicle_code());
			preparedStatement.setString(4, vehiclebean.getEx_Showroom_Price());
			preparedStatement.setString(5,vehiclebean.getColor());
			preparedStatement.setString(6, "pending");
			preparedStatement.setString(7, d.toString());
			preparedStatement.setString(8, null);
			preparedStatement.setString(9, vehiclebean.getBranch_Location());
			preparedStatement.setString(10, "waiting");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			vehicle.setResult(1);
			LOG.info("Exit - method addUser in CustomerDao class");
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		finally {

			try {
				preparedStatement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		
		
		
		
	}

}
