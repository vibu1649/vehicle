package com.vrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Logger;

import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.CustomerTO;
import com.vrs.model.VehicleTO;
import com.vrs.util.DbUtil;

public class AddVehicleDao {

	private Connection connection;
	public static final Logger LOG = Logger.getLogger("CustomerProfileBO");
	
	public void addNewVehicle(VehicleTO vehicle) {
			PreparedStatement preparedStatement=null;
			try {
				LOG.info("Inside - method addNewVehicle in addNewVehicleDao class");
				connection = DbUtil.getConnection();
				preparedStatement = connection.prepareStatement(QueryConstants.ADD_NEW_VEHICLE);
				preparedStatement.setString(1, vehicle.getManufacturer_Name());
				preparedStatement.setString(2, vehicle.getEx_Showroom_Price());
				preparedStatement.setString(3, vehicle.getColor());
				preparedStatement.setString(4, vehicle.getSeating_Capacity());
				preparedStatement.setString(5, vehicle.getBranch_Location());
				preparedStatement.setString(6, vehicle.getVehicle_code());
				preparedStatement.setString(7, vehicle.getNo_of_vehicles_available());
				preparedStatement.setString(8, vehicle.getStock_Lasting_Date());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				System.out.println("inserted");
				LOG.info("Exit - method addUser in CustomerDao class");
			} catch (Exception Ex) {
				Ex.printStackTrace();
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
