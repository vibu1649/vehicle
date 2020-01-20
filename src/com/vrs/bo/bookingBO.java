package com.vrs.bo;

import com.vrs.dao.BookingDao;
import com.vrs.model.VehicleTO;

public class bookingBO {

	public void bookVehicle(VehicleTO vehicle, String user) {
		
		BookingDao book =new BookingDao();
		book.book(vehicle,user);
		
	}

}
