package com.vrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import com.vrs.constants.QueryConstants;
import com.vrs.util.DbUtil;
import com.vrs.model.*;

public class VehicleDao {

	private Connection connection;
	public static final Logger LOG = Logger.getLogger("UserDao");
	VehicleTO vehicleBean=new VehicleTO();
	
	public List<VehicleTO> approved_requests()
	{
		System.out.println("in vehicle dao");
		List<VehicleTO> list=new ArrayList<VehicleTO>();
		LOG.info("Inside - method approved_requests in VehicleDao class");
		final String queryString = QueryConstants.SELECT_APPROVED;
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			System.out.println("in vtry");
			connection = DbUtil.getConnection();
			statement = connection.createStatement(); 
			//statement.setString(1, value);
			result = statement.executeQuery(queryString); 
			while (result.next()) {
				System.out.println(result.getString(1));
				 vehicleBean.setManufacturer_Name(result.getString("Manufacturer_Name"));
				 vehicleBean.setEx_Showroom_Price(result.getString("Ex_Showroom_Price"));
				 vehicleBean.setColor(result.getString("Color"));
				 vehicleBean.setSeating_Capacity(result.getString("Seating_Capacity"));
				 vehicleBean.setBranch_Location(result.getString("Branch_Location"));
				 vehicleBean.setVehicle_code(result.getString("Vehicle_code"));
				 vehicleBean.setNo_of_vehicles_available(result.getString("No_of_vehicles_available"));
				 vehicleBean.setStock_Lasting_Date(result.getString("Stock_Lasting_Date"));
				 list.add(vehicleBean);
				
			}
			LOG.info("Exit - method apprve_requests in VehicleDao class");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("after in vehicle dao");
		return list;

}
}
