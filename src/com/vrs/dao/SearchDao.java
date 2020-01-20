package com.vrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;
import com.vrs.util.DbUtil;
import com.vrs.model.VehicleTO;

public class SearchDao {

	
	private Connection connection;
	public static final Logger LOG = Logger.getLogger("UserDao");
	
	public ArrayList<String> search(String value)
	{
		
		ArrayList<String> al=new ArrayList<String>();
		LOG.info("Inside - method search in SearchDao class");
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement(); 
			result = statement.executeQuery("select "+value+" from vehicles;"); 
			while (result.next()) {
				 al.add(result.getString(value));
			}
			LOG.info("Exit - method search in SearchDao class");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return al;

}
	
	public List<VehicleTO> searchItem(String first,String second)
	{
		System.out.println("in search dao");
		List<VehicleTO> list=new ArrayList<VehicleTO>();
		LOG.info("Inside - method search in SearchDao class");
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			System.out.println("in try");
			statement = connection.createStatement(); 
//			statement.setString(1, first);
			if(Character.isDigit(second.charAt(0)))
				result = statement.executeQuery("select * from vehicles where "+first+"="+second+";");
//				statement.setInt(2, Integer.parseInt(second));
			else
				result = statement.executeQuery("select * from vehicles where "+first+"='"+second+"';");
//				statement.setString(2,second);
			while (result.next()) {
				VehicleTO vehiclebean=new VehicleTO();
				vehiclebean.setManufacturer_Name(result.getString(1));
				vehiclebean.setEx_Showroom_Price(String.valueOf(result.getInt(2)));
				vehiclebean.setColor(result.getString(3));
				vehiclebean.setSeating_Capacity(String.valueOf(result.getInt(4)));
				vehiclebean.setBranch_Location(result.getString(5));
				vehiclebean.setVehicle_code(result.getString(6));
				vehiclebean.setNo_of_vehicles_available(String.valueOf(result.getInt(7)));
				vehiclebean.setStock_Lasting_Date(result.getString(8));
				list.add(vehiclebean);
				System.out.println(list);
				
			}
			LOG.info("Exit - method search in SearchDao class");
			return list;
			
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("after in search dao");
		return list;

}	
}