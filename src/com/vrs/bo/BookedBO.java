package com.vrs.bo;

import java.util.List;

import com.vrs.dao.BookedDao;
import com.vrs.exceptions.BusinessException;
import com.vrs.model.BookedTO;

public class BookedBO {

	public List<BookedTO> bookings(String userId) throws BusinessException {
		BookedDao booked =new BookedDao();
		List<BookedTO> userBookings = booked.getUserBookings(userId);
		return userBookings;
		
	}

	
	
}
