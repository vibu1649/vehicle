package com.vrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.BusinessException;
import com.vrs.model.BookedTO;
import com.vrs.util.DbUtil;

public class BookedDao {
	private Connection connection;
	public static final Logger LOG = Logger.getLogger("UserDao");

	public List<BookedTO> getUserBookings(String userId) throws BusinessException {
		
		System.out.println("in search dao");
		
		List<BookedTO> list=new ArrayList<BookedTO>();
		LOG.info("Inside - method search in SearchDao class");
		ResultSet result = null;
		java.sql.Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			System.out.println("in try");
			statement = connection.createStatement(); 
			result = statement.executeQuery("select * from vehicle_booking where User_id="+userId+";");			
			while (result.next()) {
				BookedTO booked=new BookedTO();
				booked.setVehicle_code(result.getString(2));
				booked.setManufacturer_Name(result.getString(3));
				booked.setEx_showroom_price(String.valueOf(result.getInt(4)));
				booked.setColor(result.getString(5));
				booked.setBooking_status(result.getString(6));
				booked.setBooking_date(result.getString(7));
				booked.setBooking_confirmed_date(result.getString(8));
				booked.setBranch(result.getString(9));
				booked.setComments(result.getString(10));
				list.add(booked);
			}
			String e = null;
			if(list.size()>0){}
			else
				throw new ApplicationException(e);
			LOG.info("Exit - method search in SearchDao class");
			return list;
		
			}
		catch(Exception e){e.printStackTrace();}
		System.out.println("after in search dao");
		return list;
		
	}
	
}
